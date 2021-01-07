package cn.shop.common.exception.pojo;

import lombok.Getter;

/**
 * @ClassName: ShopException
 * @Description: 自定义异常类
 * @author: yang
 * @date: 2021/1/7  16:01
 */
@Getter
public class ShopException extends RuntimeException{
    //状态码
    private Integer status;

    public ShopException(Integer status,String message){
        super(message);
        this.status = status;
    }

    public ShopException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }
}
