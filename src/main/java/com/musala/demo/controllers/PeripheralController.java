package com.musala.demo.controllers;

import com.musala.demo.helpers.ResponseHelper;
import com.musala.demo.models.Peripheral;
import com.musala.demo.services.PeripheralService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PeripheralController {

    @Autowired
    private PeripheralService peripheralService;

    @RequestMapping("/gateways/{serialNumber}/peripherals")
    public ResponseHelper getAllPeripherals(@PathVariable Long serialNumber) {
        //Spring automatically converts from array to json
//        return peripheralService.getAllPeripherals(serialNumber);
        return new ResponseHelper<>(HttpStatus.OK, peripheralService.getAllPeripherals(serialNumber));
    }

    @RequestMapping("/gateways/{serialNumber}/peripherals/{uid}")
    public ResponseHelper getPeripheralById(@PathVariable Long serialNumber, @PathVariable Long uid) {
        Optional<Peripheral> singlePeripheral = peripheralService.getPeripheralByUid(serialNumber, uid);
        if(singlePeripheral != null) {
            return new ResponseHelper<>(HttpStatus.OK, peripheralService.getAllPeripherals(serialNumber));
        }
        return new ResponseHelper(HttpStatus.NOT_FOUND, "The uid must be unique", true);

    }

    @RequestMapping(value = "/gateways/{serialNumber}/peripherals", method = RequestMethod.POST)
    public ResponseHelper createPeripheral(@PathVariable Long serialNumber, Peripheral peripheral) {
        try {
            if(peripheralService.countBySerialNumber(serialNumber) < 10) {
                peripheralService.createPeripheral(peripheral);
                return new ResponseHelper(HttpStatus.CREATED, "The peripheral is stored", false);
            } else {
                return new ResponseHelper(HttpStatus.CONFLICT, "Limit is reached. You cannot create peripheral for this serialNumber", true);
            }
        } catch (ConstraintViolationException e) {
            return new ResponseHelper(HttpStatus.CONFLICT, "The uid must be unique", true);
        } catch (Exception e) {
            return new ResponseHelper(HttpStatus.BAD_REQUEST, "The record is not created. Please try again", true);
        }
    }

    @RequestMapping(value = "/gateways/{serialNumber}/peripherals/{uid}", method = RequestMethod.PUT)
    public ResponseHelper updatePeripheral(@PathVariable Long serialNumber, Peripheral peripheral) {
        try {
            if(peripheralService.countBySerialNumber(serialNumber) < 10) {
                peripheralService.updatePeripheral(serialNumber, peripheral);
                return new ResponseHelper(HttpStatus.ACCEPTED, "The peripheral is updated", false);
            } else {
                return new ResponseHelper(HttpStatus.CONFLICT, "Limit is reached. You cannot create peripheral for this serialNumber", true);
            }
        } catch (Exception e) {
            return new ResponseHelper(HttpStatus.BAD_REQUEST, "The record is not updated. Please try again", true);
        }
    }

    @RequestMapping(value = "/gateways/{serialNumber}/peripherals/{uid}", method = RequestMethod.DELETE)
    public ResponseHelper deletePeripheral(@PathVariable Long serialNumber, @PathVariable Long uid) {
        try {
            peripheralService.deletePeripheral(serialNumber, uid);
            return new ResponseHelper(HttpStatus.ACCEPTED, "The peripheral is deleted", false);

        } catch (Exception e) {
            return new ResponseHelper(HttpStatus.BAD_REQUEST, "The record is not deleted. Please try again", true);
        }
    }
}
