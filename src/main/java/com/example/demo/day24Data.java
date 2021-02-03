package com.example.demo;
import javax.persistence.*;

@Entity
@Table

public class day24Data {
@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column
private long id;

@Column(length = 20 , nullable = true)
private String name;

@Column(length = 50, nullable = true)
private String mail;

@Column(length = 20, nullable = true)
private String mf;

@Column(length = 20, nullable = true)
private String birthday;

@Column(length = 50, nullable = true)
private String country;

public long getId() {return id;}
public void setId(long id) {this.id = id;}

public String getName() {return name;}
public void setName(String name) {this.name = name;}

public String getMail() {return mail;}
public void setMail(String mail) {this.mail = mail;}

public String getMf() {return mf;}
public void setMf(String mf) {this.mf = mf;}

public String getBirthday() {return birthday;}
public void setBirthday(String birthday) {this.birthday = birthday;}

public String getCountry() {return country;}
public void setCountry(String country) {this.country = country;}

}
