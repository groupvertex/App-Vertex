package all;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class ConfigManagerFactoryImpl implements ConfigManagerFactory {

    @Autowired
    private DataSource dataSourceConfig;

    public JdbcTemplateConfigManagerDAO getInstance() {
        JdbcTemplateConfigManagerDAO dao = new JdbcTemplateConfigManagerDAO(dataSourceConfig);
        dao.getMap().put("port", "8080");
        dao.getMap().put("host", "127.0.0.1");
        return dao;
    }
}