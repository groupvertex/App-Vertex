package $dubs;

import all.PropertiesDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vertex0008 on 02.07.2016.
 */
public class $boolean {

    @Autowired
    PropertiesDAO dao;// = PropertiesDaoFactory.getINstance();

    private final String propertyName;
    private final boolean default_value;

    public $boolean(String propertyName, boolean default_value) {
        this.propertyName = propertyName;
        this.default_value = default_value;
    }

    public boolean get() {
        String value = dao.get(propertyName);
        if (value == null) {
            return default_value;
        }
        return Boolean.parseBoolean(value);
    }
}
