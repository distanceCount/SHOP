package cn.shop.item.service;

import cn.shop.common.exception.pojo.ExceptionEnum;
import cn.shop.common.exception.pojo.ShopException;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ItemService
 * @Description: 商品service
 * @author: yang
 * @date: 2021/1/7  15:14
 * @Service:
 */
@Service
public class ItemService {
    //模拟操作,抛出异常
    public Long saveItem(Long id){
        if (id.equals(1L)){
            throw new ShopException(ExceptionEnum.INVALID_NOTIFY_SIGN);
        }
        return id;
    }
}
