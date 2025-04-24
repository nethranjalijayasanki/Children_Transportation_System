package com.example.userbe.service.impl;

import com.example.userbe.dto.PaymentDTO;
import com.example.userbe.entity.Passenger;
import com.example.userbe.entity.Payment;
import com.example.userbe.repo.PassengerRepository;
import com.example.userbe.repo.PaymentRepository;
import com.example.userbe.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              PassengerRepository passengerRepository,
                              ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);

        // Set passenger
        Passenger passenger = passengerRepository.findById(paymentDTO.getPassengerId())
                .orElseThrow(() -> new RuntimeException("Passenger not found with id: " + paymentDTO.getPassengerId()));
        payment.setPassenger(passenger);

        Payment savedPayment = paymentRepository.save(payment);
        return modelMapper.map(savedPayment, PaymentDTO.class);
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        return modelMapper.map(payment, PaymentDTO.class);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        modelMapper.map(paymentDTO, existingPayment);

        // Update passenger if changed
        if (paymentDTO.getPassengerId() != null) {
            Passenger passenger = passengerRepository.findById(paymentDTO.getPassengerId())
                    .orElseThrow(() -> new RuntimeException("Passenger not found with id: " + paymentDTO.getPassengerId()));
            existingPayment.setPassenger(passenger);
        }

        Payment updatedPayment = paymentRepository.save(existingPayment);
        return modelMapper.map(updatedPayment, PaymentDTO.class);
    }

    @Override
    public void deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        paymentRepository.delete(payment);
    }
}
