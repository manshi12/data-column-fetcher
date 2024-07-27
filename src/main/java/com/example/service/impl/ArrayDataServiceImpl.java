package com.example.service.impl;

import com.example.model.ColumnData;
import com.example.service.DataService;
import com.example.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ArrayDataServiceImpl implements DataService {

    private final ArrayUtil arrayUtil;

    @Autowired
    public ArrayDataServiceImpl(ArrayUtil arrayUtil) {
        this.arrayUtil = arrayUtil;
    }

    @Override
    public CompletableFuture<ColumnData> fetchColumn(int columnIndex) {
        return CompletableFuture.supplyAsync(() -> {
            double[] column = arrayUtil.getColumn(columnIndex);
            return new ColumnData(column);
        });
    }
}