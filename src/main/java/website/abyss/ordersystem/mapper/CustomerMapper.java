package website.abyss.ordersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.ordersystem.entities.Customer;
import website.abyss.ordersystem.entities.Order;
import website.abyss.ordersystem.entities.Reserve;

import java.util.List;

@Mapper
public interface CustomerMapper {

    Customer getByCustPhone(String custPhone);

    void register(Customer customer);

    void update(Customer customer);

    void recharge(Customer customer);

    void changeName(Customer customer);

    List<Order> myOrderList(String custPhone);

    List<Reserve> myReserveList(String custPhone);
}