package employment.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruitmentDto {
    private Integer id;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private String reward;
    private String skill;
    private String content;
}
