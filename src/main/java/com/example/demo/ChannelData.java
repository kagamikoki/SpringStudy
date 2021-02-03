package com.example.demo;
import javax.persistence.*;

@Entity
@Table

public class ChannelData {
@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column
private long id;

@Column(length = 20 , nullable = true)
private String name;

@Column(length = 50, nullable = true)
private String mail;

@Column(length = 140 , nullable = false)
private String comment;

@Column(nullable = true)
private String time;

public long getId() { return id;}
public void setId(long id) {this.id = id; }

public String getName() { return name;}
public void setName(String name) { this.name = name;}

public String getMail() { return mail;}
public void setMail(String mail) { this.mail = mail;}

public String getComment() { return comment;}
public void setComment(String comment) { this.comment = comment;}	

public String getTime() {return time;}
public void setTime(String time) {this.time = time;}

}