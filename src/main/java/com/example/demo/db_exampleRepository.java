package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.accessingdatamysql.db_example;
//import org.springframework.data.repository.CrudRepository;


@Repository
public interface db_exampleRepository extends
	JpaRepository<db_example, Long>{
		
	}
