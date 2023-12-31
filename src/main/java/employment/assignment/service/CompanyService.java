package employment.assignment.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import employment.assignment.dto.ResponseDto;
import employment.assignment.dto.company.CompanyRecruitmentDto;
import employment.assignment.entity.CompanyEntity;
import employment.assignment.entity.RecruitmentEntity;
import employment.assignment.persistence.CompanyRepository;
import employment.assignment.persistence.RecruitmentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final RecruitmentRepository recruitmentRepo;
    private final CompanyRepository companyRepo;
    private final ResponseDto response;

    // 1. 채용공고 등록
    public ResponseEntity<?> createRecruitment(CompanyRecruitmentDto dto) {
        try {
            CompanyEntity company = companyRepo.findById(dto.getCompanyId()).get();
            recruitmentRepo.save(RecruitmentEntity.builder()
                    .companyId(dto.getCompanyId())
                    .companyName(company.getCompanyName())
                    .country(dto.getCountry())
                    .region(dto.getRegion())
                    .position(dto.getPosition())
                    .skill(dto.getSkill())
                    .content(dto.getContent())
                    .reward(dto.getReward())
                    .build());
            return response.success("등록 성공");
        } catch (Exception e) {
            return response.fail(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 2. 채용공고 수정
    public ResponseEntity<?> updateRecruitment(CompanyRecruitmentDto dto) {
        Optional<RecruitmentEntity> data = recruitmentRepo.findById(dto.getId());
        if (data.isPresent()) {
            try {
                recruitmentRepo.save(RecruitmentEntity.builder()
                        .id(dto.getId())
                        .country(dto.getCountry())
                        .region(dto.getRegion())
                        .position(dto.getPosition())
                        .skill(dto.getSkill())
                        .content(dto.getContent())
                        .build());
                return response.success("수정 성공");
            } catch (Exception e) {
                return response.fail(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return response.fail("수정하려는 채용 공고가 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    // 3. 채용공고 삭제
    public ResponseEntity<?> deleteRecruitment(CompanyRecruitmentDto dto) {
        Optional<RecruitmentEntity> data = recruitmentRepo.findById(dto.getId());
        if (data.isPresent()) {
            try {
                recruitmentRepo.delete(data.get());
                return response.success("삭제 성공");
            } catch (Exception e) {
                return response.fail(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return response.fail("삭제하려는 채용 공고가 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
    }
}
