package com.Bank.Account.Bank.Controller;

import com.Bank.Account.Bank.DTO.BankDTO;
import com.Bank.Account.Bank.Entity.Account;
import com.Bank.Account.Bank.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {

    @Autowired
    private BankService service;

    @ModelAttribute("account")
    public Account create() {
        return new Account();
    }

    @GetMapping({"/", "/index"})
    public String indexPage(Model model) {
        // Add any model attributes if needed
        return "index"; // Return the name of your Thymeleaf template (e.g., index.html)
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        return "register";
    }

    @PostMapping("/modify")
    public String showModify(@ModelAttribute Account account, Model model) {
        Account exist = service.getAccountById(account.getAccountId());
        System.out.println(exist + " Got it");
        model.addAttribute("account", exist);
        return "modify";
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        return "home";
    }



    @PostMapping("/add")
    public String addAccount(@ModelAttribute BankDTO dto) {
        if (service.save(dto.toAccount())) {
            return "redirect:/index?success";
        } else {
            return "redirect:/register?error";
        }
    }

    @PostMapping("/signin")
    public String login(@ModelAttribute Account account, Model model) {
        Account existingAccount = service.login(account.getUserName(), account.getPassword());
        System.out.println(existingAccount);

        if (existingAccount == null) {
            System.out.println("Not Found user not valid");
            return "redirect:/index?error";
        } else {
            model.addAttribute("account", existingAccount);
            System.out.println("Found user valid");
            return "home";
        }
    }

    @PostMapping("/modifyUser")
    public String modify(@ModelAttribute Account account) {
        service.update(account);
        return "redirect:/index";
    }

    @PostMapping("/delete")
    public String deleteAccount(@ModelAttribute("account") Account account) {
        int id = account.getAccountId();
        System.out.println(account);
        System.out.println(id);
        boolean deleteAccount = service.delete(id);
        if (deleteAccount) {
            return "redirect:/index";
        } else {
            return "redirect:/index";
        }
    }
}
