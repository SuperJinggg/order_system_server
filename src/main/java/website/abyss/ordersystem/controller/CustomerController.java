package website.abyss.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.abyss.ordersystem.entities.Customer;
import website.abyss.ordersystem.entities.Order;
import website.abyss.ordersystem.entities.Reserve;
import website.abyss.ordersystem.service.CustomerService;
import website.abyss.ordersystem.utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private Result result = new Result();

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/register")
    public Result register(@RequestBody Customer customer){
        if(customerService.getByCustPhone(customer.getCustPhone())!=null){//id重复！
            result.setInfo("该账号已注册！",null);
        }else{
            customerService.register(customer);
            result.setSuccess("注册成功！",null);
        }
        return result;
    }

    @RequestMapping("/login")
    public Result login(@RequestBody Customer customer, HttpServletRequest request){
        Customer user1=customerService.getByCustPhone(customer.getCustPhone());
        if(user1!=null){//存在该账户
            if(user1.getPassword().equals(customer.getPassword())){//密码正确
                request.getSession().setAttribute("customer",customer);
                result.setSuccess("登录成功！",user1);
            }else{//密码错误
                result.setInfo("用户名或密码错误！",null);
            }
        }else{//不存在该账户
            result.setInfo("该账号不存在！",null);
        }
        return result;
    }

    @RequestMapping("/forgetPassword")
    public Result forgetPassword(@RequestBody Customer customer){
        Customer user1=customerService.getByCustPhone(customer.getCustPhone());
        if(user1!=null){//id重复！
            customerService.update(customer);
            result.setSuccess("修改密码成功！",null);
        }else{
            result.setInfo("该账号不存在！",null);
        }
        return result;
    }

    @RequestMapping("/recharge")
    public Result recharge(@RequestBody Customer customer){
        if(customer.getCustBalance()>=0){
            if(customerService.getByCustPhone(customer.getCustPhone())==null){
                result.setInfo("该账号不存在！无法充值",null);
            }else{
                customerService.recharge(customer);
                result.setSuccess("充值成功！",null);
            }
        }else{
            result.setInfo("余额不能为负数",null);
        }
        return result;
    }

    @RequestMapping("/changeName")
    public Result changeName(@RequestBody Customer customer){
        if(customer.getCustName()!=null&&!customer.getCustName().equals("")){
            if(customerService.getByCustPhone(customer.getCustPhone())==null){
                result.setInfo("该账号不存在！无法改名",null);
            }else{
                customerService.changeName(customer);
                result.setSuccess("改名成功！",null);
            }
        }else{
            result.setInfo("非法名称",null);
        }
        return result;
    }

    @RequestMapping("/myOrderList")
    public Result myOrderList(@RequestBody Customer customer){
        if(customerService.getByCustPhone(customer.getCustPhone())==null){
            result.setInfo("该账号不存在！",null);
        }else{
            List<Order> orderList= customerService.myOrderList(customer);
            result.setSuccess("查询成功！",orderList);
        }
        return result;
    }

    @RequestMapping("/myReserveList")
    public Result myReserveList(@RequestBody Customer customer){
        if(customerService.getByCustPhone(customer.getCustPhone())==null){
            result.setInfo("该账号不存在！",null);
        }else{
            List<Reserve> ReserveList= customerService.myReserveList(customer);
            result.setSuccess("查询成功！",ReserveList);
        }
        return result;
    }
}
