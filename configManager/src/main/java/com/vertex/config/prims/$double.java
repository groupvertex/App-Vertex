package com.vertex.config.prims;

import com.netflix.config.DynamicDoubleProperty;
import com.netflix.config.DynamicPropertyFactory;

public class $double {

    DynamicDoubleProperty property;

    public $double(String propertyName, double defaultValue) {
        property = DynamicPropertyFactory.getInstance().getDoubleProperty(propertyName, defaultValue);
    }

    public double get() {
        return property.get();
    }
}