package com.luanhroliveira.hrpayroll.services;

import com.luanhroliveira.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){

        return new Payment("Bbo", 200.0, days);

    }

}
