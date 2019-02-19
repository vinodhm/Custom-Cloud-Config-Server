package com.vin.customconfig.converter;

import com.vin.customconfig.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class EncryptedStringConverter implements AttributeConverter<String,String> {

    private static EncryptionUtil encryptionUtil;

    @Autowired
    public void setEncryptionUtil(EncryptionUtil encryptionUtil){
        EncryptedStringConverter.encryptionUtil = encryptionUtil;
    }

    @Override
    public String convertToDatabaseColumn(String val) {
        return val.contains("encrypt.")?encryptionUtil.encrypt(val):val;
    }

    @Override
    public String convertToEntityAttribute(String val) {
        return val;//.contains("encrypted.")?encryptionUtil.decrypt(val):val
    }
}
