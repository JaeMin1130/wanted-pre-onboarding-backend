package employment.assignment.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import employment.assignment.entity.RecruitmentEntity;

public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Integer> {
}