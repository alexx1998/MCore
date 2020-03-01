package com.mordonia.mcore;

import java.sql.Connection;
import java.sql.SQLException;

public interface MySQLConnectionProvider {

    Connection openConnection() throws SQLException;
    Connection getConnection() throws SQLException;
}
