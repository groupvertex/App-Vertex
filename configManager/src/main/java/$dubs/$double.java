package $dubs;

import all.PropertiesDAO;

/**
 * Created by vertex0008 on 02.07.2016.
 */
public class $double{
    PropertiesDAO dao;

    private final String propertyName;
    private final double default_value;

    public $double(String propertyName, double default_value) {
        this.propertyName = propertyName;
        this.default_value = default_value;
    }

    public double get() {
        String value = dao.get(propertyName);
        if (value == null) {
            return default_value;
        }
        return Double.parseDouble(value);
    }
}
