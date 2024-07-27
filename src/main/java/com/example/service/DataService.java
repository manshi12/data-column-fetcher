package com.example.service;

import com.example.model.ColumnData;
import java.util.concurrent.CompletableFuture;

public interface DataService {
    CompletableFuture<ColumnData> fetchColumn(int columnIndex);
}