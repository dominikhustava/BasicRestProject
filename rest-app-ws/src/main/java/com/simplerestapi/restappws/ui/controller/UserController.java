package com.simplerestapi.restappws.ui.controller;

import com.simplerestapi.restappws.exceptions.UserServiceCustomException;
import com.simplerestapi.restappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.simplerestapi.restappws.ui.model.request.UserDetailsRequestModel;
import com.simplerestapi.restappws.ui.model.response.UserRest;
import com.simplerestapi.restappws.userservice.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="50" ) int limit,
                           @RequestParam(value="sort", required = false) String sort)
    {
        if (sort == null){sort = "not used";}
        return "getUsers was called with page = " + page + " and limit = " + limit + " sort = " + sort;
    }

    @GetMapping(path="/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        //to cause nullpointer
        //String firstName = null;
        //int firstNameLength =  firstName.length();

        if(true) throw new UserServiceCustomException("A user service custom exception is thrown");

        if(users.containsKey(userId)){
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserServiceImpl().createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        users.remove(id);
        //204 No Content
        return ResponseEntity.noContent().build();
    }

}
