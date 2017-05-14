package id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews;

import com.orm.SugarRecord;

/**
 * Created by Rokerecekecek on 10/05/2017.
 */

public class ListItem extends SugarRecord {
    private String head;
    private String desc;
    private String image;


    public ListItem(String head, String desc, String image) {
        this.head = head;
        this.desc = desc;
        this.image = image;

    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }
}
