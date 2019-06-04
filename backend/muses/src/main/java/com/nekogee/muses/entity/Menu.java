package com.nekogee.muses.entity;

import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    private int id;

    @Column
    private String url;

    @Column
    private String path;

    @Column
    private String component;

    @Column
    private String name;

}
