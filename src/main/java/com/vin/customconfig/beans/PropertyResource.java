package com.vin.customconfig.beans;

import com.vin.customconfig.controller.AppPropertiesController;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PropertyResource extends ResourceSupport {

    private final AppProperty appProperty;

    public PropertyResource(final AppProperty appProperty){
        this.appProperty=appProperty;
        final int id = appProperty.getId();
        add(linkTo(methodOn(AppPropertiesController.class).getPropertyById(id)).withSelfRel());
    }
}

