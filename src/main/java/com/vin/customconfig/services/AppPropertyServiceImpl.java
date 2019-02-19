package com.vin.customconfig.services;

import com.vin.customconfig.beans.AppProperty;
import com.vin.customconfig.repo.AppPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppPropertyServiceImpl implements AppPropertyService {

    @Autowired
    AppPropertyRepository appPropertyRepository;

    @Override
    public List<AppProperty> showAllProperties() {
        return appPropertyRepository.findAll();
    }

    @Override
    public AppProperty save(AppProperty appProperty){
        return appPropertyRepository.save(appProperty);
    }
}
