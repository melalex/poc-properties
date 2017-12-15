package com.room414.properties.repositories;

import com.room414.properties.domain.Property;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PropertiesRepository extends CrudRepository<Property, String> {

    @Modifying
    @Query("update Property p set p.value = ?2 where p.key = ?1")
    void setPropertyByKey(String key, String value);
}
