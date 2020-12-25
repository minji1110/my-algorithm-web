package myweb.algorithm.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public Category saveCategory(CategoryDto categoryDto){
        Category category=new Category();
        category.setCategoryName(categoryDto.getCategoryName());

        return categoryRepo.save(category);
    }

}
