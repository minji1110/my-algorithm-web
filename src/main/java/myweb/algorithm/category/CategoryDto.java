package myweb.algorithm.category;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDto {

    @NotBlank(message = "카테고리명을 입력하세요.")
    private String categoryName;
}
