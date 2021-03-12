package com.example.demo;
import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table
public class UserData {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)@Column
	private long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String mail;
	
	@Column(nullable = false)
	private String pass;
	
	@Column(length = 20, nullable = false)
	@Positive (message = "1以上の数字を入力してください")
	private int age;
	
	
	public long getId() { return id;}
	public void setId(long id) {this.id = id; }
	
	public String getName() { return name;}
	public void setName(String name) { this.name = name;}
	
	public String getMail() { return mail;}
	public void setMail(String mail) { this.mail = mail;}
	
	public String getPass() { return pass;}
	public void setPass(String pass) { this.pass = pass;}	
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

}
