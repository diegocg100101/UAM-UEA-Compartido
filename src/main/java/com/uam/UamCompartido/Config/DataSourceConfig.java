/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uam.UamCompartido.Config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author LGMX
 */

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306");
        dataSource.setUsername("root");
        dataSource.setPassword("186251");
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        return dataSource;    
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate (DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
