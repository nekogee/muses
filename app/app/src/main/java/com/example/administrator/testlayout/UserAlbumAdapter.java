package com.example.administrator.testlayout;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class UserAlbumAdapter extends RecyclerView.Adapter<UserAlbumAdapter.ViewHolder> {
    private List<UserAlbum> mUserAlbumList;
    private Context mContext;

    private onRecyclerViewItemClick mOnRvItemClick;
   /* static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView photoImage;
        TextView photoName;
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            photoImage = view.findViewById(R.id.photo_image);
            photoName = view.findViewById(R.id.photo_name);
        }
    }*/

    public UserAlbumAdapter(List<UserAlbum> UserAlbumList,onRecyclerViewItemClick onRvItemClick) {
        mUserAlbumList = UserAlbumList;
        this.mOnRvItemClick = onRvItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        if(mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_album_item,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        UserAlbum userAlbum = mUserAlbumList.get(position);
        holder.userAlbumName.setText(userAlbum.getAlbumName());

        holder.userAlbumCover.setImageResource(userAlbum.getAlbumCover());

        // holder.photoImage.setImageBitmap(BitmapFactory.decodeFile(photo.getImagePath()));

        //
        // holder.photoImage=photo.getImageId();
        //使用glide加载图片
        //holder.setData(position);
    }

    public interface onRecyclerViewItemClick {
        void onItemClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        ImageView userAlbumCover;
        TextView userAlbumName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            userAlbumCover = view.findViewById(R.id.user_album_cover);
            userAlbumName = view.findViewById(R.id.user_album_name);
            itemView.setOnClickListener(this);
        }

        /*public void setData(int position) {
            textView.setText("第" + position + "行");
        }*/

        @Override
        public void onClick(View view) {
            if (mOnRvItemClick != null)
                mOnRvItemClick.onItemClick(view, getAdapterPosition());
        }
    }
    @Override
    public int getItemCount() {
        return mUserAlbumList.size();
    }
}
