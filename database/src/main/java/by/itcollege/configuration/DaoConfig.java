package by.itcollege.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("by.itcollege")
@PropertySource("classpath:config.properties")
public class DaoConfig {

    @Value("${database.url}" )
    private String url;
    @Value("${database.driver}")
    private String driverClassName;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.format_sql}")
    private String formatSql;
    @Value("${hibernate.creation_policy}")
    private String creationPolicy;

    @Bean
    public DriverManagerDataSource dataSource(){
        final DriverManagerDataSource driverManager = new DriverManagerDataSource();
        dataSource().setUrl(url);
        dataSource().setDriverClassName(driverClassName);
        dataSource().setUsername(username);
        dataSource().setPassword(password);
        return dataSource();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("by.itcollage.entity");
        sessionFactory.setHibernateProperties(getHibernateProperties());
        sessionFactory.setDataSource(dataSource);
        return sessionFactory;
    }

    private Properties getHibernateProperties(){
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.format_sql", formatSql);
        properties.setProperty("hibernate.creation_policy", creationPolicy);
        return properties;

    }

}
