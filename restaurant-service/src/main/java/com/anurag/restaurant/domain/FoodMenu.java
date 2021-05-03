package com.anurag.restaurant.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FOOD_MENU")
public class FoodMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FOOD_MENU_ID")
	private Long id;
	
	@NotNull
	@Size(min = 4, max = 32, message = "{Size.foodName}")
	private String foodName;
	
	@NotNull
	@Size(min = 4, max = 32, message = "{Size.foodDescription}")
	private String foodDescription;
	
	@NotNull
	@Size(min = 4, max = 32, message = "{Size.foodCatalog}")
	private String foodCatalog;
	
	@NotNull(message = "{Size.foodPrice}")
	private BigDecimal foodPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Restaurant restaurant;

}
