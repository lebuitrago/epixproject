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

    @ManyToOne
    @JoinColumn(name="CHANNEL_ID",foreignKey=@ForeignKey(name="CHANNEL_ID_FK"))
    private Channel channel;

    public Show() {}

    public Show(String name, String description, Channel channel) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", channel=" + channel +
                '}';
    }
}