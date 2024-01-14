package ru.edu.module12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.module12.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
}
