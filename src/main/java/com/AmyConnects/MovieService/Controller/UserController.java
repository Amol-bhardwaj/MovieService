package com.AmyConnects.MovieService.Controller;

import com.AmyConnects.MovieService.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Map<String, String> register(@RequestBody Map<String, String> request) {

        String token = userService.registerUser(
                request.get("name"),
                request.get("email")
        );

        return Map.of("token", token);
    }
}
