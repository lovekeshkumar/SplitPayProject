package com.nested.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nested.Group;
import com.nested.GroupRelation;

public interface GroupRelationRepository extends CrudRepository<GroupRelation, Integer> {
	@Modifying
	  @Transactional
	@Query(value = "delete from grouprelations where  GROUP_GROUP_ID = ?1 AND GROUP_USER_ID = ?2", nativeQuery = true)
	void deleteByUserandGroup(Integer gid, Integer uid );

	@Query(value = "insert into grouprelations where GROUP_USER_ID = ?1", nativeQuery = true)
	 Group addbyUser(Integer uid);
	
	@Query(value = "select GROUP_USER_ID from grouprelations where GROUP_GROUP_ID = ?1", nativeQuery = true)
	void viewByUser(Integer uid);


}