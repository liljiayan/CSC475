package com.project.foodrecipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.foodrecipes.R;
import com.project.foodrecipes.model.ModelMain;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<ModelMain> items;
    private MainAdapter.onSelectData onSelectData;
    private Context mContext;

    public interface onSelectData {
        void onSelected(ModelMain modelMain);
    }

    public MainAdapter(Context context, List<ModelMain> items, MainAdapter.onSelectData xSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = xSelectData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_categories, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ModelMain data = items.get(position);

        //Get Image
        Glide.with(mContext)
                .load(data.strCategoryThumb)
                .placeholder(R.drawable.ic_food_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgCategory);

        holder.tvCategory.setText(data.strCategory);
        holder.cvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Class Holder
    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCategory;
        public CardView cvCategory;
        public ImageView imgCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            cvCategory = itemView.findViewById(R.id.cvCategory);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            imgCategory = itemView.findViewById(R.id.imgCategory);
        }
    }

}
