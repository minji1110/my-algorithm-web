package myweb.algorithm.problem;

import lombok.RequiredArgsConstructor;
import myweb.algorithm.category.Category;
import myweb.algorithm.category.CategoryRepo;
import myweb.algorithm.exception.NoDataException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProblemService {
    private final ProblemRepo problemRepo;
    private final CategoryRepo categoryRepo;

    public Problem saveProblem(ProblemDto problemDto){

        Problem problem=Problem.builder()
                .problemNo(problemDto.getProblemNo())
                .problemTitle(problemDto.getProblemTitle())
                .problemSolution(problemDto.getProblemSolution())
                .problemComment(problemDto.getProblemComment())
                .problemLevel(problemDto.getProblemLevel())
                .problemCategory(categoryRepo.findByCategoryName(problemDto.getProblemCategory()))
                .build();

        return problemRepo.save(problem);
    }

    public List<Problem> findAll(){
        return problemRepo.findAll();
    }

    public Problem findOne(long id){
        return problemRepo.findById(id).orElseThrow(NoDataException::new);
    }

    public List<Problem> findByCategory(long categoryId){
        Category category=categoryRepo.findById(categoryId).orElseThrow(NoDataException::new);
        return problemRepo.findByProblemCategory(category);
    }

    public List<Problem> findByLevel(String level){
        Level problemLevel=Level.valueOf(level);
        return problemRepo.findByProblemLevel(problemLevel);
    }

    public Problem modify(long id,ProblemDto problemDto){
        Problem problem=problemRepo.findById(id).get();
        problem.setProblemTitle(problemDto.getProblemTitle());
        problem.setProblemCategory(categoryRepo.findByCategoryName(problemDto.getProblemCategory()));
        problem.setProblemComment(problemDto.getProblemComment());
        problem.setProblemLevel(problemDto.getProblemLevel());
        problem.setProblemNo(problemDto.getProblemNo());
        problem.setProblemSolution(problemDto.getProblemSolution());

        return problem;
    }

    public void delete(long id){
        Problem problem=problemRepo.findById(id).orElseThrow(NoDataException::new);
        problemRepo.delete(problem);
    }
}
