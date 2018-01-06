/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nexobyte.ffa.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import me.nexobyte.ffa.FFA;

/**
 *
 * @author Nexo
 */
public class SQLManager {
 
    private final FFA plugin;
    
    private ExecutorService executors;
    
    public Connection connection;
    
    public SQLManager(FFA plugin) {
        this.plugin = plugin;
        this.executors = Executors.newCachedThreadPool();
    }
    
    
    
    public void openConnection(String hostName, String db, String userName, String password, int port) {
        try {
        connection = DriverManager.getConnection("jdbc:mysql://" + hostName + ":" + port + "/" + db + "?autoReconnect=true", userName, password);
        } catch(SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void closeConnection() {
        executors.shutdown();
        try {
            this.connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void runAsync(Runnable runnable) {
        this.executors.execute(runnable);
    }
    
        public void update(String query) {
        this.runAsync(() -> {
            try {
                this.connection.prepareStatement(query).executeUpdate();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void query(String query, Consumer<ResultSet> consumer) {
        this.runAsync(() -> {
            try {
                ResultSet resultSet = this.connection.prepareStatement(query).executeQuery();
                consumer.accept(resultSet);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
