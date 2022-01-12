package website.abyss.ordersystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private String custPhone;

    private String password;

    private String custName;

    private Double custBalance;

}