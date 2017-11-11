package dto;

import database.DBManager;
import exception.DBException;
import exception.Messages;
import model.User;
import org.apache.log4j.Logger;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserManager {

    private static final Logger LOG = Logger.getLogger(DBManager.class);
    public String insertInto = "INSERT INTO payments.users(full_name, email,login,password,register_date,role_id,blocked)VALUE(?,?,?,?,?,?,?)";

    public User createUser(User user) throws DBException, SQLException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(insertInto);
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getLogin());
            pstmt.setString(4, user.getPassword());
            pstmt.setDate(5, new java.sql.Date(user.getRegisterDate().getTime()));
            pstmt.setInt(6, user.getRoleId());
            pstmt.setBoolean(7, user.isBlocked());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                LOG.trace("-- User inserted -->" + user.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD
                        + user.toString());
            }
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUserId(generatedKeys.getInt(1));
            }
            con.commit();
            return user;
        } catch (SQLException ex) {
            DBManager.getInstance().rollback(con);
            LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
            throw new DBException(); //(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
        } finally {
            DBManager.getInstance().close(con);
            DBManager.getInstance().close(pstmt);
        }
    }
}
