package ensa.pay.iamservice.repo;

import ensa.pay.iamservice.entities.Bill;
import ensa.pay.iamservice.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository extends MongoRepository<Bill,Long> {

}
