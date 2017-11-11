package model;

import java.util.Date;

public class UnblockRequest {
	private int unblockRequestId;
	private Date creationDate;
	private Date unblockedDate;
	private int creditCardId;
	private boolean unblock;
	private int adminId;

	public int getUnblockRequestId() {
		return unblockRequestId;
	}

	public void setUnblockRequestId(int unblockRequestId) {
		this.unblockRequestId = unblockRequestId;
	}

	public Date getCreationDate() {
		return (Date)creationDate.clone();
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate =  (Date)creationDate.clone();
	}

	public Date getUnblockedDate() {
		return new Date(unblockedDate.getTime());
	}

	public void setUnblockedDate(Date unblockedDate) {
		this.unblockedDate = (Date)unblockedDate.clone();
	}

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}

	public boolean isUnblock() {
		return unblock;
	}

	public void setUnblock(boolean unblock) {
		this.unblock = unblock;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "UnblockRequest [unblockRequestId=" + unblockRequestId
				+ ", creationDate=" + creationDate + ", unblockedDate="
				+ unblockedDate + ", creditCardId=" + creditCardId
				+ ", unblock=" + unblock + ", adminId=" + adminId + "]";
	}

}
