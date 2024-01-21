package ru.edu.module12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.module12.entity.User;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
