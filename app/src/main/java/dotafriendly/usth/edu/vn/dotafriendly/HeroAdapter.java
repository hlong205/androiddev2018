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

public class HeroAdapter extends BaseAdapter {
    private ArrayList<HeroItem> heroItems;
    private LayoutInflater layoutInflater;
    private Context context;

    public HeroAdapter(Context context, ArrayList<HeroItem> heroItems) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.heroItems = heroItems;
    }

    @Override
    public int getCount() {
        return heroItems.size();
    }

    @Override
    public Object getItem(int position) {
        return heroItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        TextView name;
        //        TextView news_url;
        TextView heroid;

//        TextView contents;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder heroHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.hero_item, null);
            heroHolder = new ViewHolder();
            heroHolder.name = convertView.findViewById(R.id.name);
            heroHolder.heroid = convertView.findViewById(R.id.heroid);

//            newsHolder.contents = convertView.findViewById(R.id.contents);
            convertView.setTag(heroHolder);
        }
        else {
            heroHolder = (ViewHolder)convertView.getTag();
        }

        HeroItem heroItem = this.heroItems.get(i);
        heroHolder.name.setText(heroItem.name);
        heroHolder.heroid.setText(heroItem.heroid);
//        newsHolder.contents.setText(Html.fromHtml(newsItem.contents));

        return convertView;
    }

}
