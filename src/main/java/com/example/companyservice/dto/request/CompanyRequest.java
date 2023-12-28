package com.example.companyservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private String name;
    private String email;
    private String password;
    private String cpf_cnpj;
    private Double zip_code;
    private String street;
    private String district;
    private Double number;
    private String city;
}
