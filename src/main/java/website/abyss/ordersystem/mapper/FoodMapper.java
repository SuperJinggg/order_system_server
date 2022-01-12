package website.abyss.ordersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.ordersystem.entities.Food;

import java.util.List;

@Mapper
public interface FoodMapper {

    Food getByFoodName(String foodName);

    void addFood(Food food);

    void deleteFood(Food food);

    void addRepertory(Food food);

    void changeFood(Food food);

    List<Food> foodList();

    List<Food> findFoodList(String foodName);

    List<Food> findFoodListByCategory(String categoryName);
}