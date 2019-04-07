package com.xaau.bs.busx.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/14
 */
@MapperScan("com.xaau.bs.busx.manager.mapper")
@SpringBootApplication
public class BusxManagerApplication {
  public static void main(String[] args) {
    SpringApplication.run(BusxManagerApplication.class, args);
  }

}
