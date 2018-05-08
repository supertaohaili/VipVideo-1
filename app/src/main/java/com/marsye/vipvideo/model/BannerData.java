package com.marsye.vipvideo.model;

public class BannerData {

    private String imgUrl;
    private String title;
    private String linkUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    @Override
    public String toString() {
        return "BannerData{" +
                "imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                '}';
    }
}
