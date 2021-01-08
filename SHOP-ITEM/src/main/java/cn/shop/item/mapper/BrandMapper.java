package cn.shop.item.mapper;

import cn.shop.item.pojo.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @ClassName: CategoryMapper
 * @Description: 分类mapper
 * @author: yang
 * @date: 2021/1/7  17:32
 */
public interface BrandMapper extends BaseMapper<Brand> {

    void saveCategoryAndBrand(List<Long> cids, Long id);
}
