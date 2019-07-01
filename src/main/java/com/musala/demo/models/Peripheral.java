package com.musala.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity
public class Peripheral {

    @Id
    @GeneratedValue
    private Long uid;
    private String vendor;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateCreated;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "gateway_serial_number")
    @JsonIgnore
    private Gateway gateway;

    public Peripheral() {

    }

    public Peripheral(Long uid, String vendor, Date dateCreated, Boolean status, Gateway gateway) {
        this.uid = uid;
        this.vendor = vendor;
        this.dateCreated = dateCreated;
        this.status = status;
        this.gateway = gateway;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }
}
