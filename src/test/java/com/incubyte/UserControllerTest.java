package com.incubyte;

import com.incubyte.client.CrudClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class UserControllerTest {
    @Inject
    CrudClient client;

    @Test
    @DisplayName("Should Save And Return User Object On Controller's Save Method")
    public void should_save_and_return_user_object_on_controller_save_method() {
        User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        User userResponse = client.save(user).getData();
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getId()).isNotNull();
        assertThat(userResponse.getEmail()).isNotNull();
        assertThat(userResponse.getFirstName()).isNotNull();
        assertThat(userResponse.getLastName()).isNotNull();
        assertThat(userResponse.getAge()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Should Return User On Find By Id")
    public void should_return_user_on_find_by_id() {
        User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        User userResponse = client.save(user).getData();
        User findUser = client.findById(userResponse.getId()).getData();
        assertThat(findUser.getId()).isNotNull();
        //   Response<User> response = client.toBlocking().retrieve(HttpRequest.GET("/subscriber/" + userResponse.getId()), Argument.of(Response.class , User.class));
        assertThat(findUser.getEmail()).isNotNull();
        assertThat(findUser.getFirstName()).isNotNull();
        assertThat(findUser.getLastName()).isNotNull();
        assertThat(findUser.getAge()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Should Return Updated User On Update")
    public void should_return_updated_user_on_update() {
        User user1 = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        User user2 = new User("rananjay.singh5895@rediffmail.com", "Ran", "Singh", 29);
        User savedUser = client.save(user1).getData();
        User updatedUser = client.update(savedUser.getId(),user2).getData();
        assertThat(updatedUser.getId()).isNotNull();
        assertThat(updatedUser.getEmail()).isEqualTo("rananjay.singh5895@rediffmail.com");
        assertThat(updatedUser.getFirstName()).isEqualTo("Ran");
        assertThat(updatedUser.getAge()).isEqualTo(29);
    }

    @Test
    @DisplayName("Should Delete User on Deletion")
    public void should_delete_user_on_deletion() {
        User user = new User("rananjay.singh5895@gmail.com", "Rananjay", "Singh", 28);
        User savedUser = client.save(user).getData();
        Response.Status status = client.deleteById(savedUser.getId()).getStatus();
        assertThat(status).isEqualTo(Response.Status.SUCCESS);
    }
}
