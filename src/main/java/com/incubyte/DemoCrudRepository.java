package com.incubyte;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface DemoCrudRepository extends CrudRepository<User , Long> {
}
