package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @GetMapping("/create-customer")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView checkValidation(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("message", "Cannot create new customer!");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        return modelAndView;
    }

//    @PostMapping("/create-customer")
//    public ModelAndView saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        modelAndView.addObject("customer", new Customer());
//        if (bindingResult.hasFieldErrors()) {
//            modelAndView.addObject("message", "Cannot create new customer!");
//        } else {
////            customerService.save(customer);
//            modelAndView.addObject("message", "New customer created successfully");
//        }
//        return modelAndView;
//    }
}
