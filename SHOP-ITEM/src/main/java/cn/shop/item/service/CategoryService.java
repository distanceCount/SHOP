package cn.shop.item.service;

import cn.shop.item.mapper.CategoryMapper;
import cn.shop.item.pojo.Category;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CategoryService
 * @Description: 分类service
 * @author: yang
 * @date: 2021/1/7  17:44
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {
}
