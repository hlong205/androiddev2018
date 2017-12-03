package dotafriendly.usth.edu.vn.dotafriendly;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Sony on 11/27/2017.
 */

public class NewsItem {
    private Context context;
    public String news_title;
    public String news_url;
    public String author;
    public String feedlabel;
    public String contents;


    public NewsItem(Context context, String news_title, String news_url, String author,
                    String feedlabel) {
        this.context = context;
        this.news_title = news_title;
        this.news_url = news_url;

        this.author = author;
        this.feedlabel = feedlabel;

//        this.contents = contents;
    }
}
