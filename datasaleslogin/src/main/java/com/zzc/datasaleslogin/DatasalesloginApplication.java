package com.zzc.datasaleslogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("com.zzc.datasaleslogin.Mapper")
public class DatasalesloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasalesloginApplication.class, args);
	}

}
