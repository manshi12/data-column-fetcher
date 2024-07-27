package com.example.controller;

import com.example.model.ColumnData;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/column/{columnIndex}")
    public CompletableFuture<ResponseEntity<ColumnData>> getColumn(@PathVariable int columnIndex) {
        return dataService.fetchColumn(columnIndex)
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> ResponseEntity.badRequest().build());
    }
}