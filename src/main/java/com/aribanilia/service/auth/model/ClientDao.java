package com.aribanilia.service.auth.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientDao extends CrudRepository<Client, Long> {

    @Query("select ca from Client ca where ca.username = :username")
    Client findByUsername(@Param("username") String username);

}
