package com.incubyte;

import com.incubyte.exception.CustomException;
import io.micronaut.context.annotation.Bean;

import java.util.Optional;

@Singleton
public class UserService {
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

        //TODO: Throw Exception 
        if (userDetail.isPresent()) {
            savedUser = userDetail.get();
        } else throw new CustomException("user not available");
        savedUser.setEmail(user.getEmail());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setAge(user.getAge());
        return crudRepository.update(savedUser);
    }

    public String deleteById(Long id) {
        //TODO: Response is something that is relavant to the Controller or API Layer. It has nothing 
        return crudRepository.deleteById(id);
        return new Response<String>(null, Response.Status.SUCCESS, "Successfully deleted message", null);
    }

}
