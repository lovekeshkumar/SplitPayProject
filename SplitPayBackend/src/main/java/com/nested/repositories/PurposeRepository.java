package com.nested.repositories;


import org.springframework.data.repository.CrudRepository;

import com.nested.Purpose;

public interface PurposeRepository extends CrudRepository<Purpose, Integer> {

//	Purpose findBypName(String pName);
  void deleteBypid(Integer pid);


}