package ensa.pay.iamservice;

import ensa.pay.iamservice.entities.Bill;
import ensa.pay.iamservice.entities.Client;
import ensa.pay.iamservice.repo.BillRepository;
import ensa.pay.iamservice.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

import java.util.*;

@SpringBootApplication
public class IamServiceApplication implements CommandLineRunner {
    @Autowired ClientRepository clientRepository;
    @Autowired BillRepository billRepository;
    public static void main(String[] args) {
        SpringApplication.run(IamServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Bill bill1=new Bill(1526543L, new Date(),486.20);
        Bill bill2= new Bill(123321L,new Date(),249.00);
        billRepository.save(bill1);
        billRepository.save(bill2);

        Client c = clientRepository.save(new Client(22754L, "oussama", "dariaoui", new ArrayList<Bill>(){{add(bill1);add(bill2);}}));
    }
}
