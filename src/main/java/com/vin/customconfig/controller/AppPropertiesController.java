package com.vin.customconfig.controller;

import com.vin.customconfig.beans.AppProperty;
import com.vin.customconfig.beans.PropertyResource;
import com.vin.customconfig.services.AppPropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Api(description = "Cloud config server integrated with JDBC")
@RestController
public class AppPropertiesController {

    AppPropertyService appPropertyService;

    @Autowired
    AppPropertiesController(AppPropertyService appPropertyService) {
        this.appPropertyService = appPropertyService;
    }

    @GetMapping(path = "/appProperties", produces = "application/hal+json")
    @ApiOperation("shows all the properties configured for all the applications")
    public ResponseEntity<Resources<PropertyResource>> allApplicationsProperties() {
        final List<PropertyResource>  collection = appPropertyService.showAllProperties().stream().map(PropertyResource::new).collect(Collectors.toList());
        final Resources<PropertyResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add( new Link(uriString,"self"));
        return ResponseEntity.ok(resources);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/properties", produces = "application/hal+json")
    @ApiOperation("shows all the properties configured for all the applications")
    public List<AppProperty> getApplicationsProperties() {
        return appPropertyService.showAllProperties();
    }

    @GetMapping("/properties/{application}/{profile}/{label}")
    @ApiOperation("shows all the properties based on the appName, profile, label..")
    public List<AppProperty> applicationsPropertiesByApp(
            @PathVariable String application, @PathVariable String profile,
            @PathVariable String label) {
        return appPropertyService.getPropertiesByColumns(application,profile,label);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path="/property", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("shows all the properties configured for all the applications")
    public AppProperty saveProperty(@RequestBody AppProperty appProperty){
        return appPropertyService.saveProperty(appProperty);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path="/property/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("shows all the properties configured for all the applications")
    public AppProperty updateProperty(@RequestBody AppProperty appProperty, @PathVariable int id){
        return appPropertyService.updateProperty(appProperty);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/property/{id}")
    @ApiOperation("delete the property based on the property id.")
    public void deleteProperty(@PathVariable int id) {
        appPropertyService.deletePropertyById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/property/{id}")
    @ApiOperation("delete the property based on the property id.")
    public AppProperty getPropertyById(@PathVariable int id) {
        return appPropertyService.getAppPropertyById(id).get();
    }

}
