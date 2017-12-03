package dotafriendly.usth.edu.vn.dotafriendly;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sony on 11/28/2017.
 */

public class HeroQueue extends Application {
    private RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(this.getApplicationContext());
    }

    public RequestQueue getQueue() {
        return queue;
    }
}
