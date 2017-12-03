package dotafriendly.usth.edu.vn.dotafriendly;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sony on 11/27/2017.
 */

public class NewsAdapter extends BaseAdapter {
    private ArrayList<NewsItem> newsItems;
    private LayoutInflater layoutInflater;
    private Context context;

    public NewsAdapter(Context context, ArrayList<NewsItem> newsItems) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.newsItems = newsItems;
    }

    @Override
    public int getCount() {
        return newsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return newsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        TextView news_title;
//        TextView news_url;
        TextView author;
        TextView feedlabel;
//        TextView contents;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder newsHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.news_item, null);
            newsHolder = new ViewHolder();
            newsHolder.news_title = convertView.findViewById(R.id.news_title);
            newsHolder.author = convertView.findViewById(R.id.author);
            newsHolder.feedlabel = convertView.findViewById(R.id.feedlabel);
//            newsHolder.contents = convertView.findViewById(R.id.contents);
            convertView.setTag(newsHolder);
        }
        else {
            newsHolder = (ViewHolder)convertView.getTag();
        }

        NewsItem newsItem = this.newsItems.get(i);
        newsHolder.news_title.setText(newsItem.news_title);
        newsHolder.author.setText(newsItem.author);
//        newsHolder.contents.setText(Html.fromHtml(newsItem.contents));

        return convertView;
    }

}
