package website.abyss.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.abyss.ordersystem.entities.Category;
import website.abyss.ordersystem.entities.Food;
import website.abyss.ordersystem.service.FoodService;
import website.abyss.ordersystem.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private Result result = new Result();

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping("/addFood")
    public Result addFood(@RequestBody Food food){
        if(foodService.getByFoodName(food.getFoodName())!=null){//id重复！
            result.setInfo("该菜品已存在！",null);
        }else{
            foodService.addFood(food);
            result.setSuccess("增加菜品成功！",null);
        }
        return result;
    }

    @RequestMapping("/deleteFood")
    public Result deleteFood(@RequestBody Food food){
        if(foodService.getByFoodName(food.getFoodName())==null){//id重复！
            result.setInfo("该菜品不存在！",null);
        }else{
            foodService.deleteFood(food);
            result.setSuccess("删除菜品成功！",null);
        }
        return result;
    }

    @RequestMapping("/addRepertory")
    public Result addRepertory(String foodName,Integer num){
        Food food = foodService.getByFoodName(foodName);
        if(food==null){//id重复！
            result.setInfo("该菜品不存在！",null);
        }else {
            food.setFoodRepertory(food.getFoodRepertory()+num);
            foodService.addRepertory(food);
            result.setSuccess("增加菜品库存成功！",null);
        }
        return result;
    }

    @RequestMapping("/changeFood")
    public Result changeFood(@RequestBody Food food){
        Food food1 = foodService.getByFoodName(food.getFoodName());
        food.setFoodId(food1.getFoodId());
        if(food1==null){//id重复！
            result.setInfo("该菜品不存在！",null);
        }else {
            foodService.changeFood(food);
            result.setSuccess("修改菜品成功！",null);
        }
        return result;
    }

    @RequestMapping("/foodList")
    public Result foodList(){
        List<Food> foodList = foodService.foodList();
        result.setSuccess("查询所有食物成功",foodList);
        return result;
    }

    @RequestMapping("/findFoodList")
    public Result foodList(String foodName){
        List<Food> foodList = foodService.findFoodList(foodName);
        result.setSuccess("查询食物成功",foodList);
        return result;
    }

    @RequestMapping("/findFoodListByCategory")
    public Result findFoodListByCategory(@RequestBody Category category){
        List<Food> foodList = foodService.findFoodListByCategory(category.getCategoryName());
        result.setSuccess("查询食物成功",foodList);
        return result;
    }
}
