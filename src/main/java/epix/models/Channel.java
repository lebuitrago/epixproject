package main.java.epix.models;

import javax.persistence.*;

@Entity
@Table(name = "CHANNEL")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CHANNEL_ID")
    private Long id;
    @Column(name="CHANNEL_NAME",nullable=false, unique = true)
    private String name;
    @Column(name="PIC_NAME",nullable=false)
    private String pic_name;
    @Column(name="CHANNEL_NUMBER",nullable=false, unique = true)
    private Integer number;

    public Channel() {
    }

    public Channel(String name, Integer number, String pic_name) {
        this.name = name;
        this.number = number;
        this.pic_name = pic_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", pic_name=" + pic_name +
                '}';
    }
}