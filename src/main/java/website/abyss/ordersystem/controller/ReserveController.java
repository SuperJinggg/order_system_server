package website.abyss.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.abyss.ordersystem.entities.Customer;
import website.abyss.ordersystem.entities.Reserve;
import website.abyss.ordersystem.entities.Table;
import website.abyss.ordersystem.service.ReserveService;
import website.abyss.ordersystem.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    private Result result = new Result();

    private ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @RequestMapping("/addReserve")
    public Result addReserve(@RequestBody Reserve reserve){
        if(!reserveService.verifyReserve(reserve)){//id重复！
            result.setInfo("预约时间冲突",null);
        }else{
            reserveService.addReserve(reserve);
            result.setSuccess("预约成功！",null);
        }
        return result;
    }

    @RequestMapping("/deleteReserve")
    public Result deleteReserve(@RequestBody Reserve reserve){
        if(reserveService.getByReserveId(reserve.getReserveId())==null){//id重复！
            result.setInfo("预约不存在",null);
        }else{
            reserveService.deleteReserve(reserve);
            result.setSuccess("取消预约成功！",null);
        }
        return result;
    }

    @RequestMapping("/changeReserve")
    public Result changeReserve(@RequestBody Reserve reserve){
        if(reserveService.getByReserveId(reserve.getReserveId())==null){//id重复！
            result.setInfo("预约不存在",null);
        }else if(reserveService.verifyReserve(reserve)){
            reserveService.changeReserve(reserve);
            result.setSuccess("变更预约成功！",null);
        }else result.setInfo("预约时间冲突",null);
        return result;
    }


    @RequestMapping("/findReserveByTable")
    public Result findReserveByTable(@RequestBody Table table){
        List<Reserve> reserveList = reserveService.findReserveByTable(table);
        result.setSuccess("查询预约成功！",reserveList);
        return result;
    }
}
