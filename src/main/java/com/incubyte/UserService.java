package com.incubyte;

import com.incubyte.user_exception.UserNotFoundException;
import jakarta.inject.Singleton;

import javax.validation.constraints.NotNull;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public User update(Long id, User user) {
        User userDetail = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userDetail.setEmail(user.getEmail());
        userDetail.setFirstName(user.getFirstName());
        userDetail.setAge(user.getAge());
        return userRepository.update(userDetail);
    }

    public User deleteById(Long id) {//Response<String>
        userRepository.deleteById(id);
        return userRepository.findById(id).orElse(null);
        //   return new Response<String>(null, Response.Status.SUCCESS, "Successfully deleted message", null);
    }
}
