package com.yp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yp.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sale")
public class Sale  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private java.math.BigDecimal price;

	private Integer quantity;

	@Column(name = "total_price")
	@JsonProperty("totalprice")
	private java.math.BigDecimal totalPrice;

	@Column(name = "sale_date")
	@JsonProperty("saledate")
	@JsonSerialize(using = Date2LongSerializer.class)
	private java.util.Date saleDate;

	@Column(name = "user_id")
	@JsonIgnore
	private Integer userId;

	@Column(name = "product_id")
	@JsonIgnore
	private Integer productId;

	@Transient
	private String realName;

	@Transient
	private String productName;

}
