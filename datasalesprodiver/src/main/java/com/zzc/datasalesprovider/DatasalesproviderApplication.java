package com.zzc.datasalesprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zzc.datasalesprovider.mapper")
public class DatasalesproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasalesproviderApplication.class, args);
	}

}
