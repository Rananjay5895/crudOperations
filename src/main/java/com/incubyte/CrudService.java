package com.incubyte;

import com.incubyte.exception.CustomException;
import io.micronaut.context.annotation.Bean;

import java.util.Optional;

@Bean
public class CrudService {
    private final DemoCrudRepository crudRepository;

    public CrudService(DemoCrudRepository crudRepository) {

        this.crudRepository = crudRepository;
    }

    public User save(User user) {
        return crudRepository.save(user);
    }

    public User findById(long id) {
        return crudRepository.findById(id).orElse(null);
    }

    public User update(Long id, User user) {
        Optional<User> userDetail = crudRepository.findById(id);
        User savedUser;
        if (userDetail.isPresent()) {
            savedUser = userDetail.get();
        } else throw new CustomException("user not available");
        savedUser.setEmail(user.getEmail());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setAge(user.getAge());
        return crudRepository.update(savedUser);
    }

    public Response<String> deleteById(Long id) {
        crudRepository.deleteById(id);
        return new Response<String>(null, Response.Status.SUCCESS, "Successfully deleted message", null);
    }

}
