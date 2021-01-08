package cn.shop.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: PageResult
 * @Description: TODO
 * @author: yang
 * @date: 2021/1/8  11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;//总记录数
    private Long totalPage;//总页数
    private List<T> items;//当前页数据
}
