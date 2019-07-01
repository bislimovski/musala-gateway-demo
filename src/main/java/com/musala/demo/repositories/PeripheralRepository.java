package com.musala.demo.repositories;

import com.musala.demo.models.Peripheral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeripheralRepository extends CrudRepository<Peripheral, Long> {

    List<Peripheral> findByGatewaySerialNumber(Long serialNumber);
    Long countByGatewaySerialNumber(Long serialNumber);

    @Query(value = "SELECT * FROM peripheral WHERE gateway_serial_number = ? AND uid = ? LIMIT 1", nativeQuery = true)
    Optional<Peripheral> findPeripheralBySerialNumberAndUid(Long serialNumber, Long uid);
}
