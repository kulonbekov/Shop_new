package com.company.db;

import java.sql.PreparedStatement;

public interface DBGetConnection {
     PreparedStatement getConnection(String sql);
}
