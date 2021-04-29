package com.anurag.order.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long id;

	@NotNull(message = "{Min.number.userName}")
	private Long userId;

	@NotNull(message = "{Min.number.restaurantId}")
	private Long restaurantId;

	@NotNull(message = "{Size.name.validation}")
	private String restaurantName;

	@Column(name = "order_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime orderTime = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus = OrderStatus.CREATED;
	@NotNull
	@Min(value = 1, message = "{Min.number.totalPrice}")
	private double totalPrice;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	@Valid()
	private List<FoodItem> foodItems;


}
