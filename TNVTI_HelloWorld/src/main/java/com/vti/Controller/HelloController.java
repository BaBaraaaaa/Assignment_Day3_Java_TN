package com.vti.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="TrangChu")
@CrossOrigin("*") // => chỉ cho phép ip đc truy cập
public class HelloController {
	@GetMapping("/TrangChu")
	public String TrangChuPage()
	{
		return "hello";
	}
	
}
