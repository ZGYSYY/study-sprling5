package com.zgy.study.chapter07.subject07.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ZGY <br>
 * @date 2019/12/3 12:05 <br>
 * @description Instrument <br>
 */
@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {

    private String instrumentId;
    private Set<Singer> singers = new LinkedHashSet<>(16);

    @Id
    @Column(name = "instrument_id")
    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    /**
     * name = "instrument_id"：指定与之关联的连接表为 singer_instrument <br/>
     * joinColumns = @JoinColumn(name = "instrument_id")：指定与之关联的表字段为 instrument_id <br/>
     * inverseJoinColumns = @JoinColumn(name = "singer_id")：指定与之关联的另一个表字段为 singer_id <br/>
     * @return
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "singer_instrument", joinColumns = @JoinColumn(name = "instrument_id"), inverseJoinColumns = @JoinColumn(name = "singer_id"))
    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentId='" + instrumentId + '\'' +
                '}';
    }
}
