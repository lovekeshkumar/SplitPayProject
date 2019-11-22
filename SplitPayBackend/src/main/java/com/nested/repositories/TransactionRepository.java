package com.nested.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nested.Transaction;
import com.nested.User;

public interface TransactionRepository extends CrudRepository< Transaction, Integer> {

	public List<Transaction> findByUser(User user);
	
}