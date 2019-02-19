package com.vin.customconfig.beans;

import com.vin.customconfig.converter.EncryptedStringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PROPERTIES")
public class AppProperty {

    @Column @Id
    private int id;

    @Column
    private String application;

    @Column
    private String profile;

    @Column(name = "KY")
    private String key;

    @Column
    @Convert(converter = EncryptedStringConverter.class)
    private String value;

    @Column
    private String label;
}
