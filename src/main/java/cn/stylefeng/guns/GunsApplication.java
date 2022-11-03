package cn.stylefeng.guns;

import cn.stylefeng.roses.kernel.db.starter.GunsDataSourceAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

/**
 * SpringBoot方式启动类
 *
 * @author fengshuonan
 * @date 2020/12/1 17:50
 */
@Slf4j
@MapperScan("cn.stylefeng.guns.modular.demo.dao")
@SpringBootApplication(scanBasePackages = {"cn.stylefeng"}, exclude = {FlywayAutoConfiguration.class, GunsDataSourceAutoConfiguration.class,})
public class GunsApplication {

    public static void main(String[] args) {
        // 菜单
        log.info("http://localhost:8080/view/menu");


        SpringApplication.run(GunsApplication.class, args);
        log.info(GunsApplication.class.getSimpleName() + " is success!");
        log.info("http://localhost:8080");


    }

}

