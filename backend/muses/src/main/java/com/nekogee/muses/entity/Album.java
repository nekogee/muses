package com.nekogee.muses.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "dsc")
    private String description;

    @Column(name = "upid")
    private long uploaderId; // the album's uploader's uid

    @Column(name = "uids")
    private String userIds; // concat artists' uids, the splitter is ';' (e.g. 231234;234156;32541)

    @OneToMany(//fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy="album")
    private List<Song> songs = new ArrayList<>();

    @Column(nullable = false)
    private Byte state; // 0 -- under review ; 1 -- normal ; 2 -- blocked ; 3 -- deleted


}
