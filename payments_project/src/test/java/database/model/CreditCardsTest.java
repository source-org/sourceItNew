package database.model;


import database.model.manager.CreditCardManager;
import exception.DBException;
import model.CreditCard;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotEquals;

public class CreditCardsTest {
    @Test
    public void addCreditCardTest() throws DBException {
        CreditCardManager creditCardManager = new CreditCardManager();
        CreditCard creditCard = new CreditCard();
        creditCard.setBill(25000);
        creditCard.setCreditCardNumber(1111222234);
        creditCard.setDescription("cardDescr");
        creditCard.setMonthExpiration(new Date().getMonth());
        creditCard.setYearExpiration(2017);
        creditCard.setCvv(404);
        creditCard.setBlocked(false);
        creditCard.setBalance(22550.9);
        creditCard.setUserId(2);
        CreditCard creditCard1 = creditCardManager.addCreditCards(creditCard);
        assertNotEquals(creditCard1.getUserId(), 0);
    }
}
