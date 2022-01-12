package website.abyss.ordersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.ordersystem.entities.Order;
import website.abyss.ordersystem.entities.OrderFood;
import website.abyss.ordersystem.entities.Table;

import java.util.List;

@Mapper
public interface OrderMapper {

    Table isTableFree(String tableId);

    List<Order> isCustFree(String custPhone);

    void takeOrder(Order order);

    Order isOrderPay(String orderId);

    Double checkout(Order order);

    void payOrder(Order order);

    void freeTable(String tableId);

    List<OrderFood> orderFoodList(Order order);

    void pay(Order order);

    Double tablePrice(String tableId);

    void useTable(String tableId);
}