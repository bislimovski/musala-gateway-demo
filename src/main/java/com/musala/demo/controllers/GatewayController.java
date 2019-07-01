package com.musala.demo.controllers;

import com.musala.demo.helpers.ResponseHelper;
import com.musala.demo.models.Gateway;
import com.musala.demo.services.GatewayService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    @RequestMapping("/gateways")
    public ResponseHelper getAllGateways() {
        //Spring automatically converts from array to json
        return new ResponseHelper<>(HttpStatus.OK, gatewayService.getAllGateways());

    }

    @RequestMapping("/gateways/{serialNumber}")
    public ResponseHelper getGatewayById(@PathVariable Long serialNumber) {
        Optional<Gateway> singleGateway = gatewayService.getGatewayBySerialNumber(serialNumber);
        if(singleGateway.isPresent()) {
            return new ResponseHelper<>(HttpStatus.OK, singleGateway.get());
        }
        return new ResponseHelper(HttpStatus.NOT_FOUND, "The record was not found.", false);
    }

    @RequestMapping(value = "/gateways", method = RequestMethod.POST)
    public ResponseHelper createGateway(Gateway gateway) {
        try {
            if(gatewayService.validateIpV4Address(gateway.getIpAddress())) {
                gatewayService.createGateway(gateway);
                return new ResponseHelper(HttpStatus.CREATED, "The gateway is stored", false);
            } else {
                return new ResponseHelper(HttpStatus.CONFLICT, "The entered IpAddress is not valid", true);
            }
        } catch (ConstraintViolationException e) {
            return new ResponseHelper(HttpStatus.CONFLICT, "The serialNumber must be unique", true);
        } catch (Exception e) {
            return new ResponseHelper(HttpStatus.BAD_REQUEST, "The record is not created. Please try again", true);
        }
    }

    @RequestMapping(value = "/gateways/{serialNumber}", method = RequestMethod.PUT)
    public ResponseHelper updateGateway(Gateway gateway) {
        try {
            if(gatewayService.validateIpV4Address(gateway.getIpAddress())) {
                gatewayService.updateGateway(gateway);
                return new ResponseHelper(HttpStatus.ACCEPTED, "The gateway is updated", false);
            } else {
                return new ResponseHelper(HttpStatus.CONFLICT, "The entered IpAddress is not valid", true);
            }
        } catch (Exception e) {
            return new ResponseHelper(HttpStatus.BAD_REQUEST, "The record is not updated. Please try again", true);
        }
    }

    @RequestMapping(value = "/gateways/{serialNumber}", method = RequestMethod.DELETE)
    public ResponseHelper deleteGateway(Gateway gateway) {
        try {
            gatewayService.deleteGateway(gateway);
            return new ResponseHelper(HttpStatus.ACCEPTED, "The gateway is deleted", false);
        } catch (Exception e) {
            return new ResponseHelper(HttpStatus.BAD_REQUEST, "The record is not deleted. Please try again", true);
        }
    }
}
