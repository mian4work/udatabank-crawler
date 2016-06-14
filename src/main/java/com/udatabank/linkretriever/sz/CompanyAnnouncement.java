package com.udatabank.linkretriever.sz;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by miazhang on 6/7/16.
 */
public class CompanyAnnouncement implements Serializable {

    Integer symbol;
    String url;
    String title;
    String format;
    Integer number;
    Date date;
    Timestamp time;

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
