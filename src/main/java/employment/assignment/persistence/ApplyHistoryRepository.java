package employment.assignment.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import employment.assignment.entity.ApplyHistoryEntity;

public interface ApplyHistoryRepository extends JpaRepository<ApplyHistoryEntity, Integer> {
}