package com.spring.springSelenium.repository;

import com.spring.springSelenium.entity.User;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByFirstNameStartingWith(String startsWith);

  List<User> findByDobBetween(Date from, Date to);
}
