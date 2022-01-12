package website.abyss.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.ordersystem.entities.Order;
import website.abyss.ordersystem.entities.OrderFood;
import website.abyss.ordersystem.mapper.OrderMapper;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public boolean isTableFree(String tableId) {
        if(orderMapper.isTableFree(tableId)!=null){
            return true;
        }
        return false;
    }

    public boolean isCustFree(String custPhone) {
        if(orderMapper.isCustFree(custPhone).size()>0){
            return false;
        }
        return true;
    }

    public void takeOrder(Order order) {
        orderMapper.takeOrder(order);
    }

    public boolean isOrderPay(String orderId) {
        if(orderMapper.isOrderPay(orderId)!=null){
            return false;
        }
        return true;
    }

    public void payOrder(Order order) {
        orderMapper.payOrder(order);
    }

    public List<OrderFood> orderFoodList(Order order) {
        return orderMapper.orderFoodList(order);
    }

    public void freeTable(String tableId) {
        orderMapper.freeTable(tableId);
    }

    public Double checkout(Order order) {
       return orderMapper.checkout(order)+orderMapper.tablePrice(order.getTableId());
    }

    public void pay(Order order) {
        orderMapper.pay(order);
    }

    public void useTable(Order order) {
        orderMapper.useTable(order.getTableId());
    }
}
