package employment.assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employment.assignment.dto.ResponseDto;
import employment.assignment.dto.user.ApplyDto;
import employment.assignment.service.UserService;
import employment.assignment.utils.Helper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;
    private final ResponseDto response;

    @GetMapping("/show")
    public ResponseEntity<?> getRecruitments() {
        return userService.getRecruitments();
    }

    @GetMapping("/show/detail/{id}")
    public ResponseEntity<?> getDetails(@PathVariable int id) {
        return userService.getDetails(id);
    }

    @GetMapping("/search/{text}")
    public ResponseEntity<?> searchRecruitment(@PathVariable String text) {
        return userService.searchRecruitment(text);
    }

    @PostMapping("/apply")
    public ResponseEntity<?> applyRecruitment(@RequestBody ApplyDto dto, Errors errors) {
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return userService.applyRecruitment(dto);
    }
}
