package com.zgy.study.chapter07.subject07.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ZGY <br>
 * @date 2019/12/3 12:08 <br>
 * @description Singer <br>
 */
@Entity
@Table(name = "singer")
@NamedQueries({
        @NamedQuery(name = "Singer.findAllWithAlbum", query = "select distinct s from Singer s left join fetch s.albums a left join fetch s.instruments i"),
        @NamedQuery(name = "Singer.findById", query = "select distinct s from Singer s left join fetch s.albums a left join fetch s.instruments i where s.id = :id")
})
public class Singer implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;
    private Set<Album> albums = new LinkedHashSet<>(16);
    private Set<Instrument> instruments = new LinkedHashSet<>(16);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * mappedBy = "singer"：album 是通过表 singer 来进行关联的 <br/>
     * cascade = CascadeType.ALL：更新操作应该级联到子级，意思是当 singer 表中的数据修改后，album 表中的数据也会受影响被修改 <br/>
     * orphanRemoval = true：移除孤儿 <br/>
     * fetch = FetchType.EAGER|FetchType.LAZY：FetchType.LAZY 为默认值，不自动获取关联对象数据。FetchType.EAGER 自动获取关联对象数据，不推荐使用，如果所关联的对象数据在某些情况下没有使用，那么就是在浪费资源。
     * @return
     */
    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    /**
     * name = "singer_instrument"：指定与之关联的连接表为 singer_instrument <br/>
     * joinColumns = @JoinColumn(name = "singer_id")：指定与之关联的表字段为 singer_id <br/>
     * inverseJoinColumns = @JoinColumn(name = "instrument_id")：指定与之关联的另一个表字段为 instrument_id <br/>
     * @return
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "singer_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
