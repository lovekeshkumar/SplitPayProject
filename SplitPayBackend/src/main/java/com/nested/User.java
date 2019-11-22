package com.nested;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	private String name;
	private String userName;
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transaction> transactions;

	@OneToMany(mappedBy = "groupUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<GroupRelation> groupRelations;

	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@JsonIgnore
	public List<GroupRelation> getGroupRelations() {
		return groupRelations;
	}

	public void setGroupRelations(List<GroupRelation> groupRelations) {
		this.groupRelations = groupRelations;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}

}