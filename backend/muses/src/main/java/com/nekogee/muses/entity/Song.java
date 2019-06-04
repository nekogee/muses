package com.nekogee.muses.entity;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    private String songPath;

    private String coverPath;

    @Column(name = "uids")
    private String userIds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aid")
    private Album album; // albumId

    @Column(name = "albumtype")
    private Byte albumType; // 0 -- single ; 1 -- not single

    @Column(name = "prototype")
    private Byte protocolType;

    @Column(nullable = false)
    private Byte state; // 0 -- under review ; 1 -- normal ; 2 -- blocked ; 3 -- deleted

    public Song(String title, String songPath, String coverPath, String userIds) {
        this.title = title;
        this.songPath = songPath;
        this.coverPath = coverPath;
        this.userIds = userIds;
    }

    public Song(String title, String songPath, String coverPath, String userIds, Album album, Byte albumType, Byte protocolType, Byte state) {
        this.title = title;
        this.songPath = songPath;
        this.coverPath = coverPath;
        this.userIds = userIds;
        this.album = album;
        this.albumType = albumType;
        this.protocolType = protocolType;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Byte getAlbumType() {
        return albumType;
    }

    public void setAlbumType(Byte albumType) {
        this.albumType = albumType;
    }

    public Byte getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Byte protocolType) {
        this.protocolType = protocolType;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
