package com.example;

import java.util.List;

public class TaskService {
    private final JsonTaskRepository repository = new JsonTaskRepository();

    /**
     * Thêm task mới vào danh sách và lưu vào file JSON.
     *
     * @param description mô tả task
     */
    public void addTask(String description) {
        List<Task> tasks = repository.loadTasks();

        // Tìm ID kế tiếp
        int nextId = tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0) + 1;

        Task newTask = new Task(nextId, description);
        tasks.add(newTask);

        repository.saveTasks(tasks);
        System.out.println("✅ Đã thêm task: " + description);
    }

    /**
     * Hiển thị danh sách các task.
     */
    public void listTasks() {
        List<Task> tasks = repository.loadTasks();
        if (tasks.isEmpty()) {
            System.out.println("📭 Không có task nào.");
        } else {
            tasks.forEach(System.out::println);
        }
    }
}