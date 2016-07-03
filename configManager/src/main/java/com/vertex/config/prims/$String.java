package com.vertex.config.prims;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

public class $String {
    DynamicStringProperty property;

    public $String(String propertyName, String defaultValue) {
        property = DynamicPropertyFactory.getInstance().getStringProperty(propertyName, defaultValue);
    }

    public String get() {
        return property.get();
    }
}
