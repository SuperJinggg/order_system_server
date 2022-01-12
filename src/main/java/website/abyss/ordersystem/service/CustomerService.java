package website.abyss.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.ordersystem.entities.Customer;
import website.abyss.ordersystem.entities.Order;
import website.abyss.ordersystem.entities.Reserve;
import website.abyss.ordersystem.mapper.CustomerMapper;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public Customer getByCustPhone(String custPhone) {
        return customerMapper.getByCustPhone(custPhone);
    }

    public void register(Customer customer) {
        customerMapper.register(customer);
    }

    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    public void recharge(Customer customer) {
        customerMapper.recharge(customer);
    }

    public void changeName(Customer customer) {
        customerMapper.changeName(customer);
    }

    public List<Order> myOrderList(Customer customer) {
        return customerMapper.myOrderList(customer.getCustPhone());
    }

    public List<Reserve> myReserveList(Customer customer) {
        return customerMapper.myReserveList(customer.getCustPhone());
    }
}
