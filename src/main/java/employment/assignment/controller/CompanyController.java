package employment.assignment.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employment.assignment.dto.RecruitmentDto;
import employment.assignment.dto.ResponseDto;
import employment.assignment.service.CompanyService;
import employment.assignment.utils.Helper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/company")
@RestController
public class CompanyController {

    private final CompanyService CompanyService;
    private final ResponseDto response;

    @PostMapping("/create")
    public ResponseEntity<?> createRecruitment(@RequestBody RecruitmentDto dto, Errors errors) throws IOException {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return CompanyService.createRecruitment(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRecruitment(@RequestBody RecruitmentDto dto, Errors errors) throws IOException {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return CompanyService.updateRecruitment(dto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRecruitment(@RequestBody RecruitmentDto dto, Errors errors) throws IOException {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return CompanyService.deleteRecruitment(dto);
    }
}
