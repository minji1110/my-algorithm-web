package myweb.algorithm.problem;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProblemDto {

    @Positive(message = "* 문제 번호를 입력하세요.")
    @NotNull(message = "* 문제 번호를 입력하세요.")
    private Integer problemNo;

    @NotEmpty(message = "* 제목을 입력하세요.")
    private String problemTitle;

    @NotEmpty(message = "* 내용을 입력하세요.")
    private String problemSolution;

    private String problemComment;

    @NotNull(message = "* 난이도를 선택하세요.")
    private Level problemLevel;

    @NotNull(message = "* 언어를 선택하세요.")
    private Language problemLanguage;

    @NotEmpty(message = "* 카테고리를 선택하세요.")
    private String problemCategory;
}
