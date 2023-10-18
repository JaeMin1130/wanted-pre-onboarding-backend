// package employment.assignment.controller;

// import java.io.IOException;

// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.Errors;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import employment.assignment.dto.RecruitmentDto;
// import employment.assignment.dto.ResponseDto;
// import employment.assignment.service.UserService;
// import employment.assignment.utils.Helper;
// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// @RequestMapping("/user")
// @RestController
// public class UserController {

// private final UserService userService;
// private final ResponseDto response;

// @GetMapping("/show")
// public ResponseEntity<?> getRecruitments(Errors errors) throws IOException {
// if (errors.hasErrors()) {
// return response.invalidFields(Helper.refineErrors(errors));
// }
// return userService.getRecruitments();
// }

// @GetMapping("/show/details")
// public ResponseEntity<?> getDetails(RecruitmentDto dto, Errors errors) throws
// IOException {
// if (errors.hasErrors()) {
// return response.invalidFields(Helper.refineErrors(errors));
// }
// return userService.getDetails(dto);
// }

// @GetMapping("/search/{text}")
// public ResponseEntity<?> getRecruitment(@PathVariable String text, Errors
// errors) throws IOException {
// if (errors.hasErrors()) {
// return response.invalidFields(Helper.refineErrors(errors));
// }
// return userService.getRecruitment(text);
// }

// }
