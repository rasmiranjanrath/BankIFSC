package com.ifsc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankIfscRepository extends JpaRepository<BankIfsc, Integer> {

	 @Query("SELECT DISTINCT b.bankName FROM BankIfsc b")
	  List<String> findDistinctCity();
	 
	
	 List<BankIfsc> findDistinctByBankName(String bankName);
	 List<BankIfsc> findBybankState(String bankState);
	 List<BankIfsc> findBybankCity(String bankCity);
	 List<BankIfsc> findBybankBranch(String bankBranch);
}
