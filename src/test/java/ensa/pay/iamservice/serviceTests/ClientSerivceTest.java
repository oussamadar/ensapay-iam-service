package ensa.pay.iamservice.serviceTests;

import ensa.pay.iamservice.entities.Bill;
import ensa.pay.iamservice.entities.Client;
import ensa.pay.iamservice.exceptions.NotFoundException;
import ensa.pay.iamservice.repo.ClientRepository;
import ensa.pay.iamservice.service.ClientSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientSerivceTest {

    @Autowired
    private ClientSerivce clientSerivce;
    @MockBean
    private ClientRepository clientRepository;

//    @Test
//    void getClientByIdPaymentTest() throws NotFoundException {
//        Bill bill1=new Bill(1526543L, 250.0,new Date(),null,false,"iam1001");
//        Bill bill2=new Bill(1526543L, 250.0,new Date(),null,false,"iam1001");
//
//        //Client expectedClient = new Client(22754L, "oussama", "dariaoui", new ArrayList<Bill>(){{add(bill1);add(bill2);}});
//        Long id =22754L;
//        when(clientRepository.findById(id)).thenReturn(java.util.Optional.of(expectedClient));
//        assertThat(clientSerivce.getClientByIdPayment(22754L)).isEqualTo(expectedClient);
//    }
    @Test
    public void NotFoundExceptionThrown_thenAssertionSucceds() throws NotFoundException {
        Exception exception = assertThrows(NotFoundException.class, ()->clientSerivce.getClientByIdPayment("22755L"));

        String expectedMessage = "ce numero d'abonnemnt n'existe pas";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}