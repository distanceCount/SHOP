package cn.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 商品微服务
 * @MapperScan: 指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.shop.item.mapper")
public class ShopItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopItemApplication.class, args);
    }
}
