package com.incubyte;

import io.micronaut.http.annotation.*;

@Controller("/subscribe")
public class CrudController {
    private final CrudService crudService;

    public CrudController(CrudService crudService) {

        this.crudService = crudService;
    }

    @Post("/")
    public Response<User> save(@Body User user) {
        User savedUser =crudService.save(user);
        return new Response<>(savedUser, Response.Status.SUCCESS, null, null);
    }

    @Get("/subscriber/{id}")
    public Response<User> findById(@PathVariable Long id) {
        User user = crudService.findById(id);
        return new Response<>(user, Response.Status.SUCCESS, null, null);

    }

    @Put("/{id}")
    public Response<User> update(@PathVariable Long id, @Body User user) {
        User updatedUser = crudService.update(id, user);
        return new Response<>(updatedUser,Response.Status.SUCCESS,null,null);
    }

    @Delete("/{id}")
    public Response<User> deleteById(@PathVariable Long id) {
        User deletedUser = crudService.deleteById(id);
        return new Response<>(deletedUser,Response.Status.SUCCESS,null,null);
    }

}
