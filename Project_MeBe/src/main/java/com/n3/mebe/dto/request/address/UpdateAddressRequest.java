package com.n3.mebe.dto.request.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {


    private boolean isDefault;
    private String title;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
    private String postalCode;
}
