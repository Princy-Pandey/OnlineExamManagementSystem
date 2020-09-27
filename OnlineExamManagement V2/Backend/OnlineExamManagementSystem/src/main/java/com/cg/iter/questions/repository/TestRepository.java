package com.cg.iter.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.iter.questions.entities.Test;
/*******************************************************************************************************************************
-Author                   :     ShirshakPanda
-Created/Modified Date    :     24-09-2020
-Description              :     Test Repository Interface with Test as Type and integer as Key
*******************************************************************************************************************************/


@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

	@Query("Select test from Test test")
	List<Test> allTests();

	@Query("select test from Test test where test.testTitle=:name")
	List<Test> findByName(@Param("name") String name);

	

}