package in.ajay.foodiesapi.service;

import in.ajay.foodiesapi.entity.UserEntity;
import in.ajay.foodiesapi.io.UserRequest;
import in.ajay.foodiesapi.io.UserResponse;
import in.ajay.foodiesapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private  final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerUser(UserRequest request) {
      UserEntity newUser =  convertEntity(request);
      newUser = userRepository.save(newUser);
      return  convertToRespose(newUser);


    }

    private UserEntity convertEntity(UserRequest request) {
       return  UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build();
    }

    private UserResponse convertToRespose(UserEntity registeredUser) {
       return  UserResponse.builder()
               .id(registeredUser.getId())
                .email(registeredUser.getId())
                .name(registeredUser.getName())
                .email(registeredUser.getEmail())
                .build();

    }
}
