package com.amx.service.bean;

public class Ar7CreditEvaluationSalidaTO {
	
	    private double accountBalance;
	    private double amountDue;
	    private String ar7CustPymBeh;
	    private long bucketNumber;
	    private long l7AccountId;
	    private int l7DebtAge;
	    private String l7Msisdn;
	    private byte l7Nunca;
	    private String l7PaymentBehavior;
	    private short l7SubSeniority;
	    private byte l7VIP;
	    
		public Ar7CreditEvaluationSalidaTO() {
			
		}

		public double getAccountBalance() {
			return accountBalance;
		}

		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}

		public double getAmountDue() {
			return amountDue;
		}

		public void setAmountDue(double amountDue) {
			this.amountDue = amountDue;
		}

		public String getAr7CustPymBeh() {
			return ar7CustPymBeh;
		}

		public void setAr7CustPymBeh(String ar7CustPymBeh) {
			this.ar7CustPymBeh = ar7CustPymBeh;
		}

		public long getBucketNumber() {
			return bucketNumber;
		}

		public void setBucketNumber(long bucketNumber) {
			this.bucketNumber = bucketNumber;
		}

		public long getL7AccountId() {
			return l7AccountId;
		}

		public void setL7AccountId(long l7AccountId) {
			this.l7AccountId = l7AccountId;
		}

		public int getL7DebtAge() {
			return l7DebtAge;
		}

		public void setL7DebtAge(int l7DebtAge) {
			this.l7DebtAge = l7DebtAge;
		}

		public String getL7Msisdn() {
			return l7Msisdn;
		}

		public void setL7Msisdn(String l7Msisdn) {
			this.l7Msisdn = l7Msisdn;
		}

		public byte getL7Nunca() {
			return l7Nunca;
		}

		public void setL7Nunca(byte l7Nunca) {
			this.l7Nunca = l7Nunca;
		}

		public String getL7PaymentBehavior() {
			return l7PaymentBehavior;
		}

		public void setL7PaymentBehavior(String l7PaymentBehavior) {
			this.l7PaymentBehavior = l7PaymentBehavior;
		}

		public short getL7SubSeniority() {
			return l7SubSeniority;
		}

		public void setL7SubSeniority(short l7SubSeniority) {
			this.l7SubSeniority = l7SubSeniority;
		}

		public byte getL7VIP() {
			return l7VIP;
		}

		public void setL7VIP(byte l7vip) {
			l7VIP = l7vip;
		}

		@Override
		public String toString() {
			return "Ar7CreditEvaluationSalidaTO [accountBalance="
					+ accountBalance + ", amountDue=" + amountDue
					+ ", ar7CustPymBeh=" + ar7CustPymBeh + ", bucketNumber="
					+ bucketNumber + ", l7AccountId=" + l7AccountId
					+ ", l7DebtAge=" + l7DebtAge + ", l7Msisdn=" + l7Msisdn
					+ ", l7Nunca=" + l7Nunca + ", l7PaymentBehavior="
					+ l7PaymentBehavior + ", l7SubSeniority=" + l7SubSeniority
					+ ", l7VIP=" + l7VIP + "]";
		}
	    
		    

}
