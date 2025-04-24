package com.example.userbe.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaymentDTO {
    private Long id;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;
    private Long passengerId;

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }
}
