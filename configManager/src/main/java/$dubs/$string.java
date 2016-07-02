package $dubs;

import all.PropertiesDAO;

/**
 * Created by vertex0008 on 02.07.2016.
 */
public class $string {
    PropertiesDAO dao;

    private final String propertyName;
    private final String default_value;

    public $string(String propertyName, String default_value) {
        this.propertyName = propertyName;
        this.default_value = default_value;
    }

    public String get() {
        String value = dao.get(propertyName);
        if (value == null) {
            return default_value;
        }
        return propertyName;
    }
}
