package com.everything.JDBC.h2;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.h2.api.Trigger;

/**
 * Created by mcalancea on 2016-02-16.
 */
public class TriggerInvoiceSum implements Trigger{

    @Override
    public void close() throws SQLException {

    }

    @Override
    public void init(Connection connection, String s, String s1, String s2, boolean b, int i) throws SQLException {

    }

    @Override
    public void fire(Connection connection, Object[] oldRow, Object[] newRow) throws SQLException {
        BigDecimal diff = null;
        Long transactionId = null;

        if(newRow != null) {
            diff = (BigDecimal) newRow[4];
            transactionId = (Long) newRow[3];
        }

        if(oldRow != null) {
            BigDecimal m = (BigDecimal) oldRow[4];
            diff = (diff == null) ? m.negate() : diff.subtract(m);
            transactionId = (Long) oldRow[3];
        }

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE FINANCE.INVOICE SET BALANCE = BALANCE + ? WHERE ID = ?"
        );
        preparedStatement.setBigDecimal(1,diff);
        preparedStatement.setLong(2, transactionId);
        preparedStatement.executeUpdate();

    }

    @Override
    public void remove() throws SQLException {

    }
}
