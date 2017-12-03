package dotafriendly.usth.edu.vn.dotafriendly;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class NewsFragment extends Fragment {

    public ArrayList<NewsItem> newsItems = new ArrayList<>();
    public ListView listView;
    public NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View newsView = inflater.inflate(R.layout.fragment_news, container, false);

        newsAdapter = new NewsAdapter(getContext(), newsItems);
        listView = newsView.findViewById(R.id.list);
        listView.setAdapter(newsAdapter);

        ArrayList<String> apiurl = new ArrayList<>();

        //URL List and getting JSON from them
        apiurl.add("http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid=570&format=json");


        for (int i = 0; i < 6; i++) {
            getDataFromSteam(apiurl.get(0), i);
        }



        //Open a new activity when click on a newsItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsItem newsItem = (NewsItem) listView.getItemAtPosition(position);
                Intent intent = new Intent(getContext(),WebViewingActivity.class);
                intent.putExtra("url",newsItem.news_url);
                startActivity(intent);
            }
        });
        return newsView;
    }

    public void getDataFromSteam(String url, final int index) {

        JsonObjectRequest newsRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String news_title = null;
                        String news_url = null;
                        String author = null;
                        String feedlabel = null;
//                        String contents = null;


                        try {
//

                            JSONArray jsonArray = response.getJSONObject("appnews").getJSONArray("newsitems");
                            JSONObject jsonObject = jsonArray.getJSONObject(index);



                            //true JSON extraction begin
                            news_title = jsonObject.getString("title");
                            news_url = jsonObject.getString("url");
                            author = jsonObject.getString("author");
                            feedlabel = jsonObject.getString("feedlabel");
//                            contents = jsonObject.getString("contents");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //parse to the newsItem
                        NewsItem newsItem = new NewsItem(getContext(), news_title, news_url, author, feedlabel);
                        newsItems.add(newsItem);
                        final int position = newsItems.indexOf(newsItem);
                        newsAdapter.notifyDataSetChanged();

                        //Bitmap Listener
//                        Response.Listener<Bitmap>bitmapListener = new Response.Listener<Bitmap>() {
//                            @Override
//                            public void onResponse(Bitmap response) {
//                                newsArrayList.get(position).thumbnail = response;
//                                trendingNewsAdapter.notifyDataSetChanged();
//                            }
//                        };

                        //make Image request
//                        ImageRequest imageRequest = new ImageRequest(
//                                thumbnailJson,
//                                bitmapListener, 0, 0, ImageView.ScaleType.CENTER,
//                                Bitmap.Config.ARGB_8888,null);
//
//                        ((NewsQueueApp)getActivity().getApplication()).getQueue().add(imageRequest);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        ((NewsQueue)getActivity().getApplication()).getQueue().add(newsRequest);//JSON Request
    }
}


/*
public class NewsFragment extends Fragment {

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ArrayList<NewsData> newsData;
    private NewsAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_news, container, false);
        newsData = new ArrayList<>();
        adapter = new NewsAdapter(getContext(), R.layout.news_item, newsData);

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        ArrayList<String> urlList = new ArrayList<>();
        urlList.add("http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid=570&format=json");

        for(int i=0; i < urlList.size(); i++){
            getNewsFromSteam(urlList.get(i));
        }

        return listView;



    }


    private class NewsData {
//        public String gid;
        public String news_title;
        public String url;
//        public String is_external_url;
        public String author;
//        public String contents;
//        public String feedlabel;
//        public String date;
//        public String feedname;
//        public String feed_type;
//        public String appid;

    }



    public class NewsAdapter extends ArrayAdapter<NewsData> {
        public NewsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<NewsData> objects){
            super(context, resource, objects);
        }

        @Override
        public int getCount() {
            return super.getCount();
        }

        @Nullable
        @Override
        public NewsData getItem(int position) {
            return super.getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            return super.getView(position, convertView, parent);
            View view = convertView;
            if (view == null){
                view = getActivity().getLayoutInflater().inflate(R.layout.news_item, null);
            }

            NewsData newsElement = getItem(position);
            ((TextView) view.findViewById(R.id.author)).setText(newsElement.author);
            ((TextView) view.findViewById(R.id.news_title)).setText(newsElement.news_title);
            ((TextView) view.findViewById(R.id.url)).setText(newsElement.url);
//            ((TextView) view.findViewById(R.id.contents)).setText(Html.fromHtml(newsElement.contents));


            return view;
        }
    }


//    public String loadJsonFromAssets(){
//        String json = null;
//        try {
//            InputStream inputStream = getActivity().getAssets().open("news.json");
//            int size = inputStream.available();
//            byte[] buffer = new byte[size];
//            inputStream.read(buffer);
//            inputStream.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex){
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//    }

    public void getNewsFromSteam(String url) {

        Response.Listener<String> listener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.i("DotaFriendly", "Json response" + response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONObject("appnews")
                            .getJSONObject("newsitems")
                            .getJSONArray("0");
                    //            ArrayList<HashMap<String, String>> newsList = new ArrayList<HashMap<String, String>>();
                    //            HashMap<String, String> hashMap;

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject news = jsonArray.getJSONObject(i);
                        NewsData newsElement = new NewsData();

//                        newsElement.gid = news.getString("gid");
                        newsElement.news_title = news.getString("title");
                        newsElement.url = news.getString("url");
//                        newsElement.is_external_url = news.getString("is_external_url");
                        newsElement.author = news.getString("author");
//                        newsElement.contents = news.getString("contents");
//                        newsElement.feedlabel = news.getString("feedlabel");
//                        newsElement.date = news.getString("date");
//                        newsElement.feedname = news.getString("feedname");
//                        newsElement.feed_type = news.getString("feed_type");
//                        newsElement.appid = news.getString("appid");

                        //Add your values in your `ArrayList` as below:
                        //                hashMap = new HashMap<String, String>();
                        //                hashMap.put("gid", gid);
                        //                hashMap.put("title", title);
                        //                hashMap.put("url", url);
                        //                hashMap.put("is_external_url", is_external_url);
                        //                hashMap.put("author", author);
                        //                hashMap.put("contents", contents);
                        //                hashMap.put("feedlabel", feedlabel);
                        //                hashMap.put("date", date);
                        //                hashMap.put("feedname", feedname);
                        //                hashMap.put("feed_type", feed_type);
                        //                hashMap.put("appid", appid);
                        //
                        //                newsList.add(hashMap);

                        newsData.add(newsElement);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                Response.Listener<Bitmap>bitmapListener = new Response.Listener<Bitmap>() {
//                    @Override
//                    public void onResponse(Bitmap response) {
//
//                    }
//                }

                adapter.notifyDataSetChanged();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error", "Error occurred while acquiring data from Yahoo!");
            }
        };

//        StringRequest stringRequest = new StringRequest(apiurl, listener, errorListener);
//
//        queue.add(stringRequest);
    }

}
*/
