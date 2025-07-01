package com.crud.card.ms_card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.card.ms_card.model.Card;
import com.crud.card.ms_card.model.ServiceResponse;
import com.crud.card.ms_card.service.ICardService;

@RestController
@RequestMapping("/api/v1/card")
@CrossOrigin("*")
public class CardController {

    @Autowired
    private ICardService iCardService;

    @GetMapping("/list")
    public ResponseEntity<List<Card>> list() {
        var result = iCardService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Card card) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.save(card);

        if (result == 1) {
            serviceResponse.setMessage("Item saved with success");
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Card card) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.update(card);

        if (result == 1) {
            serviceResponse.setMessage("Item update with success");
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.deleteByID(id);

        if (result == 1) {
            serviceResponse.setMessage("Item removed with success");
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
