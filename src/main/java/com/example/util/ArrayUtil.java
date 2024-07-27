package com.example.util;

import org.springframework.stereotype.Component;

@Component
public class ArrayUtil {

    private final double[][] data;

    public ArrayUtil() {
        // Initialize with sample data (4 columns)
        this.data = new double[][]{
                {1.0, 2.0, 3.0, 4.0},
                {5.0, 6.0, 7.0, 8.0},
                {9.0, 10.0, 11.0, 12.0},
                // Add more rows as needed
        };
    }

    public double[] getColumn(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= 4) {
            throw new IllegalArgumentException("Invalid column index. Must be between 0 and 3.");
        }
        double[] column = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            column[i] = data[i][columnIndex];
        }
        return column;
    }

    public int getColumnCount() {
        return 4;
    }
}