package com.musala.demo.services;

import com.musala.demo.models.Peripheral;
import com.musala.demo.repositories.PeripheralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeripheralService {

    @Autowired
    private PeripheralRepository peripheralRepository;

    public List<Peripheral> getAllPeripherals(Long serialNumber) {
        List<Peripheral> peripherals = new ArrayList<>();
        peripheralRepository.findByGatewaySerialNumber(serialNumber).forEach(peripherals::add);
        return peripherals;
    }

    public Optional<Peripheral> getPeripheralByUid(Long serialNumber, Long uid) {
        return peripheralRepository.findPeripheralBySerialNumberAndUid(serialNumber, uid);
    }

    public void createPeripheral(Peripheral peripheral) {
        peripheralRepository.save(peripheral);
    }

    public void updatePeripheral(Long serviceNumber, Peripheral peripheral) {
        Optional<Peripheral> existedPeripheral = peripheralRepository.findPeripheralBySerialNumberAndUid(serviceNumber, peripheral.getUid());
//        if(existedPeripheral.isPresent()) {
//            peripheralRepository.save(peripheral);
//        }
        existedPeripheral.ifPresent(peripheral1 -> peripheralRepository.save(peripheral));
    }

    public void deletePeripheral(Long serviceNumber, Long peripheralId) {
        Optional<Peripheral> existedPeripheral = peripheralRepository.findPeripheralBySerialNumberAndUid(serviceNumber, peripheralId);
        existedPeripheral.ifPresent(peripheral1 -> peripheralRepository.delete(peripheral1));
    }

    public Long countBySerialNumber(Long serialNumber) {
        return peripheralRepository.countByGatewaySerialNumber(serialNumber);
    }
}
