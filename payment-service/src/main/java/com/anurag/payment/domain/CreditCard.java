package com.anurag.payment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditCard {

	private Long id;
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String securityCode;

}