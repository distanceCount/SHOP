package cn.shop.item.controller;

import cn.shop.item.pojo.Category;
import cn.shop.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: CategoryController
 * @Description: 分类controller
 * @author: yang
 * @date: 2021/1/8  9:07
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父id查询分类列表
     * @return
     */
    @GetMapping("/category/of/parent")
    public ResponseEntity<List<Category>> findCategoriesByPId(@RequestParam("pid") Long pid){
        List<Category> Categories = categoryService.findCategoriesByPId(pid);
        return ResponseEntity.ok(Categories);
    }
}
