package com.example.demo.config;

import com.example.demo.service.DatabaseConnectionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements CommandLineRunner {

    @Autowired
    private DatabaseConnectionTestService databaseConnectionTestService;

    @Override
    public void run(String... args) throws Exception {
        boolean isConnected = databaseConnectionTestService.testConnection();
        if (isConnected) {
            System.out.println("数据库连接成功!");
            databaseConnectionTestService.printTables(); // 调用打印表的方法
        } else {
            System.out.println("数据库连接失败!");
        }
    }
}
