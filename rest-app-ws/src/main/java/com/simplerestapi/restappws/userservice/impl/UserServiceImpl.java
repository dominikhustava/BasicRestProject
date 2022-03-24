package com.simplerestapi.restappws.userservice.impl;

import com.simplerestapi.restappws.shared.Utils;
import com.simplerestapi.restappws.ui.model.request.UserDetailsRequestModel;
import com.simplerestapi.restappws.ui.model.response.UserRest;
import com.simplerestapi.restappws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserID(userId);

        if(users==null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}
