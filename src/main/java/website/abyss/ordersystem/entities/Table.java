package website.abyss.ordersystem.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Table implements Serializable {
    private String tableId;

    private Integer tableState;

    private Integer fullPeople;

    private Double tablePrice;

}