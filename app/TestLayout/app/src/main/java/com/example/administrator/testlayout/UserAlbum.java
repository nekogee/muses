package com.example.administrator.testlayout;

public class UserAlbum {
    private int albumCover ;
    private String albumName ;


    public UserAlbum(int albumCover , String albumName){
        this.albumCover = albumCover ;
        this.albumName = albumName ;

    }

    public int getAlbumCover(){
        return albumCover;
    }

    public String getAlbumName() {
        return albumName;
    }


}

