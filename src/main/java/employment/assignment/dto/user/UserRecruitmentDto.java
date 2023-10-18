package employment.assignment.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRecruitmentDto {
    private Integer id;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private String reward;
    private String skill;
}
