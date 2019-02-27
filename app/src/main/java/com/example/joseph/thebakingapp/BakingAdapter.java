package com.example.joseph.thebakingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BakingAdapter extends RecyclerView.Adapter<BakingAdapter.BakingViewHolder> {

    // Add a private int variable called numberOfItems
    private int mRes;
    private ArrayList<String> mData;
    private Context mContext;

    // This gets called when each new ViewHolder is created. This happens when the RecyclerView is laid out.
    // Enough ViewHolders will be created to fill the screen and allow for scrolling.
    // @param viewGroup The ViewGroup that these ViewHolders are contained within.
    // @param viewType If your RecyclerView has more than one type of tiem (which ours doesn't) you can
    //                  use this viewType integer to provide a different layout. See
    //                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(intI)}
    //                  for more details
    // @return      A new BakingViewHolder that holds the View for each list item


    @Override
    public BakingAdapter.BakingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        BakingViewHolder vh = new BakingViewHolder(v);
        return vh;
    }

    //Create a constructor for BakingAdapter that accepts an int as a parameter for numberOfItems which stores
    // the numberofItems parameter in mNumberOfItems
    public BakingAdapter(Context c,int resource, ArrayList<String> data){
       mContext = c;
        mData = data;
        mRes = resource;

    }

    //OnBindViewHolder is called by the RecyclerView to dispay the data at the specified position. In this method,
    // update the contents of the ViewHoder to display the correct indices in the list for this particular position,
    // using the 'position' argument that is conveniently passed into us.
    @Override
    public void onBindViewHolder(BakingViewHolder holder, int position) {
        holder.bind(position);
    }




    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Provides a reference to the views for each data item
    // Complex data items may need more than one view per item, and you provide access to all the
    // views for a data item in a view holder
    public class BakingViewHolder extends RecyclerView.ViewHolder{
        TextView ingredients;

        public BakingViewHolder(View itemView) {
            super(itemView);
            ingredients = (TextView)itemView.findViewById(R.id.ing);
        }

        void bind(int listIndex){
           // ingredients.setText(String.valueOf(listIndex));
            ingredients.setText(mData.get(listIndex));
        }
    }
}