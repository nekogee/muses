package com.example.administrator.testlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentUserWishlist extends Fragment {
    private List<UserAlbum> userAlbumList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAlbumAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_album, container, false);
        recyclerView =  view.findViewById(R.id.recyclerView_user);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initAlbums();

        adapter = new UserAlbumAdapter(userAlbumList, new UserAlbumAdapter.onRecyclerViewItemClick() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(v.getContext(),"clicked",Toast.LENGTH_SHORT).show();
            }
        });

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    private void initAlbums() {

        UserAlbum userAlbum1 = new UserAlbum(R.drawable.warmsun,"WarmSun");
        userAlbumList.add(userAlbum1);
        UserAlbum userAlbum2 = new UserAlbum(R.drawable.bluesong,"Blue Songs");
        userAlbumList.add(userAlbum2);
        UserAlbum userAlbum3 = new UserAlbum(R.drawable.lonely,"Lonely");
        userAlbumList.add(userAlbum3);
        UserAlbum userAlbum4 = new UserAlbum(R.drawable.rap,"Rap");
        userAlbumList.add(userAlbum4);
        UserAlbum userAlbum5 = new UserAlbum(R.drawable.rock,"Rock");
        userAlbumList.add(userAlbum5);

    }
}


