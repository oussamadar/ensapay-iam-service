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
    private Long idPayment;
    private String firstName;
    private String lastName;
    private List<Bill> bills;
}
