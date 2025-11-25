package com.example.serviceevent.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.serviceevent.Dto.UserDto;
@FeignClient(name = "serviceevenement")
public interface UserClient {

    @GetMapping("/api/users/{id}")

    UserDto getUserById(@PathVariable("id") Long id);
}
