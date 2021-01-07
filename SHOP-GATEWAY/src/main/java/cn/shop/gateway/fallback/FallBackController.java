package cn.shop.gateway.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FallBackController
 * @Description: 服务熔断降级处理
 * @author: yang
 * @date: 2021/1/7  13:55
 */
@RestController
public class FallBackController {
    /**
     * 服务降级处理方法
     * @return
     */
    @RequestMapping("/fallback")
    public String fallback(){
        return "服务器很忙!!";
    }
}
