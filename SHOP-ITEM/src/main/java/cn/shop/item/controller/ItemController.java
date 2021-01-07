package cn.shop.item.controller;

import cn.shop.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ItemController
 * @Description: 商品controller
 * @author: yang
 * @date: 2021/1/7  15:23
 * @RequestParam: 将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
 */
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 添加商品方法
     * @param id
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<Long> saveItem(@RequestParam("id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.saveItem(id));
    }
}
