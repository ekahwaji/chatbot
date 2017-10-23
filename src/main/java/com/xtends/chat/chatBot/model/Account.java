package com.xtends.chat.chatBot.model;

import java.util.Date;

public class Account {

	private String accountNumber;
	private String title;
	private double ledgerBalance;
	private double availableBalance;
	private double availableBalanceCounter;
	private AccountType type;
	private Currency currency;
	private String group;
	private String subGroup;
	private String iban;
	private Date gracePeriod;
	private boolean collective;
	private Currency counterCurrency;

	// details
	private Date maturityDate;
	private double interestRate;
	private double monthlyPayment;
	private double cardLimit;
	private double cardLimitCounter;
	private double principalAmount;
	private double principalAmountCounter;
	private double nextPayment;
	private double nextPaymentCounter;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getLedgerBalance() {
		return ledgerBalance;
	}

	public void setLedgerBalance(double ledgerBalance) {
		this.ledgerBalance = ledgerBalance;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public double getAvailableBalanceCounter() {
		return availableBalanceCounter;
	}

	public void setAvailableBalanceCounter(double availableBalanceCounter) {
		this.availableBalanceCounter = availableBalanceCounter;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Date getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(Date gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public boolean isCollective() {
		return collective;
	}

	public void setCollective(boolean collective) {
		this.collective = collective;
	}

	public Currency getCounterCurrency() {
		return counterCurrency;
	}

	public void setCounterCurrency(Currency counterCurrency) {
		this.counterCurrency = counterCurrency;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public double getCardLimitCounter() {
		return cardLimitCounter;
	}

	public void setCardLimitCounter(double cardLimitCounter) {
		this.cardLimitCounter = cardLimitCounter;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getPrincipalAmountCounter() {
		return principalAmountCounter;
	}

	public void setPrincipalAmountCounter(double principalAmountCounter) {
		this.principalAmountCounter = principalAmountCounter;
	}

	public double getNextPayment() {
		return nextPayment;
	}

	public void setNextPayment(double nextPayment) {
		this.nextPayment = nextPayment;
	}

	public double getNextPaymentCounter() {
		return nextPaymentCounter;
	}

	public void setNextPaymentCounter(double nextPaymentCounter) {
		this.nextPaymentCounter = nextPaymentCounter;
	}

}
