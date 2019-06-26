package com.vin.customconfig.services;

import com.vin.customconfig.beans.AppProperty;
import com.vin.customconfig.repo.AppPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppPropertyServiceImpl implements AppPropertyService {

    @Autowired
    AppPropertyRepository appPropertyRepository;

    @Override
    public List<AppProperty> showAllProperties() {
        return appPropertyRepository.findAll();
    }

    @Override
    public AppProperty saveProperty(AppProperty appProperty) {
        return appPropertyRepository.save(appProperty);
    }

    @Override
    public AppProperty updateProperty(AppProperty appProperty) {
        return appPropertyRepository.save(appProperty);
    }

    @Override
    public void deletePropertyById(int id){
        appPropertyRepository.deleteById(id);
    }

    @Override
    public List<AppProperty> getPropertiesByColumns(String appName, String profile, String label) {
        return appPropertyRepository.findAll(Example.of(new AppProperty(null, appName, profile, null, null, label)));
    }

    @Override
    public Optional<AppProperty> getAppPropertyById(int propertyId) {
        return appPropertyRepository.findById(propertyId);
    }

}
