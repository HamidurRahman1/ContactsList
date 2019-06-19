package com.hamidur.webCrawler.services;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;

public class URLValidator
{
    private String url;

    public URLValidator(String url)
    {
        this.url = url;
    }

    public boolean isValid() throws IllegalArgumentException, IOException
    {
        boolean isValid = false;

        try
        {
            new URL(this.url);
            Connection connection = Jsoup.connect(this.url);
            connection.get();
            isValid = true;
        }
        catch (MalformedURLException ex)
        {
            if(ex.getMessage().contains("unknown protocol"))
            {
                throw new ProtocolException(url + " - contains unknown protocol which is - " +
                        ex.getMessage().split(":")[1]);
            }
            if(ex.getMessage().contains("no protocol"))
            {
                throw new ProtocolException(url + " - does not contain a protocol");
            }
        }
        catch (UnknownHostException ex)
        {
            throw new UnknownHostException("Invalid host name provided, host: " + ex.getMessage());
        }
        catch (IllegalArgumentException ex)
        {
            if(!this.url.matches("^http(s)?://.+"))
                throw new UnknownHostException("Missing // before hostname or invalid host name provided, url: " + this.url);
        }
        catch (ConnectException ex)
        {
            if(ex.getMessage().contains("refused"))
            {
                throw new ConnectException("Invalid host name provided. Connection cannot be established to this host: "
                        + url.split("^http(s)?:(//)?")[1]);
            }
        }

        return isValid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
