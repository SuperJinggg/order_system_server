package website.abyss.ordersystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderFood implements Serializable {
    private Integer foodId;

    private String foodName;

    private Double foodPrice;

    private String foodDesc;

    private String foodPhoto;

    private Integer foodRepertory;

    private Integer categoryId;

    private Integer foodNum;
}