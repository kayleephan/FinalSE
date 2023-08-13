package com.example.finalexam.web;

import com.example.finalexam.entities.Salesman;
import com.example.finalexam.respositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class SalesmanController {

    @Autowired
    SalesmanRepository salesmanRepository;

    @GetMapping("/index")
    public String listSales(Model model) {
        List<Salesman> salesman = salesmanRepository.findAll();
        model.addAttribute("salesman", salesman);
        return "/index";
    }

    @GetMapping("/delete")
    public String deleteSale(Long id) {
        salesmanRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/form")
    public String formSales(Model model){
        model.addAttribute("salesman", new Salesman());
        return "form";
    }

    @PostMapping("/form")
    public String showAddForm(@ModelAttribute Salesman salesman) {
        salesmanRepository.save(salesman);
        return "redirect:index";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        Salesman salesman = salesmanRepository.findById(id).orElse(null);
        if (salesman == null) {
            throw new RuntimeException("Salesman not found");
        }
        model.addAttribute("salesman", salesman);
        return "edit";
    }

    @PostMapping("/edit")
    public String editSale(@ModelAttribute Salesman editedSalesman) {
        Salesman existingSale = salesmanRepository.findById(editedSalesman.getId()).orElse(null);
        if (existingSale == null) {
            throw new RuntimeException("Sale not found");
        }

        // Update the existing sale with the edited values
        existingSale.setName(editedSalesman.getName());
        existingSale.setDot(editedSalesman.getDot());
        existingSale.setItem(editedSalesman.getItem());
        existingSale.setAmount(editedSalesman.getAmount());

        salesmanRepository.save(existingSale);
        return "redirect:index";
    }




}
