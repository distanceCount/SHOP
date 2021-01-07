package cn.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @SpringBootApplication  开启springboot服务
 * @EnableDiscoveryClient  注册服务中心
 * @EnableCircuitBreaker   开启断路器
 */
@SpringCloudApplication
public class ShopGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopGatewayApplication.class, args);
    }
}
