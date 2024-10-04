package com.toolbox.toolbox.web.controller;

import com.toolbox.toolbox.Domain.DTO.AuthResponseDTO;
import com.toolbox.toolbox.Domain.DTO.LoginDTO;
import com.toolbox.toolbox.persistance.entity.Role;
import com.toolbox.toolbox.persistance.entity.User;
import com.toolbox.toolbox.persistance.repository.RoleRepository;
import com.toolbox.toolbox.persistance.repository.UserRepository;
import com.toolbox.toolbox.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.toolbox.toolbox.Domain.DTO.RegisterDTO;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/auth/")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    @Autowired

    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                          RoleRepository roleRepository, UserRepository userRepository, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }


    @PostMapping("register")
    public ResponseEntity <String> register(@RequestBody RegisterDTO registerDTO){
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("user already exists", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role role = roleRepository.findByRoleName("user").get();
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
        return new ResponseEntity<>("user registered succefully", HttpStatus.OK);
    }

    @PostMapping("registeradmin")
    public ResponseEntity <String> registerAdmin(@RequestBody RegisterDTO registerDTO){
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("user already exists", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role role = roleRepository.findByRoleName("admin").get();
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
        return new ResponseEntity<>("user registered succefully", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity <AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(), loginDTO.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
}
