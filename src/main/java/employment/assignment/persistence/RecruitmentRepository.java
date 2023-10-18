package employment.assignment.persistence;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import employment.assignment.entity.RecruitmentEntity;

public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Integer> {
    public ArrayList<RecruitmentEntity> findAllByCompanyId(int id);
}