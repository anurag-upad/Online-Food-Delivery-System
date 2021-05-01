package com.anurag.customer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "credit_card_id")
	private Long id;
	
	@Size(max=5, message="{Max.cardNumber.zipCode.length }")
    private String cardNumber;
	
	@NotEmpty(message= "{Min.card.expiryMonth}")
    private String expiryMonth;
	
	@NotEmpty(message= "{Min.card.expiryYear}")
    private String expiryYear;
	
	@NotEmpty(message= "{Min.card.expiryCode}")
    private String securityCode;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Customer cardHolder;

}
