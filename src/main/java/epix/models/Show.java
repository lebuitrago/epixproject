package main.java.epix.models;

import javax.persistence.*;

@Entity
@Table(name = "SHOW")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SHOW_ID")
    private Long id;

    @Column(name="SHOW_NAME",nullable=false)
    private String name;

    @Column(name="SHOW_DESCRIPTION")
    private String description;

    @Column(name="PIC_NAME",nullable=false)
    private String pic_name;

    @Column(name="VIDEO_CODE",nullable=false)
    private String video_code;

    @ManyToOne
    @JoinColumn(name="CHANNEL_ID",foreignKey=@ForeignKey(name="CHANNEL_ID_FK"))
    private Channel channel;

    public Show() {}

    public Show(String name, String description, String pic_name, String video_code, Channel channel) {
        this.name = name;
        this.description = description;
        this.pic_name = pic_name;
        this.video_code = video_code;
        this.channel = channel;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getVideo_code() {
        return video_code;
    }

    public void setVideo_code(String video_code) {
        this.video_code = video_code;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pic_name='" + pic_name + '\'' +
                ", video_code='" + video_code + '\'' +
                ", channel=" + channel +
                '}';
    }
}