package com.incubyte;

import org.assertj.core.api.Assertions;
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
public class CrudServiceShould {
    @Mock
    DemoCrudRepository crudRepository;

    @Test
    @DisplayName("Should Invoke Save Method Of Crud Repository")
    public void should_invoke_save_method_of_crud_repository() {
        User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        CrudService crudService = new CrudService(crudRepository);
        crudService.save(user);
        verify(crudRepository).save(user);
    }

    @Test
    @DisplayName("Should Invoke Find By Id Method Of Repository")
    public void should_invoke_find_by_id_method_of_repository() {
       User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        CrudService crudService = new CrudService(crudRepository);
        when(crudRepository.findById(1l)).thenReturn(Optional.of(user));
       User findUser = crudService.findById(1l);
        verify(crudRepository).findById(1l);
        assertThat(findUser.getEmail()).isEqualTo("rananjay.singh5895@gmail.com");
    }

    @Test
    @DisplayName("Should Invoke Update Method Of Repository")
    public void should_invoke_update_method_of_repository() {
        User user = new User("rananjay.singh5895@rediffmail.com", "Ran", "Singh", 29);
        CrudService crudService = new CrudService(crudRepository);
        when(crudRepository.findById(1L)).thenReturn(Optional.of(user));
        crudService.update(1L, user);
        verify(crudRepository).update(user);
    }

    @Test
    @DisplayName("Should Invoke Delete By Id Method Of Repository")
    public void should_invoke_delete_by_id_method_of_repository() {
        CrudService crudService = new CrudService(crudRepository);
        crudService.deleteById(1L);
        verify(crudRepository).deleteById(1L);
    }
}
