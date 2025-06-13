package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("📝 Task Tracker - Nhập lệnh: add, list, exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("👋 Tạm biệt!");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                if (tasks.isEmpty()) {
                    System.out.println("📭 Chưa có task nào.");
                } else {
                    for (Task task : tasks) {
                        System.out.println(task);
                    }
                }
            } else if (input.startsWith("add ")) {
                String desc = input.substring(4).trim();
                if (desc.isEmpty()) {
                    System.out.println("⚠️ Mô tả không được rỗng.");
                } else {
                    Task task = new Task(nextId++, desc);
                    tasks.add(task);
                    System.out.println("✅ Đã thêm task: " + desc);
                }
            } else {
                System.out.println("❌ Lệnh không hợp lệ. Dùng: add, list, exit");
            }
        }

        scanner.close();
    }
}