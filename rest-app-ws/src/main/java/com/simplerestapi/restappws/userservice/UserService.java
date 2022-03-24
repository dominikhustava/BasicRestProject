package com.simplerestapi.restappws.userservice;

import com.simplerestapi.restappws.ui.model.request.UserDetailsRequestModel;
import com.simplerestapi.restappws.ui.model.response.UserRest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
