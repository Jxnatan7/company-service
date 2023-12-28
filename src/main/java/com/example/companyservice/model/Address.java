package com.example.companyservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double zip_code;
    private String street;
    private String district;
    private Double number;
    private String city;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
