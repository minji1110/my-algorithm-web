package myweb.algorithm.problem;

import lombok.*;
import myweb.algorithm.category.Category;
import myweb.algorithm.common.BaseTime;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Problem extends BaseTime {

    @Column
    @Id @GeneratedValue
    private Long problemId;            //문제id

    @Column(nullable = false)
    private int problemNo;      //문제번호

    @Column(nullable = false)
    private String problemTitle;    //제목

    @Column(nullable = false,columnDefinition = "TEXT")
    private String problemSolution; //코드

    @Column(nullable = false)
    private String problemComment;  //코멘트

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level problemLevel;    //난이도

    @JoinColumn(name = "categoryId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category problemCategory;    //카테고리

}
