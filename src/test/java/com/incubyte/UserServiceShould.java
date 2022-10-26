package com.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceShould {
    @Mock
    UserRepository crudRepository;

    @Test
    @DisplayName("Should Invoke Save Method Of Crud Repository")
    public void invoke_save_method_of_crud_repository() {
        User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        UserService userService = new UserService(crudRepository);
        userService.save(user);
        verify(crudRepository).save(user);
    }

    @Test
    @DisplayName("Should Invoke Find By Id Method Of Repository")
    public void invoke_find_by_id_method_of_repository() {
       User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        UserService userService = new UserService(crudRepository);
        when(crudRepository.findById(1l)).thenReturn(Optional.of(user));
       User findUser = userService.findById(1l);
        verify(crudRepository).findById(1l);
        assertThat(findUser.getEmail()).isEqualTo("rananjay.singh5895@gmail.com");
    }

    @Test
    @DisplayName("Should Invoke Update Method Of Repository")
    public void invoke_update_method_of_repository() {
        User user = new User("rananjay.singh5895@rediffmail.com", "Ran", "Singh", 29);
        UserService userService = new UserService(crudRepository);
        when(crudRepository.findById(1L)).thenReturn(Optional.of(user));
        userService.update(1L, user);
        verify(crudRepository).update(user);
    }

    @Test
    @DisplayName("Should Invoke Delete By Id Method Of Repository")
    public void invoke_delete_by_id_method_of_repository() {
        UserService userService = new UserService(crudRepository);
        userService.deleteById(1L);
        verify(crudRepository).deleteById(1L);
    }
}
