package id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Rokerecekecek on 13/05/2017.
 */

public class LikeItem extends SugarRecord implements Serializable {
    public String judul;
    public String deskripsi;
    public String urlgambar;

    public LikeItem() {

    }


    public LikeItem(String judul, String deskripsi, String urlgambar) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.urlgambar = urlgambar;
    }


}
