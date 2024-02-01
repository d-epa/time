package timemanagement;
import java.util.*;



public class project3 {


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int totalTime = 24; // Total hours in a day
            int remainingTime = totalTime;
            boolean[] tasks = new boolean[totalTime]; // Represents each hour of the day

            System.out.println("Welcome to Time Management!");

            while (true) {
                System.out.println("\n1. Add task");
                System.out.println("2. View tasks");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter task duration in hours: ");
                        int taskDuration = scanner.nextInt();
                        if (taskDuration <= remainingTime && taskDuration > 0) {
                            System.out.print("Enter starting hour (0-23): ");
                            int startHour = scanner.nextInt();
                            if (startHour >= 0 && startHour < totalTime) {
                                // Check if there's already a task scheduled in the specified time range
                                boolean overlap = false;
                                for (int i = startHour; i < startHour + taskDuration; i++) {
                                    if (tasks[i]) {
                                        overlap = true;
                                        break;
                                    }
                                }
                                if (!overlap) {
                                    for (int i = startHour; i < startHour + taskDuration; i++) {
                                        tasks[i] = true;
                                        remainingTime--;
                                    }
                                    System.out.println("Task added!");
                                } else {
                                    System.out.println("Task overlaps with existing task. Please choose another time.");
                                }
                            } else {
                                System.out.println("Invalid starting hour. Please enter a number between 0 and 23.");
                            }
                        } else {
                            System.out.println("Not enough time available for this task.");
                        }
                        break;
                    case 2:
                        System.out.println("Your daily schedule:");
                        for (int i = 0; i < tasks.length; i++) {
                            if (tasks[i]) {
                                System.out.println("Hour " + i + ": Task");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

