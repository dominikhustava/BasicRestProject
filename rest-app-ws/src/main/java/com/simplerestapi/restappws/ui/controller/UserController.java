package com.simplerestapi.restappws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="50" ) int limit,
                           @RequestParam(value="sort", required = false) String sort)
    {
        if (sort == null){sort = "not used";}
        return "getUsers was called with page = " + page + " and limit = " + limit + " sort = " + sort;
    }

    @GetMapping(path="/{userId}")
    public String getUser(@PathVariable String userId){
        return "getUser was called " + userId;
    }

    @PostMapping
    public String createUser(){
        return "createUser was called";
    }

    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "deleteUser was called";
    }

}
