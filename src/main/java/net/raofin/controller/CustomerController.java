package net.raofin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    @RequestMapping("/payment")
    public String showPaymentPage() {
        return "customer/Payment";
    }
}
