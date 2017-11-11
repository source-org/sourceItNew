package database.model.manager;


import database.DBManager;
import database.DBQueries;
import database.model.manager.DBFields.DBFUserPayments;
import exception.DBException;
import exception.Messages;
import model.UserPayment;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserPaymentManager {
    private DBManager db;
    private static final Logger LOGGER = Logger.getLogger(UserPaymentManager.class);

    public UserPayment addUserPayments(UserPayment userPayment) throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;

        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_INSERT_PAYMENT);
            pstmt.setString(1, userPayment.getDescription());
            pstmt.setDate(2, new java.sql.Date(userPayment.getCreationDate().getTime()));
            pstmt.setInt(3, userPayment.getStateId());
            pstmt.setInt(4, userPayment.getCreditCardId());
            pstmt.setDouble(5, userPayment.getSum());
            pstmt.setString(6, String.valueOf(userPayment.getRecipientBill()));

            int result = pstmt.executeUpdate();
            if (result > 0) {
                LOGGER.trace("-- User payment inserted -->" + userPayment.toString());
            } else {
                LOGGER.error(Messages.ERR_CANNOT_ADD_PREPARED_PAYMENT
                        + userPayment.toString());
            }
            con.commit();
            return userPayment;
        } catch (SQLException ex) {
            db.rollback(con);
            LOGGER.error(Messages.ERR_CANNOT_ADD_PREPARED_PAYMENT, ex);
            throw new DBException(Messages.ERR_CANNOT_ADD_PREPARED_PAYMENT, ex);
        } finally {
            db.close(con);
            db.close(pstmt);
        }
    }
    public List<UserPayment> getUserPaymentsByPaymentId(int paymentId)
            throws DBException {

        List<UserPayment> userPayments = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con
                    .prepareStatement(DBQueries.SQL_FIND_PAYMENTS_BY_PAYMENT_ID);
            pstmt.setInt(1, paymentId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                userPayments.add(extractUserPayment(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOGGER.error(Messages.ERR_CANNOT_OBTATIN_PAYMENT_BY_ID, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTATIN_PAYMENT_BY_ID, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return userPayments;
    }
    public List<UserPayment> getUserPaymentsByStateId(int stateId)
            throws DBException {

        List<UserPayment> userPayments = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con
                    .prepareStatement(DBQueries.SQL_FIND_PAYMENTS_BY_STATE_ID);
            pstmt.setInt(1, stateId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                userPayments.add(extractUserPayment(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOGGER.error(Messages.ERR_CANNOT_OBTAIN_PAYMENT_BY_STATE_ID, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTAIN_PAYMENT_BY_STATE_ID, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return userPayments;
    }
    public List<UserPayment> getUserPaymentsByCardId(int creditcardId)
            throws DBException {

        List<UserPayment> userPayments = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con
                    .prepareStatement(DBQueries.SQL_FIND_PAYMENTS_BY_CREDITCARD_ID);
            pstmt.setInt(1, creditcardId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                userPayments.add(extractUserPayment(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOGGER.error(Messages.ERR_CANNOT_OBTAIN_PAYMENT_BY_CREDITCARD_ID, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTAIN_PAYMENT_BY_CREDITCARD_ID, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return userPayments;
    }
    public List<UserPayment> getAllPayments() throws DBException {

        List<UserPayment> userPayments = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(DBQueries.SQL_FIND_ALL_PAYMENTS);
            while (rs.next()){
                userPayments.add(extractUserPayment(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOGGER.error(Messages.ERR_CANNOT_OBTAIN_PAYMENTS, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTAIN_PAYMENTS, ex);
        } finally {
            db.close(con, stmt, rs);
        }
        return userPayments;
    }
    public void updateRecipientBill(String recipientBill, int paymentId) throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_RECIPIENT_BILL);
            int counter = 1;
            pstmt.setString(counter++, recipientBill);
            pstmt.setInt(counter++, paymentId);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOGGER.error(Messages.ERR_CANNOT_UPDATE_RECIPIENT_BILL, ex);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_RECIPIENT_BILL, ex);
        } finally {
            db.close(con, pstmt);
        }
    }
    private UserPayment extractUserPayment(ResultSet rs) throws SQLException {
        UserPayment userPayment = new UserPayment();
        userPayment.setDescription(rs.getString(DBFUserPayments.DESCRIPTION));
        userPayment.setCreationDate(rs.getDate(DBFUserPayments.CREATION_DATE));
        userPayment.setStateId(rs.getInt(DBFUserPayments.STATE_ID));
        userPayment.setCreditCardId(rs.getInt(DBFUserPayments.CREDITCARD_ID));
        userPayment.setSum(rs.getDouble(DBFUserPayments.SUM));
        userPayment.setRecipientBill(Long.parseLong(rs.getString(DBFUserPayments.RECIPIENT_BILL)));
        return userPayment;
    }
}
