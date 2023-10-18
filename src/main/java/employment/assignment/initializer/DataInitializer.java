package employment.assignment.initializer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import employment.assignment.entity.CompanyEntity;
import employment.assignment.entity.RecruitmentEntity;
import employment.assignment.entity.UserEntity;
import employment.assignment.persistence.CompanyRepository;
import employment.assignment.persistence.RecruitmentRepository;
import employment.assignment.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationRunner {

        private final UserRepository userRepo;
        private final CompanyRepository companyRepo;
        private final RecruitmentRepository recruitmentRepo;

        @Override
        public void run(ApplicationArguments args) throws Exception {

                userRepo.save(UserEntity.builder()
                                .userId("iru")
                                .name("Iru")
                                .build());

                companyRepo.save(CompanyEntity.builder()
                                .companyName("네이버")
                                .build());
                companyRepo.save(CompanyEntity.builder()
                                .companyName("카카오")
                                .build());
                companyRepo.save(CompanyEntity.builder()
                                .companyName("원티드랩")
                                .build());

                recruitmentRepo.save(RecruitmentEntity.builder()
                                .companyId(1)
                                .companyName("네이버")
                                .country("미국")
                                .region("LA")
                                .position("백엔드")
                                .skill("Python")
                                .content("네이버에서 백엔드 시니어 개발자를 채용합니다.")
                                .reward("1000000")
                                .build());
                recruitmentRepo.save(RecruitmentEntity.builder()
                                .companyId(2)
                                .companyName("카카오")
                                .country("한국")
                                .region("울산")
                                .position("프론트엔드")
                                .skill("React")
                                .content("카카오에서 프론트엔드 주니어 개발자를 채용합니다.")
                                .reward("1500000")
                                .build());
                recruitmentRepo.save(RecruitmentEntity.builder()
                                .companyId(3)
                                .companyName("원티드랩")
                                .country("일본")
                                .region("도쿄")
                                .position("백엔드")
                                .skill("Spring")
                                .content("백엔드 주니어 개발자를 채용합니다.")
                                .reward("1200000")
                                .build());
                recruitmentRepo.save(RecruitmentEntity.builder()
                                .companyId(2)
                                .companyName("카카오")
                                .country("한국")
                                .region("서울")
                                .position("프론트엔드")
                                .skill("TS")
                                .content("카카오에서 프론트엔드 주니어 개발자를 채용합니다.")
                                .reward("1500000")
                                .build());
        }
}
