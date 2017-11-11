package database;

public final class DBQueries {
    // Queries for User, UserManager class
    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    public static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    public static final String SQL_FIND_ROLE_BY_ROLE_NAME = "SELECT * FROM roles WHERE role_name=?";
    public static final String SQL_INSERT_USER = "INSERT INTO users(full_name, email,login,password,register_date,role_id,blocked)VALUE(?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE_USER_STATE = "UPDATE users SET blocked=?"
            + "	WHERE user_id=?";
    public static final String SQL_UPDATE_USER = "UPDATE users SET full_name=?, email=?, password=?, login=?"
            + "	WHERE user_id=?";

    //Queries for CreditCard
    public static final String SQL_INSERT_CREDIT_CARD = "INSERT INTO users(bill,credit_card_number,description,month_expiration,year_expiration,cvs,blocked,balance,user_id)VALUE(?,?,?,?,?,?,?,?,?)";
    public static final String SQL_FIND_ALL_CREDIT_CARDS_BY_USER_ID = "SELECT * FROM credit_card WHERE user_id=?";
    public static final String SQL_FIND_NOT_BLOCKED_CREDIT_CARD_BY_ID = "SELECT * FROM credit_card WHERE blocked = 1 AND creditcard_id=?";
    public static final String SQL_FIND_CREDIT_CARD_BY_ID = "SELECT * FROM credit_card creditcard_id=?";
    public static final String SQL_UPDATE_CREDIT_CARD = "UPDATE credit_card SET bill=?,description=?,month_expiration=?,year_expiration=?,cvs,blocked=?,balance=?" + " WHERE creditcard_id=?";
    public static final String SQL_UPDATE_CREDIT_CARD_STATE = "UPDATE credit_card SET blocked=?";

    //Queries for UserPayments
    public static final String SQL_FIND_ALL_PAYMENTS = "SELECT * FROM user_payments";
    public static final String SQL_FIND_PAYMENTS_BY_PAYMENT_ID = "SELECT * FROM user_payments WHERE payment_id=?";
    public static final String SQL_FIND_PAYMENTS_BY_CREDITCARD_ID = "SELECT * FROM user_payments WHERE creditcard_id=?";
    public static final String SQL_FIND_PAYMENTS_BY_STATE_ID = "SELECT * FROM user_payments WHERE state_id=?";
    public static final String SQL_INSERT_PAYMENT = "INSERT INTO user_payments(description, creation_date, state_id, creditcard_id, sum, recipient_bill)VALUE(?,?,?,?,?,?)";
    public static final String SQL_UPDATE_RECIPIENT_BILL = "UPDATE users SET recipient_bill=?" + " WHERE payment_id=?";


}