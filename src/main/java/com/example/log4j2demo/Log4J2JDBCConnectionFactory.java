package com.example.log4j2demo;


import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class Log4J2JDBCConnectionFactory {
    private  HikariDataSource dataSource ;
    private HikariConfig config ;
    private static interface Singleton {
        final Log4J2JDBCConnectionFactory INSTANCE = new Log4J2JDBCConnectionFactory();
    }

    private  Log4J2JDBCConnectionFactory()   {
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:file:~/Downloads/h2db/log4j");
        config.setDriverClassName("org.h2.Driver");
        config.setUsername("sa");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}