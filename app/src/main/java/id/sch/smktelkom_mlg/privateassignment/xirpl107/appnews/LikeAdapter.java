package id.sch.smktelkom_mlg.privateassignment.xirpl107.appnews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Rokerecekecek on 14/05/2017.
 */

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.ViewHolder> {
    private final Context context;
    ArrayList<LikeItem> fItem;

    public LikeAdapter(ArrayList<LikeItem> fItem, Context context) {
        this.context = context;
        this.fItem = fItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.like_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final LikeItem favouriteItem = fItem.get(position);
        holder.textViewHeadfav.setText(favouriteItem.judul);
        holder.textViewDescfav.setText(favouriteItem.deskripsi);
        Glide
                .with(context)
                .load(favouriteItem.urlgambar)
                .into(holder.imageViewOtoffav);

//        holder.buttonDelete.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                final FavouriteItem favouriteItem1 = fItem.get(position);
//                fItem.remove(position);
//                favouriteItem1.delete();
//                FavouriteAdapter.this.notifyDataSetChanged();
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return fItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHeadfav;
        public TextView textViewDescfav;
        public ImageView imageViewOtoffav;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewHeadfav = (TextView) itemView.findViewById(R.id.textViewHeadfav);
            textViewDescfav = (TextView) itemView.findViewById(R.id.textViewDescfav);
            imageViewOtoffav = (ImageView) itemView.findViewById(R.id.imageViewOtoffav);
        }
    }
}
