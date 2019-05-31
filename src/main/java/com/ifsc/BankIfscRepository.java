package com.ifsc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankIfscRepository extends JpaRepository<BankIfsc, Integer> {

	@Query("SELECT DISTINCT b.bankName FROM BankIfsc b")
	List<String> findDistinctBank();

	List<BankIfsc> findDistinctByBankName(String bankName);

	@Query("SELECT DISTINCT b.bankCity FROM BankIfsc b WHERE b.bankState=:bankState AND b.bankName=:bankName")
	List<String> findBybankState(@Param("bankState") String bankState, @Param("bankName") String bankName);

	@Query("SELECT b.bankBranch FROM BankIfsc b WHERE b.bankCity=:bankCity AND b.bankName=:bankName AND b.bankState=:bankState")
	List<String> findBybankCity(@Param("bankCity") String bankCity, @Param("bankName") String bankName, @Param("bankState") String bankState);

	@Query("SELECT b FROM BankIfsc b WHERE b.bankBranch=:bankBranch AND b.bankName=:bankName")
	List<BankIfsc> findBybankBranch(@Param("bankBranch") String bankBranch, @Param("bankName") String bankName);
}
