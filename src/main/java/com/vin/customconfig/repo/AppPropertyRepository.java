package com.vin.customconfig.repo;

import com.vin.customconfig.beans.AppProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppPropertyRepository extends JpaRepository<AppProperty,Integer> {

}

