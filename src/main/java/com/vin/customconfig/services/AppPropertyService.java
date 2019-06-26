package com.vin.customconfig.services;

import com.vin.customconfig.beans.AppProperty;

import java.util.List;
import java.util.Optional;

public interface AppPropertyService {

    List<AppProperty> showAllProperties();

    AppProperty saveProperty(AppProperty appProperty);

    AppProperty updateProperty(AppProperty appProperty);

    void deletePropertyById(int id);

    List<AppProperty> getPropertiesByColumns(String appName, String profile, String label);

    Optional<AppProperty> getAppPropertyById(int propertyId);
}
