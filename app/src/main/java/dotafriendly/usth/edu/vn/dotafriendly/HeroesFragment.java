//package dotafriendly.usth.edu.vn.dotafriendly;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.annotation.LayoutRes;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.RecyclerView;
//import android.text.Html;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.ImageRequest;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//public class HeroesFragment extends Fragment {
//
//    public ArrayList<HeroItem> heroItems = new ArrayList<>();
//    public ListView herolistView;
//    public HeroAdapter heroAdapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View heroView = inflater.inflate(R.layout.fragment_heroes, container, false);
//
//        heroAdapter = new HeroAdapter(getContext(), heroItems);
//        herolistView = heroView.findViewById(R.id.list);
//        herolistView.setAdapter(heroAdapter);
//
//        ArrayList<String> apiurl = new ArrayList<>();
//
//        //URL List and getting JSON from them
//        apiurl.add("http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1/?key=F0D1EE390D739319732E0B1FBFA84456&format=json");
//
//
//        for (int i = 0; i < 6; i++) {
//            getDataFromSteam(apiurl.get(0), i);
//        }
//
//
//
//        //Open a new activity when click on a newsItem
//        herolistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                NewsItem newsItem = (NewsItem) herolistView.getItemAtPosition(position);
//                Intent intent = new Intent(getContext(),WebViewingActivity.class);
//                intent.putExtra("url",newsItem.news_url);
//                startActivity(intent);
//            }
//        });
//        return newsView;
//    }
//
//    public void getDataFromSteam(String url, final int index) {
//
//        JsonObjectRequest newsRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        String news_title = null;
//                        String news_url = null;
//                        String author = null;
//                        String feedlabel = null;
////                        String contents = null;
//
//
//                        try {
////                            JSONArray jsonArray = response.getJSONObject("appnews")
////                                    .getJSONArray("newsitems");
////                            JSONObject jsonObject = jsonArray.toJSONObject(jsonArray);
//
////                            JSONObject jsonObject = new JSONObject(response);
////                            JSONArray jsonArray = jsonObject.getJSONObject("appnews")
////                                    .getJSONObject("newsitems")
////                                    .getJSONArray("0");
//
//                            JSONArray jsonArray = response.getJSONObject("appnews").getJSONArray("newsitems");
//                            JSONObject jsonObject = jsonArray.getJSONObject(index);
//
//
//
//                            //true JSON extraction begin
//                            news_title = jsonObject.getString("title");
//                            news_url = jsonObject.getString("url");
//                            author = jsonObject.getString("author");
//                            feedlabel = jsonObject.getString("feedlabel");
////                            contents = jsonObject.getString("contents");
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        //parse to the newsItem
//                        NewsItem newsItem = new NewsItem(getContext(), news_title, news_url, author, feedlabel);
//                        newsItems.add(newsItem);
//                        final int position = newsItems.indexOf(newsItem);
//                        newsAdapter.notifyDataSetChanged();
//
//                        //Bitmap Listener
////                        Response.Listener<Bitmap>bitmapListener = new Response.Listener<Bitmap>() {
////                            @Override
////                            public void onResponse(Bitmap response) {
////                                newsArrayList.get(position).thumbnail = response;
////                                trendingNewsAdapter.notifyDataSetChanged();
////                            }
////                        };
//
//                        //make Image request
////                        ImageRequest imageRequest = new ImageRequest(
////                                thumbnailJson,
////                                bitmapListener, 0, 0, ImageView.ScaleType.CENTER,
////                                Bitmap.Config.ARGB_8888,null);
////
////                        ((NewsQueueApp)getActivity().getApplication()).getQueue().add(imageRequest);
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });
//        ((NewsQueue)getActivity().getApplication()).getQueue().add(newsRequest);//JSON Request
//    }
//}
//
//
