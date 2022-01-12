package website.abyss.ordersystem.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Result {
    //状态码
    private int code;
    //提示消息
    private String msg;
    //数据
    private Object result;

    public void setSuccess(String msg, Object result){
        this.code=200;
        this.msg=msg;
        this.result=result;
    }
    public void setInfo(String msg, Object result){
        this.code=400;
        this.msg=msg;
        this.result=result;
    }
}