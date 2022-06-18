package com.example.server.controller;

import com.example.server.dto.Request;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerAipController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Request<User> post(
            @RequestBody Request<User> user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customHeader
    ) {
        log.info("UserId : {}, UserName : {}", userId, userName);
        log.info("authorization : {}, custom Header : {}", authorization, customHeader);
        log.info("client request : {}", user);

        Request<User> response = new Request<>();
        response.setHeader(new Request.Header());
        response.setResBody(user.getResBody());

        return response;
    }

}
