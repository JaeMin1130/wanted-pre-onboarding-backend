
package employment.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import employment.assignment.dto.ResponseDto;
import employment.assignment.dto.user.ApplyDto;
import employment.assignment.dto.user.RecruitmentDetailDto;
import employment.assignment.dto.user.UserRecruitmentDto;
import employment.assignment.entity.ApplyHistoryEntity;
import employment.assignment.entity.RecruitmentEntity;
import employment.assignment.persistence.ApplyHistoryRepository;
import employment.assignment.persistence.RecruitmentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final RecruitmentRepository recruitmentRepo;
    private final ApplyHistoryRepository applyHistoryRepo;
    private final ResponseDto response;

    public ResponseEntity<?> getRecruitments() {
        List<RecruitmentEntity> list = recruitmentRepo.findAll();
        List<UserRecruitmentDto> data = new ArrayList<>();
        for (RecruitmentEntity entity : list) {
            data.add(UserRecruitmentDto.builder()
                    .id(entity.getId())
                    .companyName(entity.getCompanyName())
                    .country(entity.getCountry())
                    .region(entity.getRegion())
                    .position(entity.getPosition())
                    .reward(entity.getReward())
                    .skill(entity.getSkill())
                    .build());
        }
        return response.success(data);
    }

    public ResponseEntity<?> getDetails(int id) {
        Optional<RecruitmentEntity> option = recruitmentRepo.findById(id);
        if (option.isPresent()) {
            RecruitmentEntity entity = option.get();
            List<RecruitmentEntity> entities = recruitmentRepo.findAllByCompanyId(id);
            ArrayList<Integer> idList = new ArrayList<>();
            for (RecruitmentEntity data : entities) {
                if (data.getId() != entity.getId()) { // 선택된 채용공고 제외
                    idList.add(data.getId());
                }
            }
            RecruitmentDetailDto data = RecruitmentDetailDto.builder()
                    .id(entity.getId())
                    .companyName(entity.getCompanyName())
                    .country(entity.getCountry())
                    .region(entity.getRegion())
                    .position(entity.getPosition())
                    .reward(entity.getReward())
                    .skill(entity.getSkill())
                    .content(entity.getContent())
                    .otherRecruitments(idList)
                    .build();

            return response.success(data);
        } else {
            return response.fail("조회하려는 채용공고가 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> searchRecruitment(String text) {
        List<RecruitmentEntity> list = recruitmentRepo.findAll();
        List<UserRecruitmentDto> data = new ArrayList<>();
        for (RecruitmentEntity entity : list) {
            String total = entity.toString().toLowerCase();
            if (total.contains(text)) {
                data.add(UserRecruitmentDto.builder()
                        .id(entity.getId())
                        .companyName(entity.getCompanyName())
                        .country(entity.getCountry())
                        .region(entity.getRegion())
                        .position(entity.getPosition())
                        .reward(entity.getReward())
                        .skill(entity.getSkill())
                        .build());
            }
        }
        return response.success(data);
    }

    public ResponseEntity<?> applyRecruitment(ApplyDto dto) {
        try {
            applyHistoryRepo.save(ApplyHistoryEntity.builder()
                    .userId(dto.getUserId())
                    .recruitmentId(dto.getRecruitmentId()).build());
            return response.success("지원 완료");
        } catch (Exception e) {
            return response.fail(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
