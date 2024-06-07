package com.tina.batch.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionRecord {

	@Id
	private Long id;
	private LocalDateTime approvalDate;
	private String status;
	private String paymentType;
	private String usageType;
	private String approvalNumber;
	private String orderNumber;
	private BigDecimal amount;
	private LocalDateTime processingDate;
	private String currencyCode;
	private String productName;
}
