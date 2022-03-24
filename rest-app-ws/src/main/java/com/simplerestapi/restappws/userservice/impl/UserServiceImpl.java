package com.simplerestapi.restappws.userservice.impl;

import com.simplerestapi.restappws.ui.model.request.UserDetailsRequestModel;
import com.simplerestapi.restappws.ui.model.response.UserRest;
import com.simplerestapi.restappws.userservice.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserID(userId);

        if(users==null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}