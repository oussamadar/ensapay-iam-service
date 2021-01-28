package ensa.pay.iamservice.service;

import ensa.pay.iamservice.entities.Form;
import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.repo.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    public Form getFormByCodeCreance(String codeCreance) throws NotFoundException {
        Form form = formRepository.getFormByCodeCreance(codeCreance);
        if (form == null) {
            throw new NotFoundException("404", "code Creance invalide");
        } else {
            return form;
        }
    }

}
