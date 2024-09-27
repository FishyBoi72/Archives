import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    // A class to represent a task
    static class Task {
        String description;
        boolean isCompleted;

        // Constructor for task
        public Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        // Mark task as completed
        public void complete() {
            this.isCompleted = true;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[X] " : "[ ] ") + description;
        }
    }

    // List to store tasks
    private static final ArrayList<Task> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main program loop
        while (true) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskCompleted(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Print the menu options
    private static void printMenu() {
        System.out.println("\n--- To-Do List ---");
        System.out.println("1. Add a Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Delete a Task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // Add a task to the list
    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        toDoList.add(new Task(description));
        System.out.println("Task added!");
    }

    // View all tasks in the list
    private static void viewTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("\nTasks:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    // Mark a task as completed
    private static void markTaskCompleted(Scanner scanner) {
        if (toDoList.isEmpty()) {
            System.out.println("There are no tasks to mark as completed.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= toDoList.size()) {
            Task task = toDoList.get(taskNumber - 1);
            task.complete();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Delete a task from the list
    private static void deleteTask(Scanner scanner) {
        if (toDoList.isEmpty()) {
            System.out.println("There are no tasks to delete.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= toDoList.size()) {
            toDoList.remove(taskNumber - 1);
            System.out.println("Task deleted!");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
