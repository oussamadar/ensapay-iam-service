package ensa.pay.iamservice.service;

import ensa.pay.iamservice.entities.Client;
import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientSerivce {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClientByIdPayment(Long id) throws NotFoundException {
        return clientRepository.findById(id).orElseThrow(()->new NotFoundException("404","ce numero d'abonnemnt n'existe pas"));
    }
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }
}
