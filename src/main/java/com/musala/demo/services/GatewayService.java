package com.musala.demo.services;

import com.musala.demo.models.Gateway;
import com.musala.demo.repositories.GatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class GatewayService {

    @Autowired
    private GatewayRepository gatewayRepository;

    private final Pattern ipAddressRegex = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public List<Gateway> getAllGateways() {
        List<Gateway> gateways = new ArrayList<>();
        gatewayRepository.findAll().forEach(gateways::add);
        return gateways;
    }

    public Optional<Gateway> getGatewayBySerialNumber(Long serialNumber) {
        return gatewayRepository.findById(serialNumber);
    }

    public void createGateway(Gateway gateway) {
        gatewayRepository.save(gateway);
    }

    public void updateGateway(Gateway gateway) {
        gatewayRepository.save(gateway);
    }

    public void deleteGateway(Gateway gateway) {
        gatewayRepository.delete(gateway);
    }

    public boolean validateIpV4Address(String ipV4Address) {
        return ipAddressRegex.matcher(ipV4Address).matches();
    }


}
