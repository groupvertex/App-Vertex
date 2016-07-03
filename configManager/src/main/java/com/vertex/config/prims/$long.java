package com.vertex.config.prims;

import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;

/**
 * Created by Ololoev on 03.07.2016.
 */
public class $long {
    DynamicLongProperty property;

    public $long(String propertyName, long defaultValue) {
        property = DynamicPropertyFactory.getInstance().getLongProperty(propertyName, defaultValue);
    }

    public long get() {
        return property.get();
    }
}
