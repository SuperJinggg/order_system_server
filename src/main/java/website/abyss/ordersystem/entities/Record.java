package website.abyss.ordersystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Record implements Serializable {

    private Integer recordId;

    private String orderId;

    private Integer foodId;

    private Integer foodNum;

}