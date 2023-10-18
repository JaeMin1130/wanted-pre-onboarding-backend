package employment.assignment.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import employment.assignment.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
}