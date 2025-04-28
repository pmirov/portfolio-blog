package com.mirov.top.portfolioblog.repository;

import com.mirov.top.portfolioblog.entity.Role;
import com.mirov.top.portfolioblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

//    User findByUsername(String username);
//    User findByUsernameAndId(String username, Integer id);
//    User findByUsernameIgnoreCase(String username);
//    List<User> findAllByRoleOrderByIdDesc(Role role);
}
