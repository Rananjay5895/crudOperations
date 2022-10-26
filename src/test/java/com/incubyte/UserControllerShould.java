package com.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerShould {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("Should Invoke Save Method Of Service")
    public void invoke_save_method_of_service() {
        User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        userController.save(user);
        verify(userService).save(user);
    }

    @Test
    @DisplayName("Should Invoke Find By Id Method Of Service")
    public void invoke_find_by_id_method_of_service() {
        userController.findById(1L);
        verify(userService).findById(1L);
    }

    @Test
    @DisplayName("Should Invoke Update Method Of Service")
    public void invoke_update_method_of_service() {
        User user = new User("rananjay.singh5895@rediffmail.com", "Ran", "Singh", 29);
        when(userService.update(1L, user)).thenReturn(user);
        User updatedUser = userController.update(1L, user).getData();
        assertNotNull(updatedUser);
        verify(userService).update(1L, user);
    }

    @Test
    @DisplayName("Should Invoke Delete Method Of Service")
    public void invoke_delete_method_of_service() {
        userController.deleteById(1L);
        verify(userService).deleteById(1L);
    }
}
