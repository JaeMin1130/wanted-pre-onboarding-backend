package employment.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recruitment")
@Entity
public class RecruitmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer companyId;
    @Column(length = 20)
    private String companyName;
    @Column(length = 20)
    private String country;
    @Column(length = 20)
    private String region;
    @Column(length = 20)
    private String position;
    @Column(length = 20)
    private String reward;
    @Column(length = 20)
    private String skill;
    private String content;
}
