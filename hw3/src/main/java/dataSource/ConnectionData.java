package dataSource;

import java.sql.*;
import java.util.Properties;

public class ConnectionData {
    Properties properties;
    Class<?> dbDriver = Class.forName("org.postgresql.Driver");
    public ConnectionData() throws ClassNotFoundException {
        properties = new Properties();
        properties.put("user","postgres");
        properties.put("password","postgres");
        properties.put("ssl",true);
    }

    public ResultSet manyToMany() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",properties);
        Statement statement = connection.createStatement();
        return statement.executeQuery("""
                SELECT p.full_name AS ФИО, b.name AS БАНК
                FROM person p
                         LEFT JOIN person_bank pb ON pb.person_id = p.id
                         LEFT JOIN bank b ON b.id = pb.bank_id""");
    }

    public ResultSet oneToMany() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",properties);
        Statement statement = connection.createStatement();
        return statement.executeQuery("""
                SELECT d.name AS ФИО, d.profession AS Профессия, c.name AS Клиника, c.address AS Адрес
                FROM clinic c
                INNER JOIN doctors d on d.clinic_id = c.id;""");
    }
}
