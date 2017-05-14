package id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Rokerecekecek on 13/05/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    //    private TextView tvHead;
//    private TextView tvDesc;
//    private ImageView iv;
    private List<NewsItem> newsItems;
    private Context context;

    public NewsAdapter(List<NewsItem> newsItems, Context context) {
        this.newsItems = newsItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final NewsItem newsItem = newsItems.get(position);

        holder.tvHead.setText(newsItem.getHeadNews());
        holder.tvDesc.setText(newsItem.getDescNews());


        Glide.with(context)
                .load(newsItem.getImageNews())
                .into(holder.iv);

        holder.linearLayoutNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singleBlogIntent = new Intent(context, NewsActivity.class);
                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                singleBlogIntent.putExtra("Anu", position);
                context.startActivity(singleBlogIntent);

            }
        });

        holder.ibShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Your body here";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(shareIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHead;
        public TextView tvDesc;
        public ImageView iv;
        public LinearLayout linearLayoutNews;
        public ImageButton ibShare;

        public ViewHolder(View itemView) {
            super(itemView);
            tvHead = (TextView) itemView.findViewById(R.id.tvHead);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            linearLayoutNews = (LinearLayout) itemView.findViewById(R.id.linearLayoutNews);
            ibShare = (ImageButton) itemView.findViewById(R.id.ibShare);


        }
    }
}
