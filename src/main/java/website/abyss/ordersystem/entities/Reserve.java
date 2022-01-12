package website.abyss.ordersystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Reserve implements Serializable {

    private Integer reserveId;

    private String custPhone;

    private String tableId;

    private String startTime;

    private String endTime;
}