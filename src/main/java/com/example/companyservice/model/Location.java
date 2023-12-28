package com.example.companyservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "company_id", unique = true)
    private Company company;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
