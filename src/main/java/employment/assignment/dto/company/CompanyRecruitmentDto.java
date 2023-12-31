package employment.assignment.dto.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRecruitmentDto {
    private Integer id;
    private Integer companyId;
    private String country;
    private String region;
    private String position;
    private String reward;
    private String skill;
    private String content;
}
