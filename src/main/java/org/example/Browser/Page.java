package org.example.Browser;

public class Page {
    private String url;

    public Page(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
