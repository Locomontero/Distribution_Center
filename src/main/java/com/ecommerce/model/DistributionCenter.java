package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class DistributionCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "distributionCenter")
    private List<Order> orders;

    public DistributionCenter(){

    }

    public DistributionCenter(Long id) {
        this.id = id;
    }
}
