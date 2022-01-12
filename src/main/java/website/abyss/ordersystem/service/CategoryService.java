package website.abyss.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.ordersystem.entities.Category;
import website.abyss.ordersystem.mapper.CategoryMapper;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Category getByCategoryName(String categoryName) {
        return  categoryMapper.getByCategoryName(categoryName);
    }

    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    public void deleteCategory(Category category) {
        categoryMapper.deleteCategory(category);
    }

    public void changeCategory(Category category) {
        categoryMapper.changeCategory(category);
    }

    public List<Category> categoryList() {
        return  categoryMapper.categoryList();
    }
}
