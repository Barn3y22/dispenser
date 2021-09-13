package com.example.Dispenser.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.Dispenser.exception.DenomNotFoundException;
import com.example.Dispenser.model.Denoms;
import com.example.Dispenser.repository.DispenserRepository;
import com.example.Dispenser.service.DispenserService;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.awt.PageAttributes.MediaType;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class DispenserController {

    @Autowired
    DispenserRepository dispenserRepository;
    
    @Autowired
    private DispenserService dispenserService;
    
    @PostMapping("/denoms")
    public Denoms createDenoms(@Valid @RequestBody Denoms denoms) {
    	return dispenserService.calculate(denoms);
    }
    
    @GetMapping("/denoms")
    public List<Denoms> getAllDenoms() {
        return dispenserService.getAllDenoms();
    }
    
    @GetMapping("/denoms/{id}")
    public Denoms getDenomById(@PathVariable(value = "id") Long denomId)  {
        return dispenserService.getDenom(denomId)
        		.orElseThrow(() -> new DenomNotFoundException("denom", "id", denomId));
    }
}
