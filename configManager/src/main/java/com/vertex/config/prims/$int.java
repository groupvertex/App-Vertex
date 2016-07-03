package com.vertex.config.prims;

import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;

public class $int {

    DynamicIntProperty property;

    public $int(String propertyName, int defaultValue) {
        property = DynamicPropertyFactory.getInstance().getIntProperty(propertyName, defaultValue);
    }

    public int get() {
        return property.get();
    }
}
