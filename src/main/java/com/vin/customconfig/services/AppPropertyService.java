package com.vin.customconfig.services;

import com.vin.customconfig.beans.AppProperty;

import java.util.List;

public interface AppPropertyService {
    List<AppProperty> showAllProperties();
    AppProperty save(AppProperty appProperty);
}
