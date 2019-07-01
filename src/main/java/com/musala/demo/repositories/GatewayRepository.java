package com.musala.demo.repositories;

import com.musala.demo.models.Gateway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends CrudRepository<Gateway, Long> {
}
