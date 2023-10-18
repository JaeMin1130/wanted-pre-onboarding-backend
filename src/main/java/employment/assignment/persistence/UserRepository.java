package employment.assignment.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import employment.assignment.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}