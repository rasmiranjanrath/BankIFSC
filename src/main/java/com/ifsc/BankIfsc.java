package com.ifsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_details")
public class BankIfsc {
	@Id
	@Column(name = "bank_id")
	private Integer bankId;
	//change code
	private Integer bankId2;
	private Integer bankId3;
	private Integer bankId54;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "bank_ifsc")
	private String bankIfsc;
	@Column(name = "bankBranch")
	private String bankBranch;
	@Column(name = "bankAddress")
	private String bank_address;
	@Column(name = "bank_city")
	private String bankCity;
	@Column(name = "bank_district")
	private String bankDistrict;
	@Column(name = "bank_state")
	private String bankState;
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankIfsc() {
		return bankIfsc;
	}
	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}
	public String getbankBranch() {
		return bankBranch;
	}
	public void setbankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBank_address() {
		return bank_address;
	}
	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getBankDistrict() {
		return bankDistrict;
	}
	public void setBankDistrict(String bankDistrict) {
		this.bankDistrict = bankDistrict;
	}
	public String getBankState() {
		return bankState;
	}
	public void setBankState(String bankState) {
		this.bankState = bankState;
	}
	@Override
	public String toString() {
		return "BankIfsc [bankId=" + bankId + ", bankName=" + bankName + ", bankIfsc=" + bankIfsc + ", bankBranch="
				+ bankBranch + ", bank_address=" + bank_address + ", bankCity=" + bankCity + ", bankDistrict="
				+ bankDistrict + ", bankState=" + bankState + "]";
	}

}
