package ensa.pay.iamservice.repo;

import ensa.pay.iamservice.entities.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormRepository extends MongoRepository<Form,Long> {
    public Form getFormByCodeCreance(String codeCreance);
}
