package com.example.companyservice.service;

import com.example.companyservice.dto.request.CompanyRequest;
import com.example.companyservice.model.Address;
import com.example.companyservice.model.Company;
import com.example.companyservice.model.Location;
import com.example.companyservice.repository.AddressRepository;
import com.example.companyservice.repository.CompanyRepository;
import com.example.companyservice.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final LocationRepository locationRepository;
    private final AddressRepository addressRepository;

    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity<String> createCompany(CompanyRequest companyRequest) {
        if (companyRepository.findByEmail(companyRequest.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        Company company = Company.builder()
                .name(companyRequest.getName())
                .email(companyRequest.getEmail())
                .password(encoder.encode(companyRequest.getPassword()))
                .cpf_cnpj(companyRequest.getCpf_cnpj())
                .build();

        companyRepository.save(company);

        Location location = Location.builder()
                .company(company)
                .build();

        locationRepository.save(location);

        Address address = Address.builder()
                .zip_code(companyRequest.getZip_code())
                .street(companyRequest.getStreet())
                .district(companyRequest.getDistrict())
                .number(companyRequest.getNumber())
                .city(companyRequest.getCity())
                .location(location)
                .build();

        addressRepository.save(address);

        return ResponseEntity.ok().body("Company created successfully");
    }

}
