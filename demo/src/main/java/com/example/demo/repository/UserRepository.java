package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User save(User hoidanit);
    // List<User> FindByEmailAndAddress(String email, String address);
    List<User> findByEmail(String email);
    List<User> findAll();
    User findById(long id);
    void deleteById(long id);
}
