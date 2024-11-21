package com.scaler.nivedita.productservice.authCommons;

import com.scaler.nivedita.productservice.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {
    private RestTemplate restTemplate;
    public AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public UserDTO validateToken(String token){
     UserDTO userDTO = restTemplate.getForObject("http://localhost:4141/users/validate/" + token,UserDTO.class);
     return userDTO;
    }
}
