package website.abyss.ordersystem.entities;

import lombok.*;

import java.io.Serializable;

@Data
public class Food implements Serializable {
    private Integer foodId;

    private String foodName;

    private Double foodPrice;

    private String foodDesc;

    private String foodPhoto;

    private Integer foodRepertory;

    private Integer categoryId;
}