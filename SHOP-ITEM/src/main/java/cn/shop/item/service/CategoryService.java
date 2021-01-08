package cn.shop.item.service;

import cn.shop.common.exception.pojo.ExceptionEnum;
import cn.shop.common.exception.pojo.ShopException;
import cn.shop.item.mapper.CategoryMapper;
import cn.shop.item.pojo.Category;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: CategoryService
 * @Description: 分类service
 * @author: yang
 * @date: 2021/1/7  17:44
 */
@Service
@Transactional
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父id查询分类列表
     * @param pid
     * @return
     */
    public List<Category> findCategoriesByPId(Long pid) {
        /**
         * Wrappers类的方法
         * query(T): 简单条件查询（不含分页，复杂查询）
         * query(): 用于复杂查询（分页等）
         */
        //创建构造器放入构造条件
        Category category = new Category();
        category.setParentId(pid);
        QueryWrapper<Category> query = Wrappers.query(category);

        //执行查询,获取结果
        List<Category> categories = categoryMapper.selectList(query);

        //处理结果
        if (CollectionUtils.isEmpty(categories)){
            throw new ShopException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        //返回结果
        return categories;
    }
}
