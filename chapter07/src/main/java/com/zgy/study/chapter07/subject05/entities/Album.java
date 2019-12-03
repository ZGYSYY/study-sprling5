package com.zgy.study.chapter07.subject05.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ZGY <br>
 * @date 2019/12/3 12:00 <br>
 * @description Album <br>
 */
@Entity
@Table(name = "album")
public class Album implements Serializable {

    private Long id;
    private String title;
    private Date releaseDate;
    private int version;
    private Singer singer;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name = "singer_id")
    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
