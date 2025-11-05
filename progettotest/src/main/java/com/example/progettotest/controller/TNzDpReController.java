package com.example.progettotest.controller;

import com.example.progettotest.service.TNzDpReService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.progettotest.model.TNzDpRe;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/tnz-dp-re")
public class TNzDpReController {

    private final TNzDpReService tnzDpReService;

    @Autowired
    public TNzDpReController(TNzDpReService tnzDpReService) {
        this.tnzDpReService = tnzDpReService;
    }

    // Endpoint per tutte le descrizioni
    @GetMapping("/descriptions")
    @Operation(summary = "Get all descriptions from TNzDpRe records")
    public ResponseEntity<List<String>> getAllDescriptions() {
        List<String> descriptions = tnzDpReService.getAllDescriptions();
        return ResponseEntity.ok(descriptions);
    }

    // Endpoint per recuperare un record per ID
    @GetMapping("/{id}")
    @Operation(summary = "Get TNzDpRe record by ID")
    public ResponseEntity<TNzDpRe> getById(@PathVariable Long id) {
        TNzDpRe record = tnzDpReService.getById(id).orElse(null);
        if (record == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(record);
    }

    // Endpoint per cancellare un record per ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete TNzDpRe record by ID")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        tnzDpReService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint per recuperare tutti i record
    @GetMapping("/all")
    @Operation(summary = "Get all TNzDpRe records")
    public ResponseEntity<List<TNzDpRe>> getAllRecords() {
        List<TNzDpRe> records = tnzDpReService.getAllRecords();
        return ResponseEntity.ok(records);
    }
}
