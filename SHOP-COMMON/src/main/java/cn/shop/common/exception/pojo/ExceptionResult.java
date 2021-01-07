package cn.shop.common.exception.pojo;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * @ClassName: ExceptionResult
 * @Description: 封装异常结果信息类
 * @author: yang
 * @date: 2021/1/7  16:13
 */
@Data
public class ExceptionResult {

    private Integer status;
    private String message;
    private String timestamp;

    public ExceptionResult(Integer status,String message){
        this.status = status;
        this.message = message;
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }
    public ExceptionResult(ShopException e){
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss"); }
}
