package com.kajalk11.AR.BUSINESS.CARD.user.service;

import com.kajalk11.AR.BUSINESS.CARD.user.exception.DuplicateEmailException;
import com.kajalk11.AR.BUSINESS.CARD.user.exception.ResourceNotFoundException;
import com.kajalk11.AR.BUSINESS.CARD.user.model.User;
import com.kajalk11.AR.BUSINESS.CARD.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements Userimpl {

   private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User CreateUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("User ALREADY EXISTS WITH EMAIL:" + user.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getALLUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not found with id:" + id));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email:" + email));
    }

    private void orElseThrow(Object o) {
    }

    @Override
    public User updateUser(long id ,User userDetail){
        User user =userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not fond with id:"+id));

        user.setName(userDetail.getName());
        user.setCompany(userDetail.getCompany());
        user.setPhone(userDetail.getPhone());
        user.setJobTitle(userDetail.getJobTitle());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("user not found with id:"+id));
        userRepository.delete(user);
    }
}