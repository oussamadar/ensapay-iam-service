package ensa.pay.iamservice.controllers;

import ensa.pay.iamservice.entities.Form;
import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.repo.FormRepository;
import ensa.pay.iamservice.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("iam/gitform")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/{codeCreance}")
    public Form internetForm(@PathVariable String codeCreance) throws NotFoundException {
        return formService.getFormByCodeCreance(codeCreance);
    }



}
