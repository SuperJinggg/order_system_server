package website.abyss.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.abyss.ordersystem.service.RecordService;
import website.abyss.ordersystem.utils.Result;
import website.abyss.ordersystem.entities.Record;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    private Result result = new Result();

    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping("/addRecord")
    public Result addRecord(@RequestBody List<Record> recordList){
        for (Record record:recordList){
            Record record1 = recordService.getByRecord(record);
            if(record1!=null){
                record.setFoodNum(record1.getFoodNum()+record.getFoodNum());
                recordService.updateRecord(record);
            }else {
                recordService.insertRecord(record);
            }
        }
        result.setSuccess("加菜成功",null);
        return result;
    }

    @RequestMapping("/decreaseRecord")
    public Result decreaseRecord(@RequestBody List<Record> recordList){
        for (Record record:recordList){
            Record record1 = recordService.getByRecord(record);
            if(record1!=null){
                if(record1.getFoodNum()>=record.getFoodNum()){
                    record.setFoodNum(record1.getFoodNum()-record.getFoodNum());
                    recordService.updateRecord(record);
                }else {
                    recordService.deleteRecord(record);
                }
            }
        }
        result.setSuccess("减少菜品成功",null);
        return result;
    }

}
