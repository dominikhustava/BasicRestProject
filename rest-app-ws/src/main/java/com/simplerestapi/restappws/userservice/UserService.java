package com.simplerestapi.restappws.userservice;

import com.simplerestapi.restappws.ui.model.request.UserDetailsRequestModel;
import com.simplerestapi.restappws.ui.model.response.UserRest;

@Service
public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
