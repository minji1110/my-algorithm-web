package myweb.algorithm.problem;

import myweb.algorithm.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepo extends JpaRepository<Problem,Long> {
    List<Problem> findByProblemCategory(Category problemCategory);
    List<Problem> findByProblemLevel(Level problemLevel);
}
