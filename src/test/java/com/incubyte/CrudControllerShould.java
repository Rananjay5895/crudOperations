package com.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CrudControllerShould {

    @Mock
    CrudService crudService;

    @Test
    @DisplayName("Should Invoke Save Method Of Service")
    public void should_invoke_save_method_of_service() {
        User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        CrudController crudController = new CrudController(crudService);
        crudController.save(user);
        verify(crudService).save(user);
    }

    @Test
    @DisplayName("Should Invoke Find By Id Method Of Service")
    public void should_invoke_find_by_id_method_of_service() {
        CrudController crudController = new CrudController(crudService);
        crudController.findById(1L);
        verify(crudService).findById(1L);
    }

    @Test
    @DisplayName("Should Invoke Update Method Of Service")
    public void should_invoke_update_method_of_service() {
        User user = new User("rananjay.singh5895@rediffmail.com", "Ran", "Singh", 29);
        CrudController crudController = new CrudController(crudService);
        crudController.update(1L, user);
        verify(crudService).update(1L, user);
    }

    @Test
    @DisplayName("Should Invoke Delete Method Of Service")
    public void should_invoke_delete_method_of_service()    {
        CrudController crudController = new CrudController(crudService);
        crudController.deleteById(1L);
        verify(crudService).deleteById(1L);
    }
}
