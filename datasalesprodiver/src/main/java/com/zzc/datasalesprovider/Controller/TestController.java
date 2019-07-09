package com.zzc.datasalesprovider.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @RequestMapping("/test")
  public String test(){
    return System.currentTimeMillis() + "服务提供者:datasalesprovider1";
  }
}
