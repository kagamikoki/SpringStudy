package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface day24DataRepository extends
JpaRepository<day24Data, Long>{
	public Optional<day24Data> findByIdNot(long id);
}
