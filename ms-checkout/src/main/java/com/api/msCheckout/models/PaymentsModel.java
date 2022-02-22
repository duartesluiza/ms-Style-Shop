package com.api.msCheckout.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PAYMENTS")
public class PaymentsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private float discount;
    @Column(nullable = false)
    private boolean status;



}
