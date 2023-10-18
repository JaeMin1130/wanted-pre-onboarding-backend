package employment.assignment.dto.user;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruitmentDetailDto {
    private Integer id;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private String reward;
    private String skill;
    private String content;
    private ArrayList<Integer> otherRecruitments;
}
