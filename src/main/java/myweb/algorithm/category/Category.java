package myweb.algorithm.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myweb.algorithm.common.BaseTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Category extends BaseTime {
    @Id @GeneratedValue
    @Column
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName;

}
