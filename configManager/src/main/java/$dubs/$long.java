package $dubs;

import all.PropertiesDAO;

/**
 * Created by vertex0008 on 02.07.2016.
 */
public class $long{
    PropertiesDAO dao;

    private final String propertyName;
    private final long default_value;

    public $long(String propertyName, long default_value) {
        this.propertyName = propertyName;
        this.default_value = default_value;
    }

    public long get() {
        String value = dao.get(propertyName);
        if (value == null) {
            return default_value;
        }
        return Long.parseLong(value);
    }
}
