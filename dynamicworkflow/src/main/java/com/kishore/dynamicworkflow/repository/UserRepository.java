package com.kishore.dynamicworkflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishore.dynamicworkflow.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
