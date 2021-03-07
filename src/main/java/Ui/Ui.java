package Ui;

import Duke.*;
import java.util.Scanner;

public class Ui {
    private Scanner sc;
    private String userInput;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String getUserInput() {
        this.userInput = this.sc.nextLine().trim();
        return userInput;
    }

    public static void printGreeting() {
        String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Greetings! I am Duke! How may I assist you?\n");
    }

    public static void printGoodbye() {
        System.out.println("\nGoodbye! Have a nice day!\n");
    }

    public static void printList(TaskList tasks) {
        for (int i = 1; i <= tasks.getSize(); i++) {
            System.out.println(i + ". " + tasks.get(i).toString());
        }
    }

    public void printDoneMessage(Task task) {
        System.out.println("Alright, I will mark this as done.\n" + task.toString());
    }

    public void printTaskAddedMessage(Task task, int count) {
        System.out.println("Got it. I have added this task: \n" + task.getDescription()
                            + ". \n Now you have " + count + " items in your list.");
    }

    public void printTaskRemovedMessage(int index) {
        System.out.println("I have removed item " + index + ". Welcome.");
    }

}