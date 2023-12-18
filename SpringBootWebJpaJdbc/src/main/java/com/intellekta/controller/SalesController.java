package com.intellekta.controller;

import com.intellekta.jdbc.entity.SalesJdbc;
import com.intellekta.jdbc.repository.JdbcRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class SalesController {

    private String nameOfUser = "User";
    private final JdbcRepo jdbcRepo;
    public SalesController(JdbcRepo jdbcRepo) {
        this.jdbcRepo = jdbcRepo;
    }

    @GetMapping("/login")
    public String createUserForm() {
        return "login";
    }

    @PostMapping("/login")
    public String createUser(@RequestParam("name") String name) {
        if (!name.equals("User"))
            nameOfUser = name;
        System.out.println(name);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        List<SalesJdbc> sales = jdbcRepo.getRowsWithPriceMoreThen100();
        model.addAttribute("name", nameOfUser);
        model.addAttribute("sales", sales);
        return "home";
    }

    @PostMapping("/home")
    public String addDataToDb(@RequestParam("id") long id, @RequestParam("price") int price, @RequestParam("receipt_of_goods") Date receipt_of_goods, @RequestParam("sale_of_goods") Date sale_of_goods, @RequestParam("id_product") int id_product) {
        SalesJdbc data = new SalesJdbc(id, price, receipt_of_goods, sale_of_goods, id_product);
        System.out.println(data);
        jdbcRepo.addData(data);
        return "redirect:/home";
    }
}
