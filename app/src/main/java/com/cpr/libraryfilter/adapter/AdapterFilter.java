package com.cpr.libraryfilter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cpr.libraryfilter.R;
import com.cpr.libraryfilter.listener.OnFilterListener;
import com.cpr.libraryfilter.model.Filter;
import com.cpr.libraryfilter.utils.FilterConfig;

import java.util.List;

public class AdapterFilter extends RecyclerView.Adapter<AdapterFilter.FilterHolder> {
    private List<Filter> filterList;
    private Context context;
    private OnFilterListener filterSelected;
    private int index = 0;
    private int value;

    public AdapterFilter(Context context, OnFilterListener listener) {
        this.filterList = FilterConfig.getListFilter();
        this.context = context;
        this.filterSelected = listener;
    }


    @NonNull
    @Override
    public FilterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_filter, parent, false
        );
        int height = parent.getMeasuredHeight();
        value = height;
        view.getLayoutParams().width = height;
        view.getLayoutParams().height = height;

        return new FilterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterHolder holder, final int position) {
        final Filter filter = filterList.get(position);
        Glide.with(context).load(filter.getImageFilter())
                .apply(new RequestOptions().override(value, value)).into(holder.imgFilter);
//        holder.imgFilter.setImageResource(filter.getImageFilter());
        holder.txtFilter.setText(filter.getNameFilter());
        holder.cardViewFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterSelected.onFilterClicked(filter);
                index = position;
                notifyDataSetChanged();
            }
        });

        if (index == position) {
            holder.cardViewFilter.setBackgroundResource(R.color.colorYellow);
        } else {

            holder.cardViewFilter.setBackgroundResource(R.color.colorNearGray);
        }
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class FilterHolder extends RecyclerView.ViewHolder {
        private ImageView imgFilter;
        private TextView txtFilter;
        private CardView cardViewFilter;
        public FilterHolder(View itemView) {
            super(itemView);
            imgFilter = itemView.findViewById(R.id.imageViewFilter);
            txtFilter = itemView.findViewById(R.id.txtFilter);
            cardViewFilter = itemView.findViewById(R.id.cardViewFilter);
        }
    }
}
