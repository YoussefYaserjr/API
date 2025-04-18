package com.codewithmosh.store.Controllers;

import com.codewithmosh.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//REST-->Representation Stat Transfer
public class MessageController {
    @RequestMapping("/hello")
public Message sayHello() {
return new Message("Hello World!!!!!!");
}
}
