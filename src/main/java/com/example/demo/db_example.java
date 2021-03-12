package com.example.demo;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
//import javax.validation.constraints.*;

@Entity
@Table
public class db_example{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private long id;
	
	@Column ( nullable = false)
	@NotEmpty (message = "どちらかを選択してください")
	private String expenditure;
	
	@Column (length = 20 , nullable = false)
	@Positive (message = "1以上の数字を入力してください") 
	@NotEmpty (message = "金額を入力してください")
	@Pattern (regexp="[0-9]*"  , message= "数字のみを入力してください")
	private String price;
	
	@Column(nullable = false)
	private String date;
	
	@Column (length = 20 , nullable = true)
	private String detail;
	
	@Column ( nullable = true)
	@NotEmpty (message = "カテゴリを選択してください")
	private String category;
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	
	public String getExpenditure() {return expenditure;}
	public void setExpenditure(String expenditure) {this.expenditure = expenditure;}
	
	public String getPrice() {return price;}
	public void setPrice(String price) {this.price = price;}
	
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	
	public String getDetail() {return detail;}
	public void setDetail(String detail) {this.detail = detail;}
	
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
	
	//リレーション
	@ManyToOne(fetch = FetchType.LAZY)
	public memberData memberData;

	public memberData getMemberData() {return memberData;}
	public void setMemberData(memberData memberData) {this.memberData = memberData;}
	
	}