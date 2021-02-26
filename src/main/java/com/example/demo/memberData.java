package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class memberData {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column
		private long id;
		
		@Column ( nullable = false)
		private String name;
		
		@Column ( nullable = false)
		private String mail;
		
		@Column ( nullable = false)
		private String password;
		
		
		public long getId() {return id;}
		public void setId(long id) {this.id = id;}
		
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
		
		public String getMail() {return mail;}
		public void setMail(String mail) {this.mail = mail;}
		
		public String getPassword() {return password;}
		public void setPassword(String password) {this.password = password;}
		
		
		public List<db_example> getDb_exampleList() {
			return db_exampleList;
		}
		public void setDb_exampleList(List<db_example> db_exampleList) {
			this.db_exampleList = db_exampleList;
		}
		

		//リレーション
		@OneToMany(mappedBy="memberData")
		private List<db_example> db_exampleList;

		
	}
	
