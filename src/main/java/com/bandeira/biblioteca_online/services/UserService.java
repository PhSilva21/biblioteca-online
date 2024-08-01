package com.bandeira.biblioteca_online.services;

import com.bandeira.biblioteca_online.dtos.UpdateUserDTO;
import com.bandeira.biblioteca_online.dtos.UserRequest;
import com.bandeira.biblioteca_online.exceptions.EmailAlreadyExistsException;
import com.bandeira.biblioteca_online.exceptions.IncorrectPasswordException;
import com.bandeira.biblioteca_online.exceptions.PasswordsDoNotMatch;
import com.bandeira.biblioteca_online.exceptions.UserNotFoundException;
import com.bandeira.biblioteca_online.model.User;
import com.bandeira.biblioteca_online.model.UserRole;
import com.bandeira.biblioteca_online.repositories.UserRepository;
import com.bandeira.biblioteca_online.util.RandomString;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserRequest createUser(UserRequest userRequest) throws JsonProcessingException {
        if (userRepository.findByEmail(userRequest.email()) != null) {
            throw new EmailAlreadyExistsException();
        } else {

            User user = new User(
                    userRequest.name(),
                    userRequest.email(),
                    userRequest.password(),
                    UserRole.USER
            );

            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);


            userRepository.save(user);


            return userRequest;
        }
    }


    public void updateUser(UpdateUserDTO updateUserDTO){
        var user = userRepository.findById(updateUserDTO.id())
                .orElseThrow(UserNotFoundException::new);

        if(updateUserDTO.name() != null){
            user.setName(updateUserDTO.name());
        }

        if(updateUserDTO.cpf() != null){
            user.setName(updateUserDTO.cpf());
        }

        userRepository.save(user);
    }



    public String updateEmail(Long id, String password,  String email) {

        var user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        if(!password.equals(user.getPassword())){
            throw new IncorrectPasswordException();
        }

        user.setEmail(email);

        userRepository.save(user);

        return "Your email has been updated successfully";
    }


    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }



    public String updatePassword(Long id, String password, String newPassword, String passwordConfirmation) {

        var user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        if (!user.getPassword().equals(password)){
            throw new IncorrectPasswordException();
        }

        if (!newPassword.equals(passwordConfirmation)){
            throw new PasswordsDoNotMatch();
        }

        user.setPassword(password);

        userRepository.save(user);

        return "Your password has been updated successfully";
    }


    public void deleteById(Long id){
        userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        userRepository.deleteById(id);
    }


}
