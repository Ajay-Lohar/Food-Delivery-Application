package in.ajay.foodiesapi.service;

import in.ajay.foodiesapi.io.UserRequest;
import in.ajay.foodiesapi.io.UserResponse;

public interface UserService {

   UserResponse registerUser(UserRequest request);

   String findByUserId();
}
