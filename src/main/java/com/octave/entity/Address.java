package com.octave.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer address;

    private String detialAddress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getDetialAddress() {
        return detialAddress;
    }

    public void setDetialAddress(String detialAddress) {
        this.detialAddress = detialAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address1 = (Address) o;

        if (userId != null ? !userId.equals(address1.userId) : address1.userId != null)
            return false;
        if (address != null ? !address.equals(address1.address) : address1.address != null)
            return false;
        return detialAddress != null ? detialAddress.equals(address1.detialAddress) : address1.detialAddress == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (detialAddress != null ? detialAddress.hashCode() : 0);
        return result;
    }
}