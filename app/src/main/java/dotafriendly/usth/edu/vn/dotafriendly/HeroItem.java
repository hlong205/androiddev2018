package dotafriendly.usth.edu.vn.dotafriendly;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Sony on 11/27/2017.
 */

public class HeroItem {
    private Context context;
    public String name;
    public String heroid;


    public HeroItem(Context context, String name, String heroid) {
        this.context = context;
        this.name = name;
        this.heroid = heroid;


//        this.contents = contents;
    }
}
