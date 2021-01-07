package cn.shop.common.exception.controller;

import cn.shop.common.exception.pojo.ExceptionResult;
import cn.shop.common.exception.pojo.ShopException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName: ShopExceptionController
 * @Description: 全局异常拦截处理器
 * @author: yang
 * @date: 2021/1/7  16:07
 * @ControllerAdvice: 就会覆盖SpringMVC自带异常处理
 */
@ControllerAdvice
public class ShopExceptionController {
    /**
     * 定义异常处理
     * @param e
     * @return
     * @ExceptionHandler: 定义需要捕获什么异常
     */
    @ExceptionHandler(value = ShopException.class)
    public ResponseEntity<ExceptionResult> handlerException(ShopException e){
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResult(e));
    }
}
