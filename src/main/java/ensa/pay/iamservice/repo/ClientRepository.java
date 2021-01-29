package ensa.pay.iamservice.repo;

import ensa.pay.iamservice.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ClientRepository extends MongoRepository<Client,Long> {

    public Client getClientByIdPayment(String idPayment);

    public Client getClientByPhoneNumber(String phoneNumber);

    public Client getClientByFixeNumber(String fixeNumber);


}
