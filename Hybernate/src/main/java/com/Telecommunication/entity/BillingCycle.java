package com.Telecommunication.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity

public class BillingCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billingCycleId;

    @ManyToOne
    @JoinColumn(name = "subscriberId", nullable = false)
    private Subscriber subscriber;
    private java.util.Date billingDate;
    private Double amount;
		
	public void setBillingCycleId(Integer billingCycleId) {
		this.billingCycleId = billingCycleId;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public java.util.Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(java.util.Date date) {
		this.billingDate = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
    @Override
    public String toString() {
        return "BillingCycle{" +
                "billingCycleId=" + billingCycleId +
                ", subscriber=" + subscriber +
                ", billingDate=" + billingDate +
                ", amount=" + amount +
                '}';
    }
}