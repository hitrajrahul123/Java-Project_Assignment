package com.Java.Project.service.imlp;

import com.Java.Project.entities.Address;
import com.Java.Project.entities.Contact;
import com.Java.Project.payload.ContactDto;
import com.Java.Project.repository.ContactRepository;
import com.Java.Project.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactDto createContact(ContactDto contactDto) {
        Contact contact = mapToContact(contactDto);
        contact = contactRepository.save(contact);
        return mapToContactDTO(contact);
    }


    private ContactDto mapToContactDTO(Contact contact) {
        ContactDto contactDTO = new ContactDto();
        contactDTO.setId(contact.getId());
        contactDTO.setFullName(contact.getFullName());
        contactDTO.setDateOfBirth(contact.getDateOfBirth());
        contactDTO.setCity(contact.getAddress().getCity());
        contactDTO.setPostalCode(contact.getAddress().getPostalCode());
        return contactDTO;
    }

    private Contact mapToContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setFullName(contactDto.getFullName());
        contact.setDateOfBirth(contactDto.getDateOfBirth());

        Address address = new Address();
        address.setCity(contactDto.getCity());
        address.setPostalCode(contactDto.getPostalCode());
        contact.setAddress(address);

        return contact;


    }

    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactDto> contactDTOs = new ArrayList<>();

        for (Contact contact : contacts) {
            contactDTOs.add(mapToContactDTO(contact));
        }

        return contactDTOs;
    }

    public List<Contact> getAllContactsByZipcode(String postalCode) {

        List<Contact> contact1 = contactRepository.findByPostalCode(postalCode);

        return contact1;
    }


}

