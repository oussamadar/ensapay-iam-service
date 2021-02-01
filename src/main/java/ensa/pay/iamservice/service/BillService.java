package ensa.pay.iamservice.service;

import ensa.pay.iamservice.entities.Bill;
import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.repo.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    public Bill getBillById(Long id) throws NotFoundException {
        return billRepository.findById(id).orElseThrow(()->new NotFoundException("404","bill not found with id" +id));
    }

    public List<Bill> getAllBills()
    {
        return billRepository.findAll();
    }

    public Bill updateIsbatched(Long id) throws NotFoundException {
        Bill bill = billRepository.findById(id).orElseThrow(()->new NotFoundException("404","bill not found with id =" +id));
        bill.setBatched(true);
        billRepository.save(bill);
        return bill;
    }

    public Bill payBill(Long id) throws NotFoundException {
        Bill bill = billRepository.findById(id).orElseThrow(()->new NotFoundException("404","bill not found with id =" +id));
        bill.setPayed(true);
        bill.setPayedDate(new Date());
        return billRepository.save(bill);
    }


}
