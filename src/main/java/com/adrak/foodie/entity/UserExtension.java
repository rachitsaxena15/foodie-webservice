package com.adrak.foodie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.adrak.foodie.resources.PhoneVerified;
import com.adrak.foodie.resources.TncAccepted;

@Entity
@Table(name = "USEREXTENSION")
public class UserExtension {

	@Id
	@Column(name = "UserId")
	long userId;
	
	@Column(name = "PhoneVerified")
	PhoneVerified phoneVerified;
	
	@Column(name = "TnCAccepted")
	TncAccepted tncAccepted;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public PhoneVerified getPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(PhoneVerified phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public TncAccepted getTncAccepted() {
		return tncAccepted;
	}

	public void setTncAccepted(TncAccepted tncAccepted) {
		this.tncAccepted = tncAccepted;
	}

	@Override
	public String toString() {
		return "UserExtension [userId=" + userId + ", phoneVerified=" + phoneVerified + ", tncAccepted=" + tncAccepted
				+ "]";
	}
}
