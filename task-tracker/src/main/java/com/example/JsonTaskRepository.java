package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonTaskRepository {
    private static final String FILE_PATH = "tasks.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Task> loadTasks() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return mapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (Exception e) {
            System.err.println("❌ Lỗi khi đọc file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveTasks(List<Task> tasks) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), tasks);
        } catch (Exception e) {
            System.err.println("❌ Lỗi khi ghi file: " + e.getMessage());
        }
    }
}