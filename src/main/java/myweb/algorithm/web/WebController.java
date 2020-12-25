package myweb.algorithm.web;

import lombok.RequiredArgsConstructor;
import myweb.algorithm.category.Category;
import myweb.algorithm.category.CategoryDto;
import myweb.algorithm.category.CategoryRepo;
import myweb.algorithm.category.CategoryService;
import myweb.algorithm.exception.NoDataException;
import myweb.algorithm.problem.Level;
import myweb.algorithm.problem.Problem;
import myweb.algorithm.problem.ProblemDto;
import myweb.algorithm.problem.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final ProblemService problemService;
    private final CategoryService categoryService;
    private final CategoryRepo categoryRepo;

    @RequestMapping("/")
    public String home(Model model){
        List<Problem> problems=problemService.findAll();
        List<Category> categories=categoryRepo.findAll();
        model.addAttribute("problems",problems);
        model.addAttribute("categories",categories);
        return "home";
    }

    @GetMapping("/problem/new")
    public String problemForm(Model model){
        Level[] levels = Level.class.getEnumConstants();
        List<Category> categories=categoryRepo.findAll();

        model.addAttribute("problemForm",new ProblemDto());
        model.addAttribute("levels",levels);
        model.addAttribute("categories",categories);
        return "problemForm";
    }

    @PostMapping("/problems")
    public String problems(@ModelAttribute("problemForm") @Valid ProblemDto problemDto, BindingResult result,Model model){
        Level[] levels = Level.class.getEnumConstants();
        List<Category> categories=categoryRepo.findAll();

        if(result.hasErrors()){
            model.addAttribute("levels",levels);
            model.addAttribute("categories",categories);
            return "problemForm";
        }
        problemService.saveProblem(problemDto);
        return "redirect:/";
    }

    @GetMapping("/problem/{problemId}")
    public String problemDetail(@PathVariable long problemId, Model model) {
        Problem problem = problemService.findOne(problemId);
        List<Category> categories = categoryRepo.findAll();

        model.addAttribute("problem", problem);
        model.addAttribute("categories", categories);
        return "problemDetail";
    }
    
    @GetMapping("/problem/{problemId}/editForm")
    public String editProblemForm(@PathVariable long problemId, Model model) {
        Problem problem = problemService.findOne(problemId);
        List<Category> categories = categoryRepo.findAll();
        Level[] levels = Level.class.getEnumConstants();

        model.addAttribute("problemForm", new ProblemDto());
        model.addAttribute("problem", problem);
        model.addAttribute("categories", categories);
        model.addAttribute("levels", levels);
        return "editProblemForm";
    }

    @PostMapping("/problem/{problemId}/edit")
    public String editProblem(@ModelAttribute("problemForm") @Valid ProblemDto problemDto,BindingResult result,
                                @PathVariable long problemId, Model model) {

        Problem problem = problemService.findOne(problemId);
        Level[] levels = Level.class.getEnumConstants();
        List<Category> categories=categoryRepo.findAll();

        if (result.hasErrors()) {
            model.addAttribute("problem", problem);
            model.addAttribute("levels",levels);
            model.addAttribute("categories",categories);
            return "editProblemForm";
        }
        problemService.modify(problemId, problemDto);
        model.addAttribute("categories",categories);
        model.addAttribute("problem", problem);
        return "problemDetail";
    }

    @GetMapping("/problem/category/{categoryId}")
    public String byCategory(@PathVariable long categoryId,Model model){
        List<Problem> problems=problemService.findByCategory(categoryId);
        List<Category> categories=categoryRepo.findAll();
        Category selectedCategory=categoryRepo.findById(categoryId).orElseThrow(NoDataException::new);

        model.addAttribute("problems",problems);
        model.addAttribute("categories",categories);
        model.addAttribute("selectedCategory",selectedCategory);
        return "problemsByCategory";
    }

    @GetMapping("/problem/level/{level}")
    public String byLevel(@PathVariable String level,Model model){
        List<Problem> problems=problemService.findByLevel(level);
        List<Category> categories=categoryRepo.findAll();
        Level selectedLevel=Level.valueOf(level);

        model.addAttribute("problems",problems);
        model.addAttribute("selectedLevel",selectedLevel);
        model.addAttribute("categories",categories);
        return "problemsByLevel";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("categoryForm") CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
        return "redirect:/";
    }

    @DeleteMapping("problem/{problemId}")
    public String deleteProblem(@PathVariable long problemId) {
        problemService.delete(problemId);
        return "home";
    }
}
