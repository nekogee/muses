package com.example.administrator.testlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.AuthorOnceViewHolder> {

    @Override
    public AuthorOnceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.list, parent, false);
        AuthorOnceViewHolder viewHolder = new AuthorOnceViewHolder(childView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AuthorOnceViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 15;
    }


    class AuthorOnceViewHolder extends RecyclerView.ViewHolder {

        //TextView mNickNameView;
        //TextView mMottoView;
        public AuthorOnceViewHolder(View itemView) {
            super(itemView);

            //mNickNameView = (TextView) itemView.findViewById(R.id.tv_nickname);
            //mMottoView = (TextView) itemView.findViewById(R.id.tv_motto);

        }
    }
}

