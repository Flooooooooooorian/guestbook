package com.github.moinmarcell.backend.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/me")
    public String helloMe(Principal principal){
        if(principal != null){
            return principal.getName();
        }
        return "noob";
    }

    @PostMapping("/login")
    public Object login(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
