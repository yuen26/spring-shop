package com.yuen.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuen.domain.web.Category;
import com.yuen.service.CategoryService;

@Controller
public class AdminCategoryController {
	
	@Autowired
	private CategoryService categoryService;

    @GetMapping("/admin/category")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/category_list";
    }
    
    @GetMapping("/admin/category/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category_form";
    }
    
    @GetMapping("/admin/category/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("category", categoryService.findOne(id));
        return "admin/category_form";
    }
    
    @PostMapping("/admin/category/save")
    public String save(@Valid Category category, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "admin/category_form";
        }
        
        categoryService.save(category);
        
        redirect.addFlashAttribute("success", "Lưu danh mục thành công!");
        return "redirect:/admin/category";
    }
    
    @GetMapping("/admin/category/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        categoryService.delete(id);
        
        redirect.addFlashAttribute("success", "Xóa danh mục thành công!");
        return "redirect:/admin/category";
     }
	
}
