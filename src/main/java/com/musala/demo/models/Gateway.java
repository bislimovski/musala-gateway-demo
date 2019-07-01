package com.musala.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Gateway {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long serialNumber;
    private String name;
    private String ipAddress;

    @OneToMany(mappedBy = "gateway")
    private List<Peripheral> peripherals;

    public Gateway() {

    }

    public Gateway(Long serialNumber, String name, String ipAddress, List<Peripheral> peripherals) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.ipAddress = ipAddress;
        this.peripherals = peripherals;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(List<Peripheral> peripherals) {
        this.peripherals = peripherals;
    }
}
