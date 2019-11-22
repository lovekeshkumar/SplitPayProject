package com.nested.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nested.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {

	
}