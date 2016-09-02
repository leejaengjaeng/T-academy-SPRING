package com.example.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jdbc.service.*;
import com.example.jdbc.*;

@Controller
public class EmpController {

	@Autowired
	@Qualifier("empService")
	private EmpService service;
	
	@RequestMapping("/emps")
	public String getEmp(Model model)
	{
		List<EmpVo> emps = service.selectByLimit(0, service.count());
		
		return "emp_list";
		
		
	}
}
