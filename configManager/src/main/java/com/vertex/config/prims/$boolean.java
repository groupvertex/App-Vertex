package com.vertex.config.prims;

import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicPropertyFactory;

public class $boolean {

    DynamicBooleanProperty property;

    public $boolean(String propertyName, boolean defaultValue) {
        property = DynamicPropertyFactory.getInstance().getBooleanProperty(propertyName, defaultValue);
    }

    public boolean get() {
        return property.get();
    }
}
