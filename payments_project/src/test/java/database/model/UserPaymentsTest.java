package database.model;


import database.model.manager.UserPaymentManager;
import exception.DBException;
import model.UserPayment;
import org.junit.Test;


import static org.junit.Assert.assertNotEquals;

public class UserPaymentsTest {
    @Test
    public void addPaymentsTest() throws DBException {
        UserPaymentManager userPaymentManager = new UserPaymentManager();
        UserPayment userPayment = new UserPayment();
        userPayment.setDescription("descr1");
        userPayment.setCreationDate(new java.util.Date());
        userPayment.setStateId(1);
        userPayment.setCreditCardId(1);
        userPayment.setSum(150);
        userPayment.setRecipientBill(Long.parseLong("500"));
        UserPayment userPayment1 = userPaymentManager.addUserPayments(userPayment);
        assertNotEquals(userPayment1.getPaymentId(), 0);
    }
}
