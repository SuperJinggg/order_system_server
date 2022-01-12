package website.abyss.ordersystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private String orderId;

    private String custPhone;

    private String tableId;

    private Integer orderState;

    private Double orderPrice;

    private String createTime;

    private String endTime;

}