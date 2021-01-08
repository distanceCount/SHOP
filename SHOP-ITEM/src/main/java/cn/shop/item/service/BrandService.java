package cn.shop.item.service;

import cn.shop.common.exception.pojo.ExceptionEnum;
import cn.shop.common.exception.pojo.ShopException;
import cn.shop.common.pojo.PageResult;
import cn.shop.item.mapper.BrandMapper;
import cn.shop.item.pojo.Brand;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: BrandService
 * @Description: TODO
 * @author: yang
 * @date: 2021/1/8  11:18
 */
@Service
@Transactional
public class BrandService extends ServiceImpl<BrandMapper, Brand> {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 品牌分页查询
     * @param page
     * @param rows
     * @param key
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> brandPageQuery(Integer page, Integer rows, String key, String sortBy, Boolean desc) {
        //1.封装查询条件
        // 1.1 IPage对象：封装分页参数
        // (查询前：IPage对象封装页面->后端数据)
        // PageHelper.startPage(page,rows);
        IPage<Brand> iPage = new Page<>(page,rows);
        QueryWrapper<Brand> query = Wrappers.query();
        //1.2 wrapper: 查询条件
        if (StringUtils.isNotEmpty(key)){
            query
                    .like("name",key)
                    .or()
                    .eq("letter",key.toUpperCase());

        }
        if (StringUtils.isNotEmpty(sortBy)){
            if (desc){
                //降序
                query.orderByDesc(sortBy);
            }else {
                query.orderByAsc(sortBy);
            }
        }

        //查询数据,获取结果
        iPage = brandMapper.selectPage(iPage,query);

        //封装处理结果
        PageResult<Brand> pageResult = new PageResult<>(iPage.getTotal(), iPage.getPages(), iPage.getRecords());

        return pageResult;
    }

    /**
     * 添加品牌
     * @param brand
     * @param cids
     */
    public void saveBrand(Brand brand, List<Long> cids) {
        try {
            //插入数据库
            brandMapper.insert(brand);
            //关联中间表(此处brandId是MyBatis-Plus中insert方法会自动到数据库 获取自增值赋值给对象的ID)
            brandMapper.saveCategoryAndBrand(cids,brand.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ShopException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }

    }
}
