package com.cg.iter.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.iter.questions.entities.Test;


@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

	@Query("Select test from Test test")
	List<Test> allTests();

	@Query("select test from Test test where test.testTitle=:name")
	List<Test> findByName(@Param("name") String name);

	

}