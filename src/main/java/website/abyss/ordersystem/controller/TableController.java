package website.abyss.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.abyss.ordersystem.entities.Table;
import website.abyss.ordersystem.service.TableService;
import website.abyss.ordersystem.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController {

    private Result result = new Result();

    private TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @RequestMapping("/addTable")
    public Result addTable(@RequestBody Table table){
        if(tableService.getByTableId(table.getTableId())!=null){//id重复！
            result.setInfo("该桌子已存在",null);
        }else{
            tableService.addTable(table);
            result.setSuccess("增加桌子成功！",null);
        }
        return result;
    }

    @RequestMapping("/deleteTable")
    public Result deleteTable(@RequestBody Table table){
        if(tableService.getByTableId(table.getTableId())==null){//id重复！
            result.setInfo("该桌子不存在",null);
        }else{
            tableService.deleteTable(table);
            result.setSuccess("删除桌子成功！",null);
        }
        return result;
    }

    @RequestMapping("/changeTable")
    public Result changeTable(@RequestBody Table table){
        if(tableService.getByTableId(table.getTableId())==null){//id重复！
            result.setInfo("该桌子不存在",null);
        }else{
            tableService.changeTable(table);
            result.setSuccess("修改桌子成功！",null);
        }
        return result;
    }

    @RequestMapping("/findTableList")
    public Result findTableList(){
        List<Table> tableList = tableService.findTableList();
        result.setSuccess("查询桌子成功！",tableList);
        return result;
    }

    @RequestMapping("/findFreeTableList")
    public Result findFreeTableList(){
        List<Table> tableList = tableService.findFreeTableList();
        result.setSuccess("查询空闲桌子成功！",tableList);
        return result;
    }
}
