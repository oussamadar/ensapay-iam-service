package ensa.pay.iamservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bills")
public class Bill {
    @Id
    private Long id;
    private Date billingDate;
    private double amount;
}
