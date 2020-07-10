package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Car;
import org.example.entity.Client;
import org.example.entity.Contract;
import org.example.service.CarService;
import org.example.service.ClientService;
import org.example.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
@RequestMapping("/contracts")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;
    private final CarService carService;
    private final ClientService clientService;

    @GetMapping()
    public String contractPage(Model model) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("contracts", contractService.findAll());
        return "contracts";
    }

    @PostMapping("/add")
    public String addContract(@RequestParam Car car,
                              @RequestParam Client client,
                              @RequestParam Date dateOfStart,
                              @RequestParam Date dateOfEnd) {
        contractService.save(car, client, dateOfStart, dateOfEnd);
        return "redirect:/contracts";
    }

    @GetMapping("/delete/{delContract}")
    public String deleteContract(@PathVariable Long delContract) {
        Contract contract = contractService.findById(delContract);
        contractService.remove(contract.getId());
        return "redirect:/contracts";
    }

    @PostMapping("/reduct/{id}")
    public String reductContract(@PathVariable Long id,
                                 @RequestParam Car car,
                                 @RequestParam Client client,
                                 @RequestParam Date dateOfStart,
                                 @RequestParam Date dateOfEnd) {
        contractService.update(id, car, client, dateOfStart, dateOfEnd);
        return "redirect:/contracts";
    }

}
