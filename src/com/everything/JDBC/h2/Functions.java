package com.everything.JDBC.h2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by mcalancea on 2016-02-16.
 */
public class Functions{
    public static void main(String[] args) throws SQLException{
        final String DB_DIR = "~/smart_finance";
        final String DB_NAME = "finance";
        final String DB_SCHEMA = "FINANCE";
        final String DB_CONNECTION_IFEXISTS = "jdbc:h2:"+DB_DIR+"/"+DB_NAME+";IFEXISTS=TRUE;SCHEMA="+DB_SCHEMA;
        final String DB_USER = "root";
        final String DB_PASSWORD = "root";

//        System.out.println("hello");
        Connection conn = DriverManager.getConnection(DB_CONNECTION_IFEXISTS, DB_USER, DB_PASSWORD);
        createDateUnitTable(conn);
    }
    
    public static void createDateUnitTable(Connection connection) throws SQLException{
        final StringBuilder createDateUnitTable = new StringBuilder();
        createDateUnitTable.append("CREATE SEQUENCE IF NOT EXISTS SEQ_DATEUNIT;");
        createDateUnitTable.append("CREATE TABLE IF NOT EXISTS DATEUNIT(");
            createDateUnitTable.append("ID BIGINT DEFAULT SEQ_DATEUNIT.NEXTVAL,");
            createDateUnitTable.append("UNITTIMESTAMP DATE NOT NULL,");
            createDateUnitTable.append("UNITYEAR INT NOT NULL,");
            createDateUnitTable.append("UNITMONTHOFYEAR INT NOT NULL,");
            createDateUnitTable.append("UNITMONTH INT NOT NULL,");
            createDateUnitTable.append("UNITWEEKOFYEAR INT NOT NULL,");
            createDateUnitTable.append("UNITWEEK INT NOT NULL,");
            createDateUnitTable.append("UNITDATE INT NOT NULL,");
            createDateUnitTable.append("UNITDAYOFWEEK INT NOT NULL,");
            createDateUnitTable.append("WEEKDAY INT NOT NULL,");
            createDateUnitTable.append("T_CREATEDON TIMESTAMP,");
            createDateUnitTable.append("T_UPDATEDON TIMESTAMP AS NOW(),");
            createDateUnitTable.append("PRIMARY KEY(ID,UNITTIMESTAMP),");
        createDateUnitTable.append(");");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXUNITYEAR ON DATEUNIT(UNITYEAR);");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXUNITMONTHOFYEAR ON DATEUNIT(UNITMONTHOFYEAR);");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXUNITMONTH ON DATEUNIT(UNITMONTH);");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXUNITWEEKOFYEAR ON DATEUNIT(UNITWEEKOFYEAR);");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXUNITWEEK ON DATEUNIT(UNITWEEK);");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXUNITDATE ON DATEUNIT(UNITDATE);");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXUNITDAYOFWEEK ON DATEUNIT(UNITDAYOFWEEK);");
        createDateUnitTable.append("CREATE INDEX IF NOT EXISTS IDXWEEKDAY ON DATEUNIT(WEEKDAY);");
        try (Statement statement = connection.createStatement()){
            statement.execute(createDateUnitTable.toString());
        }
    }

    Long insertSelectDate(Connection conn, Date date) {
//        return new BigInteger(String.valueOf(value)).isProbablePrime(100);
        return date.getTime();
    }
}
