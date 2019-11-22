package com.nested;

public class SplitService {
	public Double splitamount(String paidfor[], double amount) {
		double share = (amount / paidfor.length + 1);

		for (int i = 0; i < paidfor.length; i++) {
			System.out.println(paidfor[i] + "has to pay " + share + "/-");
		}
		return share;
	}

}
