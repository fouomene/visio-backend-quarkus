package com.fouomene.device.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address_entity")
public class AddressEntity extends AbstractEntity {
    @Column(nullable = false)
    private String name;
    private double lat;
    private double lng;
}