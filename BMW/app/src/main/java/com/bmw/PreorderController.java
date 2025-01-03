package com.bmw;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PreorderController {
    @Autowired
    private PreorderRepository preorderRepository;

   @GetMapping("/")
   public String getMethodName(@RequestParam String param) {
       return new String();
   }
   
}
