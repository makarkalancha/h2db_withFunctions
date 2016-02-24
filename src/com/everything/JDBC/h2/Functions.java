package com.everything.JDBC.h2;

import java.sql.Connection;
import java.sql.Date;

/**
 * Created by mcalancea on 2016-02-16.
 */
public class Functions{
    private static final StringBuilder createDateUnitTable = new StringBuilder();
    static {
        createDateUnitTable.append("CREATE SEQUENCE SEQ_DATEUNIT;");
        createDateUnitTable.append("CREATE TABLE DATEUNIT(");
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
        createDateUnitTable.append("CREATE INDEX IDXUNITYEAR ON DATEUNIT(UNITYEAR);");
        createDateUnitTable.append("CREATE INDEX IDXUNITMONTHOFYEAR ON DATEUNIT(UNITMONTHOFYEAR);");
        createDateUnitTable.append("CREATE INDEX IDXUNITMONTH ON DATEUNIT(UNITMONTH);");
        createDateUnitTable.append("CREATE INDEX IDXUNITWEEKOFYEAR ON DATEUNIT(UNITWEEKOFYEAR);");
        createDateUnitTable.append("CREATE INDEX IDXUNITWEEK ON DATEUNIT(UNITWEEK);");
        createDateUnitTable.append("CREATE INDEX IDXUNITDATE ON DATEUNIT(UNITDATE);");
        createDateUnitTable.append("CREATE INDEX IDXUNITDAYOFWEEK ON DATEUNIT(UNITDAYOFWEEK);");
        createDateUnitTable.append("CREATE INDEX IDXWEEKDAY ON DATEUNIT(WEEKDAY);");
    }

//    public static Long insertSelectDate(Date date) {
//
//    }

    public static Long insertSelectDate(Connection conn, Date date) {
//        return new BigInteger(String.valueOf(value)).isProbablePrime(100);
        return date.getTime();
    }
}
