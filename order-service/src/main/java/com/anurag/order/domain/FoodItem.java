package com.anurag.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FOOD_ITEM")
public class FoodItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FOOD_ITEM_ID")
	private Long id;

	@NotNull( message = "{Min.number.FOODMENU_ID}")
	@Column(name = "FOOD_MENU_ID")
	private Long foodMenuId;

	@NotNull
	@Size(min = 4, max = 32, message = "{Size.name.validation.foodName}")
	private String foodName;

	@NotNull( message = "{Min.number.foodPrice}")
	private BigDecimal foodPrice;

	@NotNull
	@Min(value = 1, message = "{Min.number.quantity}")
	private int quantity;

}
