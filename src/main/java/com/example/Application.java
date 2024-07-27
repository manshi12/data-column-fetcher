package com.example;

import com.example.model.ColumnData;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private DataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter column index to fetch (0-3) or 'q' to quit: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            try {
                int columnIndex = Integer.parseInt(input);
                dataService.fetchColumn(columnIndex)
                        .thenAccept(this::displayColumn)
                        .exceptionally(e -> {
                            System.out.println("Error: " + e.getMessage());
                            return null;
                        })
                        .join();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 3, or 'q' to quit.");
            }
        }
        scanner.close();
    }

    private void displayColumn(ColumnData columnData) {
        System.out.println("Column data:");
        for (double value : columnData.getData()) {
            System.out.println(value);
        }
        System.out.println();
    }
}