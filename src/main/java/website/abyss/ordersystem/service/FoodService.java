package website.abyss.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.ordersystem.entities.Food;
import website.abyss.ordersystem.mapper.FoodMapper;

import java.util.List;

@Service
@Transactional
public class FoodService {

    private FoodMapper foodMapper;

    @Autowired
    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public Food getByFoodName(String foodName) {
        return foodMapper.getByFoodName(foodName);
    }

    public void addFood(Food food) {
        foodMapper.addFood(food);
    }

    public void deleteFood(Food food) {
        foodMapper.deleteFood(food);
    }

    public void addRepertory(Food food) {
        foodMapper.addRepertory(food);
    }

    public void changeFood(Food food) {
        foodMapper.changeFood(food);
    }

    public List<Food> foodList() {
        return foodMapper.foodList();
    }

    public List<Food> findFoodList(String foodName) {
        return foodMapper.findFoodList(foodName);
    }

    public List<Food> findFoodListByCategory(String categoryName) {
        return foodMapper.findFoodListByCategory(categoryName);
    }
}
