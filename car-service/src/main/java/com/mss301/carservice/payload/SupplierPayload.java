package com.mss301.carservice.payload;

import lombok.Data;

@Data
public class SupplierPayload {
    private Long supplierID;
    private String supplierName;
    private String supplierDescription;
    private String supplierAddress;
}

