package in.ajay.foodiesapi.controller;

import in.ajay.foodiesapi.io.AuthenticationRequest;
import in.ajay.foodiesapi.io.AuthenticationResponse;
import in.ajay.foodiesapi.service.AppUserDeatailsService;
import in.ajay.foodiesapi.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AppUserDeatailsService userDeatailsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        final UserDetails userDetails=  userDeatailsService.loadUserByUsername(request.getEmail());
        final String jwtTokan = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponse(request.getEmail(), jwtTokan);

    }
}
