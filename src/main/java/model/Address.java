package model;

import Utils.ReadPropertyFile;
import enums.ConfigProperties;

import java.util.HashMap;
import java.util.Map;

public enum Address {
    Company,
    Street,
    City,
    State,
    ZipCode,
    PhoneNumber;

    public static Map getAddress() {
        Map<Address, String> address = new HashMap<>();
        address.put(Company, ReadPropertyFile.getValue(ConfigProperties.COMPANY));
        address.put(Street, ReadPropertyFile.getValue(ConfigProperties.ADDRESS));
        address.put(City, ReadPropertyFile.getValue(ConfigProperties.CITY));
        address.put(State, ReadPropertyFile.getValue(ConfigProperties.STATE));
        address.put(ZipCode, ReadPropertyFile.getValue(ConfigProperties.ZIPCODE));
        address.put(PhoneNumber, ReadPropertyFile.getValue(ConfigProperties.NUMBER));
        return address;
    }
}
