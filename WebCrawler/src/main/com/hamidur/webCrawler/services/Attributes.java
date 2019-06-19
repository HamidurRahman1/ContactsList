package com.hamidur.webCrawler.services;

public enum Attributes
{
    //admin level attributes
    admin,
    timeTakenToFindLinks, timeTakenToFindWords, timeTakenToInsert, crawledPages, indexingHistories, queriesHistories,

    // admin level page attributes
    BackToAdminAccess, CrawlerForm, GetAllIndexedUrls, GetAllQueries, SignOutAdmin,

    // user level attributes
    pages, query, timeTakenToFindPages,

    // user level page attributes
    BackToIndex, AdminOption, SearchQueryForm, AboutSARA, LoginForm
}
