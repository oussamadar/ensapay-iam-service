package ensa.pay.iamservice.service;

import ensa.pay.iamservice.entities.Bill;
import ensa.pay.iamservice.entities.Client;
import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.repo.BillRepository;
import ensa.pay.iamservice.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    ClientRepository clientRepository;

    public Bill getBillById(Long id) throws NotFoundException {
        return billRepository.findById(id).orElseThrow(()->new NotFoundException("404","bill not found with taran taran id" +id));
    }

    public List<Bill> getAllBills()
    {
        return billRepository.findAll();
    }

    public Bill updateIsbatched(Long id) throws NotFoundException {
        System.out.println("saluuuuuuuuuuuuuut");

        List <Client> clients= clientRepository.findAll();
        for (Client c:
             clients) {
            for (int i =0 ;i<c.getBills().size();i++) {
                if(c.getBills().get(i).getId().equals(id)){
                    System.out.println("l7waaa");
                    c.getBills().get(i).setBatched(true);
                    clientRepository.save(c);
                    Bill bill = billRepository.save(c.getBills().get(i));
                    return bill;

                }


            }
        }
       throw new NotFoundException("404","enable to batch");
    }

    public Bill payBill(Long id) throws NotFoundException {

        List <Client> clients= clientRepository.findAll();
        System.out.println("inside pay");
        for (Client c: clients) {
            for (int i =0 ;i<c.getBills().size();i++) {
                if(c.getBills().get(i).getId().equals(id)){
                    System.out.println("inside l7wa");
                    System.out.println(c.getBills());
                    c.getBills().get(i).setPayed(true);
                    c.getBills().get(i).setPayedDate(new Date());
                    clientRepository.save(c);
                    Bill bill =billRepository.save(c.getBills().get(i));
                    return bill;

            }
        }

    }
        throw new NotFoundException("404","enable to batch");
    }


}
