package com.nekogee.muses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Feed {

    @Id
    @GeneratedValue
    private long fid;

    @Column(nullable = false)
    private long uid;

    private long aid;

    private long sid;

    private String des; // description

    @Column(insertable = false, updatable = false)
    private Date dateCreated;

    public Feed(long uid, long aid, long sid, String des) {
        this.uid = uid;
        this.aid = aid;
        this.sid = sid;
        this.des = des;

    }
}
