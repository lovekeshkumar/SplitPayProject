package com.nested;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	private String paidByUserName;
	public String paidForUserName;

	public Double amount;

	@Transient
	private Integer ufk;

	@Transient
	private Integer pfk;

	@ManyToOne
	private User user;

	@ManyToOne
	private Purpose purpose;

	public Transaction() {

	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}


	public String getPaidByUserName() {
		return paidByUserName;
	}

	public void setPaidByUserName(String paidByUserName) {
		this.paidByUserName = paidByUserName;
	}

	public String getPaidForUserName() {
		return paidForUserName;
	}

	public void setPaidForUserName(String paidForUserName) {
		this.paidForUserName = paidForUserName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getUfk() {
		return ufk;
	}

	public void setUfk(Integer ufk) {
		this.ufk = ufk;
	}

	public User getUser() {
		return user;

	}

	public void setUser(User user) {
		this.user = user;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public Integer getPfk() {
		return pfk;
	}

	public void setPfk(Integer pfk) {
		this.pfk = pfk;
	}

	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", paidByUserName=" + paidByUserName + ", paidForUserName=" + paidForUserName
				+ ", amount=" + amount + ", ufk=" + ufk + ", pfk=" + pfk + ", user=" + user + ", purpose=" + purpose
				+ "]";
	}

}