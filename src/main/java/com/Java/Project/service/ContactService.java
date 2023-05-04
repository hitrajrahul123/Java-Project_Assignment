package com.Java.Project.service;

import com.Java.Project.entities.Contact;
import com.Java.Project.payload.ContactDto;

import java.util.List;

public interface ContactService {


    ContactDto createContact(ContactDto contactDto);

    List<ContactDto> getAllContacts();

    List<Contact> getAllContactsByZipcode(String postalCode);
}
