package com.Java.Project.controller;

import com.Java.Project.entities.Contact;
import com.Java.Project.payload.ContactDto;
import com.Java.Project.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/contacts")
public class ContactController {


    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto) {
        ContactDto createdContactDto = contactService.createContact(contactDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContactDto);
    }

    @GetMapping
    public List<ContactDto> getAllData() {
        List<ContactDto> leads = contactService.getAllContacts();
        return leads;
    }

	    @GetMapping("/{postalCode}")
		public ResponseEntity<List<Contact>> getDataByZipcode(@PathVariable("postalCode") String postalCode) {
			List<Contact> contact = contactService.getAllContactsByZipcode(postalCode);
			return new ResponseEntity<>(contact,HttpStatus.OK);
		}


}


