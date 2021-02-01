package ensa.pay.iamservice.controllers;

import ensa.pay.iamservice.entities.Bill;
import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/iam/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/{id}")
    public Bill findById(@PathVariable Long id) throws NotFoundException{
        return billService.getBillById(id);
    }
    @GetMapping("")
    public List<Bill> findAll() throws NotFoundException{
        return billService.getAllBills();
    }

    @GetMapping("/batch/{id}")
    public Bill updateBatchedBill(@PathVariable Long id) throws NotFoundException {
        return billService.updateIsbatched(id);
    }
    @GetMapping("/pay/{id}")
    public Bill payBill(@PathVariable Long id) throws NotFoundException {
        return billService.payBill(id);
    }
}
