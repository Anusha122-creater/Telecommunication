package com.Telecommunication.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer callId;

    @ManyToOne
    @JoinColumn(name = "subscriberId", nullable = false)
    private Subscriber subscriber;

    private java.util.Date callDate;
    public Integer getCallId() {
		return callId;
	}

	public void setCallId(Integer callId) {
		this.callId = callId;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public java.util.Date getCallDate() {
		return callDate;
	}

	public void setCallDate(java.util.Date callDate) {
		this.callDate = callDate;
	}

	public String getCallTime() {
		return callTime;
	}

	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}

	public String getCalledParty() {
		return calledParty;
	}

	public void setCalledParty(String calledParty) {
		this.calledParty = calledParty;
	}

	public Integer getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(Integer callDuration) {
		this.callDuration = callDuration;
	}

	private String callTime;
    private String calledParty;
    private Integer callDuration;

    @Override
    public String toString() { return "Call{" + "callId=" + callId + '}'; }
}