package com.hamidur.webCrawler.dao;

import com.hamidur.webCrawler.models.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class WordDao
{
    private Connection connection;
    private int lastInsertedWordId;

    public WordDao(Connection connection)
    {
        this.connection = connection;
    }

    public boolean insertWord(Word word) throws SQLException
    {
        final String sql = "insert into Words (word) values (?)";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, word.getWord());
            Word isExistWord = getWordObjByWord(word.getWord());
            if(isExistWord == null)
            {
                preparedStatement.executeUpdate();
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
                {
                    if (generatedKeys.next())
                    {
                        this.setLastInsertedWordId(generatedKeys.getInt(1));
                        word.setWordId(getLastInsertedWordId());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Map<Word, Integer> insertWords(Set<Word> words) throws SQLException
    {
        final String sql = "insert into Words (word) values (?)";
        Map<Word, Integer> wordsIds = new LinkedHashMap<>();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            for(Word word : words)
            {
                preparedStatement.setString(1, word.getWord());
                Word isExistWord = getWordObjByWord(word.getWord());
                if(isExistWord != null)
                {
                    wordsIds.put(isExistWord, isExistWord.getWordId());
                }
                else
                {
                    if (preparedStatement.executeUpdate() >= 1)
                    {
                        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
                        {
                            if (generatedKeys.next())
                            {
                                this.setLastInsertedWordId(generatedKeys.getInt(1));
                                word.setWordId(getLastInsertedWordId());
                                wordsIds.put(word, getLastInsertedWordId());
                            }
                        }
                    }
                }
            }
        }
        return wordsIds;
    }

    public Set<Word> insertWordsSet(Set<Word> words) throws SQLException
    {
        final String sql = "insert into Words (word) values (?)";
        Set<Word> insertedWords = new LinkedHashSet<>();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            for(Word word : words)
            {
                preparedStatement.setString(1, word.getWord());
                Word isExistWord = getWordObjByWord(word.getWord());
                if(isExistWord != null)
                {
                    insertedWords.add(isExistWord);
                }
                else
                {
                    preparedStatement.executeUpdate();
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
                    {
                        if (generatedKeys.next())
                        {
                            this.setLastInsertedWordId(generatedKeys.getInt(1));
                            word.setWordId(getLastInsertedWordId());
                            insertedWords.add(word);
                        }
                    }
                }
            }
        }
        return insertedWords;
    }

    public Word getWordObjByWord(String word) throws SQLException
    {
        Word wordObj = null;
        final String sql = "select wordId, word from Words where word like ?";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, word);
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                if(resultSet.next())
                {
                    wordObj = new Word();
                    wordObj.setWordId(resultSet.getInt(1));
                    wordObj.setWord(resultSet.getString(2));
                    return wordObj;
                }
            }
        }
        return wordObj;
    }

    private void setLastInsertedWordId(int lastInsertedWordId)
    {
        this.lastInsertedWordId = lastInsertedWordId;
    }

    public int getLastInsertedWordId()
    {
        return lastInsertedWordId;
    }
}
