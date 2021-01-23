package ensa.pay.iamservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundException extends Exception {
    private String code;
    private String message;
}
