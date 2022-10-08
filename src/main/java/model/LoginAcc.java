package model;

import Utils.ReadPropertyFile;
import enums.ConfigProperties;

import java.util.HashMap;
import java.util.Map;

public enum LoginAcc {
    Email,
    Password;

    public static Map getCredentials() {
        Map<LoginAcc, String> login = new HashMap<>();
        login.put(Email, ReadPropertyFile.getValue(ConfigProperties.EMAIL));
        login.put(Password, ReadPropertyFile.getValue(ConfigProperties.PASSWORD));
        return login;
    }
}
