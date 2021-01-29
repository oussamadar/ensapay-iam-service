package ensa.pay.iamservice.controllers;

import ensa.pay.iamservice.entities.Client;

import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.repo.ClientRepository;
import ensa.pay.iamservice.service.ClientSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("iam/")
public class ClientController {
    @Autowired
    ClientSerivce clientSerivce;

    @GetMapping("payment/{genericId}/{codeCreance}")
    public  Client getClientWithBills(@PathVariable String genericId ,@PathVariable String codeCreance ) throws NotFoundException {
        return clientSerivce.getClientwithIdpaymentAndCodeCreance(genericId,codeCreance);
    }
}
