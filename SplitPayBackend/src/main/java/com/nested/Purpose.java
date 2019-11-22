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

@Entity(name = "purpose")
public class Purpose {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;

	@Column(unique = true)
	private String pName;

	@OneToMany(mappedBy = "purpose", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transaction> transactions;

	public Purpose() {

	}

	public Purpose(Integer pid, String pName) {
		this.pid = pid;
		this.pName = pName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@JsonIgnore
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Purpose [pid=" + pid + ", pName=" + pName + "]";
	}

}