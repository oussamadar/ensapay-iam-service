package ensa.pay.iamservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class Client {
    @Id
    private Long id;
    //to get bills of internet-electricityBill-waterBill...
    private String idPayment;
    //to get bills of fixe phone
    private String fixeNumber;
    //to get bills of phone
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private List<Bill> bills;
}
