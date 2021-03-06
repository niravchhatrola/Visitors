package com.chhatrola.visitors.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by niv214 on 6/8/17.
 */
@Configuration
//@EnableJpaRepositories(basePackages = {"com.chhatrola.visitors.web.repository", "com.infosys.branchvisit.base.service", "com.infosys.branchvisit.base.repository"},
//        entityManagerFactoryRef = "entityManagerFactory",
//        transactionManagerRef = "transactionManager")
//@EnableTransactionManagement
@EnableSwagger2
public class JpaConfiguration {
//    @Autowired
//    private Environment environment;
//
//    @Value("${datasource.maxPoolSize:10}")
//    private int maxPoolSize;
//
//    /*
//     * Populate SpringBoot DataSourceProperties object directly from application.yml
//     * based on prefix.Thanks to .yml, Hierachical data is mapped out of the box with matching-name
//     * properties of DataSourceProperties object].
//     */
//    @Bean
//    @Primary
////    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSourceProperties dataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    /*
//     * Configure HikariCP pooled DataSource.
//     */
//    @Bean
//    public DataSource dataSource() {
//        DataSourceProperties dataSourceProperties = dataSourceProperties();
//        HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder
//                .create(dataSourceProperties.getClassLoader())
//                .driverClassName(dataSourceProperties.getDriverClassName())
//                .url(dataSourceProperties.getUrl())
//                .username(dataSourceProperties.getUsername())
//                .password(dataSourceProperties.getPassword())
//                .type(HikariDataSource.class)
//                .build();
//        dataSource.setMaximumPoolSize(maxPoolSize);
//        return dataSource;
//    }
//
//    /*
//     * Entity Manager Factory setup.
//     */
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        factoryBean.setPackagesToScan(new String[] { "com.infosys.branchvisit.web.model", "com.infosys.branchvisit.base.basemodel" });
//        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//        factoryBean.setJpaProperties(jpaProperties());
//        return factoryBean;
//    }
//
//    /*
//     * Provider specific adapter.
//     */
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        return hibernateJpaVendorAdapter;
//    }
//
//    /*
//     * Here you can specify any provider specific properties.
//     */
//    private Properties jpaProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
////        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("datasource.sampleapp.hibernate.hbm2ddl.method"));
////        properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.hibernate.show_sql"));
////        properties.put("hibernate.format_sql", environment.getRequiredProperty("spring.jpa.hibernate.format_sql"));
////        if(StringUtils.isNotEmpty(environment.getRequiredProperty("datasource.sampleapp.defaultSchema"))){
////            properties.put("hibernate.default_schema", environment.getRequiredProperty("datasource.sampleapp.defaultSchema"));
////        }
//        return properties;
//    }
//
//    @Bean
//    @Autowired
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(emf);
//        return txManager;
//    }

    /**
     * https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger
     * @return
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 .apis(RequestHandlerSelectors.basePackage("com.chhatrola.visitors.web.controller.impl"))
                .paths(regex("/*.*"))
                .build();
    }
}
