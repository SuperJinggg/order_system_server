package website.abyss.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.abyss.ordersystem.entities.Category;
import website.abyss.ordersystem.service.CategoryService;
import website.abyss.ordersystem.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    private Result result = new Result();

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/addCategory")
    public Result addCategory(@RequestBody Category category){
        if(categoryService.getByCategoryName(category.getCategoryName())!=null){//id重复！
            result.setInfo("该类目已存在",null);
        }else{
            categoryService.addCategory(category);
            result.setSuccess("增加类目成功！",null);
        }
        return result;
    }

    @RequestMapping("/deleteCategory")
    public Result deleteCategory(@RequestBody Category category){
        if(categoryService.getByCategoryName(category.getCategoryName())==null){//id重复！
            result.setInfo("该类目不存在",null);
        }else{
            categoryService.deleteCategory(category);
            result.setSuccess("删除类目成功！",null);
        }
        return result;
    }

    @RequestMapping("/changeCategory")
    public Result changeCategory(@RequestBody Category category){
        if(categoryService.getByCategoryName(category.getCategoryName())==null){//id重复！
            result.setInfo("该类目不存在",null);
        }else{
            categoryService.changeCategory(category);
            result.setSuccess("修改类目成功！",null);
        }
        return result;
    }

    @RequestMapping("/categoryList")
    public Result changeCategory(){
        List<Category> categoryList = categoryService.categoryList();
        result.setSuccess("查询类目成功！",categoryList);
        return result;
    }

}
