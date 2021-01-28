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

    //client with bills of internet subscription
    public Client getClientByIdPayment(String idPayment) throws NotFoundException {
        Client client = clientRepository.getClientByIdPayment(idPayment );
        if(client==null){
            throw new NotFoundException("404","ce code d'abonnement  n'existe pas");
        }else {
            return client;
        }

    }

    //client with pills of phone subscription
    public Client getClientByPhoneNumber(String phoneNumber) throws NotFoundException {
        Client client = clientRepository.getClientByPhoneNumber(phoneNumber);
        if (client==null){
            throw  new NotFoundException("404","ce numero d'abonnement de telephone n'existe pas");
        }
        return client;
    }

    //client with bills of fixe subscription
    public Client getClientByFixeNumber(String fixeNumber) throws NotFoundException {
        Client client = clientRepository.getClientByFixeNumber(fixeNumber);
        if (client==null){
            throw  new NotFoundException("404","ce numero d'abonnement de fixe n'existe pas");
        }
        return client;
    }
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }
}
