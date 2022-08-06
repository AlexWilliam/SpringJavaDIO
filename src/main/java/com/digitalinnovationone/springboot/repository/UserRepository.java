package com.digitalinnovationone.springboot.repository;

import com.digitalinnovationone.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    // QUERY METHOD
    User findByName(String name);

    // QUERY METHOD
    List<User> findByNameContaining(String name);

    // QUERY OVERRIDE
    @Query("SELECT id, name FROM User WHERE name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name") String name);

    // JPA Auth com banco
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
    public User findByUsername(@Param ("username") String username);

}
