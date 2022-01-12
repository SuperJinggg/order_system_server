package website.abyss.ordersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.ordersystem.entities.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    Category getByCategoryName(String categoryName);

    void addCategory(Category category);

    void deleteCategory(Category category);

    void changeCategory(Category category);

    List<Category> categoryList();
}