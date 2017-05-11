package com.yuen.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuen.domain.web.User;
import com.yuen.service.OrderService;
import com.yuen.service.UserService;

@Controller
public class AdminCustomerController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/admin/customer")
	public String index(Model model) {
		model.addAttribute("customers", userService.findAll());
		return "admin/customer_list";
	}
	
	@GetMapping("/admin/customer/{id}/orders")
	public String showOrders(@PathVariable("id") Integer id, Model model) {
		User customer = userService.findOne(id);
		
		model.addAttribute("customer", customer);
		model.addAttribute("orders", orderService.findByUser(customer));
		return "admin/customer_orders";
	}
	
	@GetMapping("/admin/customer/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirect) {
		userService.delete(id);
		
		redirect.addFlashAttribute("success", "Xóa khách hàng thành công!");
		return "redirect:/admin/customer";
	}
	
}
