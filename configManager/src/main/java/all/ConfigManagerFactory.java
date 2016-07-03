package all;

import javax.sql.DataSource;

/**
 * Created by Vasyl on 02/07/2016.
 */
public interface ConfigManagerFactory {
    JdbcTemplateConfigManagerDAO getInstance();
}
