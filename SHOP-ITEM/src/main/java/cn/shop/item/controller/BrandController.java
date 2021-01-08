package cn.shop.item.controller;

import cn.shop.common.pojo.PageResult;
import cn.shop.item.pojo.Brand;
import cn.shop.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: BrandController
 * @Description: TODO
 * @author: yang
 * @date: 2021/1/8  11:19
 */
@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
      * 品牌分页查询
      * @RequestParam
      * defaultValue: 默认值，在值为NULL使用
      * required： 是否必填 true，必填（没有值报错）， false: 不是必填（没有值就是 NULL）
      */
    @GetMapping("/brand/page")
    public ResponseEntity<PageResult<Brand>> brandPageQuery(
            @RequestParam(value="page",defaultValue = "1") Integer page,
            @RequestParam(value="rows",defaultValue = "5") Integer rows,
            @RequestParam(value="key",required = false) String key,
            @RequestParam(value="sortBy",required = false) String sortBy,
            @RequestParam(value="desc",required = false) Boolean desc )
    {
        PageResult<Brand> pageResult = brandService.brandPageQuery(page,rows,key,sortBy,desc);
        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("/brand")
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids")List<Long> cids){
         brandService.saveBrand(brand,cids);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
