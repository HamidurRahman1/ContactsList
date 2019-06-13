package com.hamidur.webCrawler.models;

import java.util.Objects;

public class Word
{
    private int wordId;
    private String word;

    public Word() {}

    public Word(String word) {
        setWord(word);
    }

    public Word(int wordId, String word) {
        this.wordId = wordId;
        this.word = word;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return this.getWord().equals(word1.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord());
    }

    @Override
    public String toString()
    {
        return "Word{" +
                "wordId=" + wordId +
                ", word='" + word + '\'' +
                '}';
    }
}
