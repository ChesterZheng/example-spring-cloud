package com.example.cloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cloud.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
