package $dubs;

import all.PropertiesDAO;

/**
 * Created by vertex0008 on 02.07.2016.
 */
public class $int{
    PropertiesDAO dao;

    private final String propertyName;
    private final int default_value;

    public $int(String propertyName, int default_value) {
        this.propertyName = propertyName;
        this.default_value = default_value;
    }

    public int get() {
        String value = dao.get(propertyName);
        if (value == null) {
            return default_value;
        }
        return Integer.parseInt(value);
    }
}
