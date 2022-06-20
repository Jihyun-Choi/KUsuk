package com.korea.kusuk;

public class ListViewItem {

    private String titleStr ;
    private String dateStr ;
    private String contentStr ;

    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDate(String date) {
        dateStr = date ;
    }
    public void setContent(String content) {
        contentStr = content ;
    }

    public String getContent() {
        return this.contentStr ;
    }
    public String getDate() {
        return this.dateStr ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
}