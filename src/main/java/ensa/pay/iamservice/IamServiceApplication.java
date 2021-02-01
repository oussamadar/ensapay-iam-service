package ensa.pay.iamservice;

import ensa.pay.iamservice.entities.Bill;
import ensa.pay.iamservice.entities.Client;
import ensa.pay.iamservice.entities.Form;
import ensa.pay.iamservice.repo.BillRepository;
import ensa.pay.iamservice.repo.ClientRepository;
import ensa.pay.iamservice.repo.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class IamServiceApplication implements CommandLineRunner {
    @Autowired ClientRepository clientRepository;
    @Autowired BillRepository billRepository;
    @Autowired
    FormRepository formRepository;
    public static void main(String[] args) {
        SpringApplication.run(IamServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Bill internetBill1=new Bill(1526543L, 250.0,new Date(),null,false,false,"iam1001");
        Bill internetBill2=new Bill(1526543L, 429.0,new Date(),null,true,false,"iam1001");

        Bill phoneBill1=new Bill(1526543L, 250.0,new Date(),null,false,false,"iam1002");
        Bill phoneBill2=new Bill(1526543L, 429.0,new Date(),null,false,false,"iam1002");

        Bill fixeBill1=new Bill(1526543L, 250.0,new Date(),null,false,false,"iam1003");
        Bill fixeBill2=new Bill(1526543L, 429.0,new Date(),null,false,false,"iam1003");

        Stream.of(internetBill1,internetBill2,phoneBill1,phoneBill2,fixeBill1,fixeBill2).forEach(
                c->{
                    billRepository.save(c);
                });


        List<Bill> internetBills = new ArrayList<>();
        internetBills.add(internetBill1);
        internetBills.add(internetBill2);

        List<Bill> phoneBills = new ArrayList<>();
        phoneBills.add(phoneBill1);
        phoneBills.add(phoneBill2);

        List<Bill> fixeBills = new ArrayList<>();
        fixeBills.add(fixeBill1);
        fixeBills.add(fixeBill2);

        Client internetClient = clientRepository.save(new Client(1111L,"i223344",null,null,"oussama","dariaoui",internetBills));
        Client phoneClient = clientRepository.save(new Client(2222L,null,null,"0641927210","larbi","dariaoui",phoneBills));
        Client fixeClient = clientRepository.save(new Client(3333L,null,"0524361210",null,"larbi","dariaoui",fixeBills));

        Form internetForm = formRepository.save(new Form(1L,"id de payement","iam1001"));
        Form phoneForm = formRepository.save(new Form(2L,"numero de telephone","iam1002"));
        Form fixeForm = formRepository.save(new Form(3L,"numero de fixe","iam1003"));
    }
}
