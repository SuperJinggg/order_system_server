package website.abyss.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.abyss.ordersystem.entities.Order;
import website.abyss.ordersystem.entities.OrderFood;
import website.abyss.ordersystem.service.OrderService;
import website.abyss.ordersystem.utils.Result;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private Result result = new Result();

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping("/takeOrder")
    public Result takeOrder(@RequestBody Order order){
        if(!orderService.isTableFree(order.getTableId())){
            result.setInfo("餐桌正在被使用",null);
            return result;
        }else if(!orderService.isCustFree(order.getCustPhone())){
            result.setInfo("顾客有未完成的订单",null);
            return result;
        }else {
            order.setCreateTime(sdf.format(new Date()));
            order.setOrderId(order.getCreateTime().replace("-","").replace(" ","").replace(":","")+order.getTableId());
            orderService.useTable(order);
            orderService.takeOrder(order);
            result.setSuccess("创建订单成功！",order);
        }
        return result;
    }

    @RequestMapping("/payOrder")
    public Result payOrder(@RequestBody Order order){
        if(orderService.isOrderPay(order.getOrderId())){
            result.setInfo("订单已经支付",null);
        }else{
            order.setEndTime(sdf.format(new Date()));
            order.setOrderPrice(orderService.checkout(order));
            orderService.pay(order);
            orderService.payOrder(order);
            orderService.freeTable(order.getTableId());
            result.setSuccess("支付成功",null);
        }
        return result;
    }

    @RequestMapping("/orderFoodList")
    public Result orderFoodList(@RequestBody Order order){
        List<OrderFood> FoodList = orderService.orderFoodList(order);
        result.setSuccess("查询订单菜品成功",FoodList);
        return result;
    }
}
