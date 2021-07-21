package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
@RefreshScope
public class ConfigController {

    private final DataSource dataSource;

    @Value("${config.info}")
    private String configInfo;

    @Value("${db.name}")
    private String dbName;

    @Value("${refresh.interval}")
    private Long refreshInterval;

    private final DiscoveryClient discoveryClient;

    public ConfigController(DataSource dataSource, DiscoveryClient discoveryClient) {
        this.dataSource = dataSource;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/showConfig")
    public String showConfig() {

        for (String service : discoveryClient.getServices()) {
            System.out.println("====> " + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("---> " + instance.getUri() + "/" + instance.getHost() + instance.getPort());
            }
        }
        return "config-info: " + configInfo + "<p>db: " + dbName + "<p>refresh: " + refreshInterval;

    }

    @GetMapping("/testdb")
    public String testDB() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM config_info");

        StringBuilder sb = new StringBuilder();

        while (rs.next()) {
            sb.append(rs.getString("data_id")).append("<p>");
        }

        return sb.toString();
    }

}
