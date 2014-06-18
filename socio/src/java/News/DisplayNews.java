/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

/**
 *
 * @author noones
 */
public class DisplayNews {

    private Boolean priority;
    private String newsId;
    private String newsCategory;
    private String headLine;
    private String metaDescription;
    private String sourceLink;
    private String sourceDomain;
    private String imageThumbs;
    private String newsContent;
    private String newsTime;
    private String path;

// constructor
    public DisplayNews() {
        this.imageThumbs = path + "default." + "png";
    }

    public void setSourceDomain(String sourceDomain) {
        this.sourceDomain = sourceDomain;
    }

    public String getSourceDomain() {
        return sourceDomain;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public Boolean isPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public String getImageThumbs() {
        return imageThumbs;
    }

    public void setImageThumbs(String imageThumbs) {
        this.imageThumbs = imageThumbs;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

}
