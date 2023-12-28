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
@Table(name = "company", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String email;
    private String password;
    private String cpf_cnpj;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private Location location;
}
