package employment.assignment.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import employment.assignment.dto.RecruitmentDto;
import employment.assignment.dto.ResponseDto;
import employment.assignment.entity.RecruitmentEntity;
import employment.assignment.persistence.RecruitmentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final RecruitmentRepository recruitmentRepo;
    private final ResponseDto response;

    public ResponseEntity<?> createRecruitment(RecruitmentDto dto) {
        try {
            recruitmentRepo.save(RecruitmentEntity.builder()
                    .companyName(dto.getCompanyName())
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

    public ResponseEntity<?> updateRecruitment(RecruitmentDto dto) {
        Optional<RecruitmentEntity> data = recruitmentRepo.findById(dto.getId());
        if (data.isPresent()) {
            try {
                recruitmentRepo.save(RecruitmentEntity.builder()
                        .id(dto.getId())
                        .companyName(dto.getCompanyName())
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

    public ResponseEntity<?> deleteRecruitment(RecruitmentDto dto) {
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
