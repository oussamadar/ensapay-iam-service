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

    @GetMapping("internet/facture/{idPayment}")
    public Client billOfInternet(@PathVariable String idPayment) throws NotFoundException {
        return clientSerivce.getClientByIdPayment(idPayment);
    }

    @GetMapping("/fixe/facture/{fixeNumber}")
    public Client billOfFixe(@PathVariable String fixeNumber) throws NotFoundException {
        return clientSerivce.getClientByFixeNumber(fixeNumber);
    }

    @GetMapping("/phone/facture/{phoneNumber}")
    public Client billOfPhone(@PathVariable String phoneNumber) throws NotFoundException {
        return clientSerivce.getClientByPhoneNumber(phoneNumber);
    }

    @GetMapping("all")
    public List<Client> getClients () {
        return clientSerivce.getAllClient();
    }


}
