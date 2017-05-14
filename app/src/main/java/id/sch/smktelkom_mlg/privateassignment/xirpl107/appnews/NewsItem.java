package id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews;

import com.orm.SugarRecord;

/**
 * Created by Rokerecekecek on 13/05/2017.
 */

public class NewsItem extends SugarRecord {

    private String headNews;
    private String descNews;
    private String imageNews;

    public NewsItem(String headNews, String descNews, String imageNews) {
        this.headNews = headNews;
        this.descNews = descNews;
        this.imageNews = imageNews;
    }

    public String getHeadNews() {
        return headNews;
    }

    public String getDescNews() {
        return descNews;
    }

    public String getImageNews() {
        return imageNews;
    }
}
