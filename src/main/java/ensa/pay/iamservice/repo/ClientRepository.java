package ensa.pay.iamservice.repo;

import ensa.pay.iamservice.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,Long> {
}
