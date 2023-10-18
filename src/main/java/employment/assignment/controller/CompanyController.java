package employment.assignment.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employment.assignment.dto.ResponseDto;
import employment.assignment.dto.company.CompanyRecruitmentDto;
import employment.assignment.service.CompanyService;
import employment.assignment.utils.Helper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/company")
@RestController
public class CompanyController {

    private final CompanyService CompanyService;
    private final ResponseDto response;

    // 1. 채용공고 등록
    @PostMapping("/create")
    public ResponseEntity<?> createRecruitment(@RequestBody CompanyRecruitmentDto dto, Errors errors)
            throws IOException {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return CompanyService.createRecruitment(dto);
    }

    // 2. 채용공고 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateRecruitment(@RequestBody CompanyRecruitmentDto dto, Errors errors)
            throws IOException {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return CompanyService.updateRecruitment(dto);
    }

    // 3. 채용공고 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRecruitment(@RequestBody CompanyRecruitmentDto dto, Errors errors)
            throws IOException {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return CompanyService.deleteRecruitment(dto);
    }
}
