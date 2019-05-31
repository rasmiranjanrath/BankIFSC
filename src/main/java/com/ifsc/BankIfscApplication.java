package com.ifsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


	@GetMapping("/")
	public ModelAndView getAllBanks(Map<String, Object> model) {
		List<String> bankStateList = bankIfscRepository.findDistinctBank();
		ModelAndView modelAndView = new ModelAndView("ifsc");
		Collections.sort(bankStateList);
		model.put("bankName", bankStateList);
		modelAndView.addAllObjects(model);
		return modelAndView;

	}

	@GetMapping("getStates")
	@ResponseBody
	public String getStates(HttpServletRequest request, HttpSession session) {
		String bankName = request.getParameter("bankName");
		session.setAttribute("bankName", bankName);
		List<BankIfsc> states = bankIfscRepository.findDistinctByBankName(bankName);
		List<String> state = new ArrayList<String>();
		
		for (BankIfsc bankIfsc : states) {
			if (!state.contains(bankIfsc.getBankState())) {
				state.add(bankIfsc.getBankState());
			}
		}
		Collections.sort(state);
		return new Gson().toJson(state);

	}

	@GetMapping("getCity")
	@ResponseBody
	public String getCity(HttpServletRequest request, HttpSession session) {
		String bankstate = request.getParameter("bankstate");
		String bankName = (String) session.getAttribute("bankName");
		session.setAttribute("bankstate", bankstate);
		List<String> cities = bankIfscRepository.findBybankState(bankstate, bankName);
		Collections.sort(cities);
		return new Gson().toJson(cities);

	}

	@GetMapping("getBranch")
	@ResponseBody
	public String getBranch(HttpServletRequest request, HttpSession session) {
		String bankCity = request.getParameter("bankCity");
		String bankName = (String) session.getAttribute("bankName");
		String bankstate = (String) session.getAttribute("bankstate");
		List<String> branches = bankIfscRepository.findBybankCity(bankCity, bankName,bankstate);
		Collections.sort(branches);
		return new Gson().toJson(branches);

	}

	@GetMapping("getIfsc")
	@ResponseBody
	public String getIfsc(HttpServletRequest request, HttpSession session) {
		String bankBranch = request.getParameter("bankBranch");
		String bankName = (String) session.getAttribute("bankName");
		List<BankIfsc> branches = bankIfscRepository.findBybankBranch(bankBranch, bankName);
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
