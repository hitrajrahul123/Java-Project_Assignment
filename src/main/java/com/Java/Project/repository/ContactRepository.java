package com.Java.Project.repository;

import com.Java.Project.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {


    @Query("SELECT c FROM Contact c WHERE c.address.postalCode = :postalCode")
    List<Contact> findByPostalCode(@Param("postalCode") String postalCode);
}
