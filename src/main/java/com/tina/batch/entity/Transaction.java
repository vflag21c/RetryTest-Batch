package com.tina.batch.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer sequence;
	private LocalDateTime approvalDate;
	private String status;
	private String paymentType;
	private String usageType;
	private String approvalNumber;
	private String orderNumber;
	private Integer amount;
	private LocalDateTime processDate;
	private String currencyCode;
	private String productName;
}
