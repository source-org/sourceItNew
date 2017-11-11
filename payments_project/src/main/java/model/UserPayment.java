package model;

import java.util.Date;

public class UserPayment {

    private int paymentId;
    private Date confirmationDate;
    private Date creationDate;
    private int stateId;
    private int creditCardId;
    private double sum;
    private String description;
    private long recipientBill;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getConfirmationDate() {
        return (Date) confirmationDate.clone();
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = (Date) confirmationDate.clone();
    }

    public Date getCreationDate() {
        return (Date) creationDate.clone();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = (Date) creationDate.clone();
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRecipientBill() {
        return recipientBill;
    }

    public void setRecipientBill(long recipientBill) {
        this.recipientBill = recipientBill;
    }

    @Override
    public String toString() {
        return "UserPayment [paymentId=" + paymentId + ", confirmationDate="
                + confirmationDate + ", creationDate=" + creationDate
                + ", stateId=" + stateId + ", creditCardId=" + creditCardId
                + ", sum=" + sum + ", description=" + description + "]";
    }

}
