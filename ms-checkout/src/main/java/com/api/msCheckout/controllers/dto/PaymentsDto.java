package com.api.msCheckout.controllers.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class PaymentsDto {

    @NotBlank
    private String type;
    @NotBlank
    private float discount;
    private boolean status;
}
