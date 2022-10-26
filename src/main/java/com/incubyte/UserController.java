package com.incubyte;

import io.micronaut.http.annotation.*;

@Controller("/subscribe")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @Post("/")
    public Response<User> save(@Body User user) {
        return Response.success(userService.save(user));
    }

    @Get("/subscriber/{id}")
    public Response<User> findById(@PathVariable Long id) {
        return Response.success(userService.findById(id));
    }

    @Put("/{id}")
    public Response<User> update(@PathVariable Long id, @Body User user) {
        return Response.success(userService.update(id, user));
    }

    @Delete("/{id}")
    public Response<User> deleteById(@PathVariable Long id) {
        return Response.success(userService.deleteById(id));
    }
}
