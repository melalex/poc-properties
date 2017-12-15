package com.room414.properties.domain;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "property")
public class Property {

    @Id
    private String key;
    private String value;
}
