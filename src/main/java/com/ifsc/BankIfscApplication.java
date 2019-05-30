package com.ifsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@SpringBootApplication
@ComponentScan(basePackages = "com.ifsc")
@EnableJpaRepositories(basePackages = "com.ifsc")
@EntityScan(basePackages = "com.ifsc")
@Controller
public class BankIfscApplication {

	@Autowired
	private BankIfscRepository bankIfscRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankIfscApplication.class, args);
	}

	/*
	 * @GetMapping("/") public ModelAndView home() { return new
	 * ModelAndView("ifsc"); }
	 */

	@GetMapping("/")
	public ModelAndView getAllBanks(Map<String, Object> model) {
		List<String> bankStateList = bankIfscRepository.findDistinctCity();
		ModelAndView modelAndView = new ModelAndView("ifsc");
		model.put("bankName", bankStateList);
		modelAndView.addAllObjects(model);
		return modelAndView;

	}

	@GetMapping("getStates")
	@ResponseBody
	public String getStates(HttpServletRequest request) {
		String bankName = request.getParameter("bankName");
		List<BankIfsc> states = bankIfscRepository.findDistinctByBankName(bankName);
		List<String> state = new ArrayList<String>();

		for (BankIfsc bankIfsc : states) {
			if (!state.contains(bankIfsc.getBankState())) {
				state.add(bankIfsc.getBankState());
			}
		}
		return new Gson().toJson(state);

	}

	@GetMapping("getCity")
	@ResponseBody
	public String getCity(HttpServletRequest request) {
		String bankstate = request.getParameter("bankstate");
		List<BankIfsc> cities = bankIfscRepository.findBybankState(bankstate);
		List<String> city = new ArrayList<String>();

		for (BankIfsc bankIfsc : cities) {
			if (!city.contains(bankIfsc.getBankCity())) {
				city.add(bankIfsc.getBankCity());
			}
		}
		return new Gson().toJson(city);

	}

	@GetMapping("getBranch")
	@ResponseBody
	public String getBranch(HttpServletRequest request) {
		String bankCity = request.getParameter("bankCity");
		List<BankIfsc> branches = bankIfscRepository.findBybankCity(bankCity);
		List<String> branch = new ArrayList<String>();

		for (BankIfsc bankIfsc : branches) {

			branch.add(bankIfsc.getBank_branch());

		}
		return new Gson().toJson(branch);

	}

	@GetMapping("getIfsc")
	@ResponseBody
	public String getIfsc(HttpServletRequest request) {
		String bankBranch = request.getParameter("bankBranch");
		List<BankIfsc> branches = bankIfscRepository.findBybankBranch(bankBranch);
		List<String> details = new ArrayList<String>();
		if (!branches.isEmpty()) {
			details.add(branches.get(0).getBankIfsc());
			details.add(branches.get(0).getBank_address());
		} else {
			details.add("NOT FOUND");
			details.add("NOT FOUND");
		}
		return new Gson().toJson(details);

	}

}
