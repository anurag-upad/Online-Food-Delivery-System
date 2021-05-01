package com.anurag.customer.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long id;

	@Column(length = 32)
	@NotEmpty(message= "{Min.customer.fName}")
	private String firstName;
	
	@Column(length = 32)
	@NotNull(message= "{Min.customer.lName}")
	private String lastName;
	
	@Column(length = 32)
	@Size(min=4, max=32, message = "{Size.email }")
	private String email;
	
	@Column(length = 50)
	@NotNull(message= "{Min.customer.phone}")
	@Size(min=10, max=10, message="{Size.phoneNumber }")
	private String phoneNumber;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
}

