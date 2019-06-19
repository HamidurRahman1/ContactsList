package com.hamidur.webCrawler.test;

import com.hamidur.webCrawler.dao.AdminDao;
import com.hamidur.webCrawler.dao.IndexingHistoryDao;
import com.hamidur.webCrawler.dao.PageDao;
import com.hamidur.webCrawler.dao.SearchHistoryDao;
import com.hamidur.webCrawler.dao.WordDao;
import com.hamidur.webCrawler.models.Admin;
import com.hamidur.webCrawler.models.ExtractData;
import com.hamidur.webCrawler.models.IndexingHistory;
import com.hamidur.webCrawler.models.Page;
import com.hamidur.webCrawler.models.SearchHistory;
import com.hamidur.webCrawler.models.WebCrawler;
import com.hamidur.webCrawler.models.Word;
import com.hamidur.webCrawler.services.DaoService;
import com.hamidur.webCrawler.services.HTMLReader;
import com.hamidur.webCrawler.services.TimeCalculator;
import com.hamidur.webCrawler.services.URLValidator;
import com.hamidur.webCrawler.util.DBUtilities;

import java.io.File;
import java.io.IOException;

import java.net.ConnectException;
import java.net.ProtocolException;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Tester
{

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, Exception
    {
        System.out.println(new HTMLReader("AdminOption.html").getFormAsContent());
    }

    private static void pathTester() throws IOException
    {
        String f = Paths.get("").toString();
        System.out.println(Paths.get("").toAbsolutePath());
        System.out.println(new File(f+"src/main/webapp/forms/AdminOption.html").isFile());
        System.out.println(new HTMLReader("AboutSARA.html").getBody());
    }

    private static void URLTester() throws ProtocolException, IllegalArgumentException, ConnectException, IOException
    {
        URLValidator url = new URLValidator("https://google.com");
        if(url.isValid())
        {
            System.out.println("good to go");
        }
    }

    private static void testDB() throws Exception
    {
        Class.forName(DBUtilities.getDRIVER());
        Connection con = DriverManager.getConnection
                (DBUtilities.getURL()+ DBUtilities.getDATABASE()+ DBUtilities.getQUESTION()+ DBUtilities.getTIMEZONE()+
                                DBUtilities.getAND()+ DBUtilities.getAutoConnect()+ DBUtilities.getAND()+ DBUtilities.getSSL(),
                        DBUtilities.getUserName(), DBUtilities.getPASSWORD());
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from Pages");
        while(rs.next()) System.out.println(rs.getInt(1)+"  "+rs.getString(2));
    }

    private static void crawlLinksAndData() throws Exception
    {
        String url = "https://en.wikipedia.org/wiki/Cricket";
        WebCrawler webCrawler = new WebCrawler(url, 0, 0);
        webCrawler.crawl();
        ExtractData ed = new ExtractData(webCrawler.getCrawledLinks());
        for(String link: ed.getLinksData().keySet())
        {
            Page page = ed.getLinksData().get(link);
            for(Word word: page.getWordFrequency().keySet())
            {
                System.out.println(word.getWord());
            }
        }
    }

    private static void testGetPages()  throws SQLException, ClassNotFoundException
    {
        DaoService daoService = new DaoService(DBUtilities.getConnection());
        List<Page> pages = daoService.getPages("the association");
        pages.forEach(page -> System.out.println(page.getTitle() + " " + page.getUrl() + " " + page.getDescription() + "\n"));
        DBUtilities.closeConnection();
    }

    private static void testSearchQuery()
    {
        String query = "how to do this";
        String words[] = query.split(" ");
        StringBuilder wordLike = new StringBuilder("word like ");

        for(String queryPart : words) wordLike.append("? or word like ");
        wordLike.replace(0, wordLike.length(), wordLike.toString().substring(0, wordLike.toString().length()-14));

        String sql =
                "Select title, url, description from Pages where pageId in " +
                        "(select distinct pageId from Pages_Words where wordId in " +
                            "(select wordId from Words where (" + wordLike.toString() + ")) " +
                        "order by frequency desc)";
        System.out.println(sql);
    }

    private static void insertPage_Words_PagesWords_IndexingHistory() throws SQLException, ClassNotFoundException, IOException, Exception
    {
        Connection connection = DBUtilities.getConnection();
        DaoService daoService = new DaoService(connection);

        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.setStart(System.currentTimeMillis());

        WebCrawler webCrawler = new WebCrawler("https://en.wikipedia.org/wiki/Association_football", 2, 0);
        webCrawler.crawl();

        ExtractData extractData = new ExtractData(webCrawler.getCrawledLinks());
        TreeMap<String, Page> stringPageTreeMap = extractData.getLinksData();

        Set<Page> insertedPages = daoService.insertPages(new LinkedHashSet<>(stringPageTreeMap.values()));

        for(Page page : insertedPages)
        {
            Set<Word> words = daoService.insertWords(page.getWordFrequency().keySet());
            daoService.insertPageWords(page, words, page.getWordFrequency());
        }

        IndexingHistory indexingHistory = new IndexingHistory();
        indexingHistory.setAdmin(daoService.getAdmin(" "));
        indexingHistory.setIndexedPages(insertedPages);
        indexingHistory.setDate(LocalDate.now());

        daoService.insertIndexingHistory(indexingHistory);

        timeCalculator.setEnd(System.currentTimeMillis());
        System.out.println("Successful -> time taken to to do all is " + timeCalculator.getElapsedTime() + " sec(s)");

        DBUtilities.closeConnection();
    }

    private static void insertSearchHistory() throws SQLException, ClassNotFoundException, IOException
    {
        SearchHistory searchHistory1 = new SearchHistory();
        searchHistory1.setQuery("search 3"); searchHistory1.setTotalResultsFound(2);
        searchHistory1.setTimeTakenToFindResults(.2f); searchHistory1.setDate(LocalDate.now());
        SearchHistory searchHistory2 = new SearchHistory();
        searchHistory2.setQuery("search 4"); searchHistory2.setTotalResultsFound(30);
        searchHistory2.setTimeTakenToFindResults(.6f); searchHistory2.setDate(LocalDate.now());
        List<SearchHistory> list = new LinkedList<>();
        list.add(searchHistory1); list.add(searchHistory2);

        SearchHistoryDao searchHistoryDao = new SearchHistoryDao(DBUtilities.getConnection());

        for(SearchHistory searchHistory: list)
        {
            searchHistoryDao.insert(searchHistory);
        }
    }

    private static void getSearchHistory() throws SQLException, ClassNotFoundException, IOException, Exception
    {
        SearchHistoryDao searchHistoryDao = new SearchHistoryDao(DBUtilities.getConnection());
        List<SearchHistory> searchHistories = searchHistoryDao.getAll();
        for(SearchHistory searchHistory: searchHistories)
        {
            System.out.println(searchHistory.getQuery() + " " + searchHistory.getTotalResultsFound() +
                    " " + searchHistory.getTimeTakenToFindResults() + " " + searchHistory.getDate());
        }
        DBUtilities.closeConnection();
    }

    private static void getIndexingHistory() throws SQLException, ClassNotFoundException, IOException, Exception
    {
        IndexingHistoryDao indexingHistoryDao = new IndexingHistoryDao(DBUtilities.getConnection());
        List<IndexingHistory> list = indexingHistoryDao.getAll();
        for(IndexingHistory ih : list)
        {
            Iterator itr = ih.getIndexedPages().iterator();
            Page p = (Page) itr.next();
            System.out.println(ih.getAdmin().getAdminId() + " " + p.getUrl() + " " + ih.getDate());
        }
        DBUtilities.closeConnection();
    }

    private static void insertIndexingHistory() throws SQLException, ClassNotFoundException, IOException, Exception
    {
        Admin admin = new Admin(); admin.setAdminId(1);
        IndexingHistory indexingHistory = new IndexingHistory(admin, getPagesToSet(), LocalDate.now());
        IndexingHistoryDao indexingHistoryDao = new IndexingHistoryDao(DBUtilities.getConnection());
        indexingHistoryDao.insert(indexingHistory);
        DBUtilities.closeConnection();
    }

    private static void getPage() throws SQLException, ClassNotFoundException, IOException, Exception
    {
        DaoService daoService = new DaoService(DBUtilities.getConnection());
        Page page = daoService.getPageByUrl("https://en.wikipedia.org/wiki/Cricket#mw-head");
        System.out.println(page);
        DBUtilities.closeConnection();
    }

    private static void insertWord() throws SQLException, ClassNotFoundException, IOException, Exception
    {
        List<Word> words = Arrays.asList(new Word("D"), new Word("E"), new Word("B"));
        WordDao wordDao = new WordDao(DBUtilities.getConnection());
        for(Word word : words)
        {
            System.out.println(wordDao.insertWord(word));
            System.out.println(wordDao.getLastInsertedWordId());
            System.out.println("----------------------------");
        }
        DBUtilities.closeConnection();
    }

    private static void insertPages() throws SQLException, ClassNotFoundException, IOException, Exception
    {
        WebCrawler webCrawler = new WebCrawler("https://en.wikipedia.org/wiki/Cricket", 2, 0);
        webCrawler.crawl();
        ExtractData ed = new ExtractData(webCrawler.getCrawledLinks());
        System.out.println("----------------------------");
        PageDao pageDao = new PageDao(DBUtilities.getConnection());
        for(String p: ed.getLinksData().keySet())
        {
            Page page = ed.getLinksData().get(p);
            System.out.println(pageDao.insertPage(page));
            System.out.println(pageDao.getLastInsertedPageId());
            System.out.println("----------------------------");
        }
        DBUtilities.closeConnection();
    }

    private static void getAdmin() throws SQLException, ClassNotFoundException
    {
        AdminDao adminDao = new AdminDao(DBUtilities.getConnection());
        Admin admin = adminDao.getAdmin("Hamidur1");
        System.out.println(admin);
        DBUtilities.closeConnection();

    }

    private static Set<Page> getPagesToSet()
    {
        Set<Page> pages = new LinkedHashSet<>();
        Page page1 = new Page("https://en.wikipedia.org/wiki/Cricket"); page1.setPageId(1);
        pages.add(page1);
        Page page2 = new Page("https://en.wikipedia.org/wiki/Cricket#mw-head"); page2.setPageId(2);
        pages.add(page2);
        Page page3 = new Page("https://en.wikipedia.org/wiki/Cricket#p-search"); page3.setPageId(3);
        pages.add(page3);
        Page page4 = new Page("https://en.wikipedia.org/wiki/Cricket_(disambiguation)"); page4.setPageId(4);
        pages.add(page4);
        Page page5 = new Page("https://en.wikipedia.org/wiki/Cricket_(insect)"); page5.setPageId(5);
        pages.add(page5);
        Page page6 = new Page("https://en.wikipedia.org/wiki/Cricketer_(disambiguation)"); page6.setPageId(6);
        pages.add(page6);
        Page page7 = new Page("https://en.wikipedia.org/wiki/Wikipedia:Protection_policy#semi"); page7.setPageId(7);
        pages.add(page7);
        return pages;
    }
}
