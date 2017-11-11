package database.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.manager.DBFields.DBFCreditCard;
import org.apache.log4j.Logger;

import database.DBManager;
import database.DBQueries;
import exception.DBException;
import exception.Messages;
import model.CreditCard;


public class CreditCardManager {
    private DBManager db;
    private static final Logger LOG = Logger.getLogger(CreditCardManager.class);

    public CreditCard addCreditCards(CreditCard creditCard) throws DBException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_INSERT_CREDIT_CARD);
            pstmt.setLong(1, creditCard.getBill());
            pstmt.setLong(2, creditCard.getCreditCardNumber());
            pstmt.setString(3, creditCard.getDescription());
            pstmt.setInt(4, creditCard.getMonthExpiration());
            pstmt.setInt(5, creditCard.getYearExpiration());
            pstmt.setInt(6, creditCard.getCvv());
            pstmt.setBoolean(7, creditCard.isBlocked());
            pstmt.setDouble(8, creditCard.getBalance());
            pstmt.setInt(9, creditCard.getUserId());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                LOG.trace("-- Credit card inserted -->" + creditCard.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD
                        + creditCard.toString());
            }
            con.commit();
            return creditCard;
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
            throw new DBException(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
        } finally {
            db.close(con);
            db.close(pstmt);
        }
    }

    public List<CreditCard> getCreditCardsByUserId(int userId)
            throws DBException {
        List<CreditCard> creditCards = new ArrayList<CreditCard>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con
                    .prepareStatement(DBQueries.SQL_FIND_ALL_CREDIT_CARDS_BY_USER_ID);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                creditCards.add(extractCreditCard(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return creditCards;
    }

    public List<CreditCard> getNotBlockedCreditCardsByUserId(int userId)
            throws DBException {
        List<CreditCard> creditCards = new ArrayList<CreditCard>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con
                    .prepareStatement(DBQueries.SQL_FIND_NOT_BLOCKED_CREDIT_CARD_BY_ID);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                creditCards.add(extractCreditCard(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return creditCards;
    }

    public CreditCard findCreditCardById(int creditCardId) throws DBException {
        CreditCard creditCard = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_FIND_CREDIT_CARD_BY_ID);
            pstmt.setInt(1, creditCardId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                creditCard = extractCreditCard(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_ID, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_ID,
                    ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return creditCard;
    }

    public void updateCreditCard(CreditCard creditCard) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_CREDIT_CARD);
            int k = 1;
            pstmt.setBoolean(k++, creditCard.isBlocked());
            pstmt.setDouble(k++, creditCard.getBalance());
            pstmt.setInt(k++, creditCard.getCreditCardId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_UPDATE_CREDIT_CARD, ex);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_CREDIT_CARD, ex);
        } finally {
            db.close(con, pstmt);
        }
    }

    public void updateCreditCardState(boolean creditCardState, int creditCardId)
            throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_CREDIT_CARD_STATE);
            int k = 1;
            pstmt.setBoolean(k++, creditCardState);
            pstmt.setInt(k++, creditCardId);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_UPDATE_CREDIT_CARD, ex);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_CREDIT_CARD, ex);
        } finally {
            db.close(con, pstmt);
        }
    }

    private CreditCard extractCreditCard(ResultSet rs) throws SQLException {
        CreditCard creditCard = new CreditCard();
        creditCard.setBill(rs.getLong(DBFCreditCard.BILL));
        creditCard.setCreditCardNumber(rs.getLong(DBFCreditCard.CREDIT_CARD_NUMBER));
        creditCard.setDescription(rs.getString(DBFCreditCard.DESCRIPTION));
        creditCard.setMonthExpiration(rs.getInt(DBFCreditCard.MONTH_EXPIRATION));
        creditCard.setYearExpiration(rs.getInt(DBFCreditCard.YEAR_EXPIRATION));
        creditCard.setCvv(rs.getInt(DBFCreditCard.CVS));
        creditCard.setBlocked(rs.getBoolean(DBFCreditCard.BLOCKED));
        creditCard.setBalance(rs.getDouble(DBFCreditCard.BALANCE));
        creditCard.setUserId(rs.getInt(DBFCreditCard.USER_ID));
        creditCard.setCreditCardId(rs.getInt(DBFCreditCard.CREDITCARD_ID));
        return creditCard;
    }
}
