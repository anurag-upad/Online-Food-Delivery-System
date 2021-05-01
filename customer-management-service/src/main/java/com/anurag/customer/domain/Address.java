package com.anurag.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ADDRESS")
public class Address {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;
    
    @Column(length = 20)
	@NotEmpty(message = "{Min.address.street}")
 	private String street;
    
    @Column(length = 16)
	@NotEmpty(message = "{Min.address.city}")
	private String city;
    
    @Column(length = 8)
	@NotEmpty(message = "{Min.address.state}")
 	private String state;
    
    @Column(length = 6)
	@NotEmpty(message= "{Min.address.zipCode}")
    @Size(max=5, message="{Max.address.zipCode.length }")
    private String zipCode;
	
}
