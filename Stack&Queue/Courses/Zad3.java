package Courses;

import Classes.LinkedQueue;

import java.util.*;

public class Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        // science , scifi, history

        LinkedQueue<Student> scienceQueue = new LinkedQueue<>();
        LinkedQueue<Student> scifiQueue = new LinkedQueue<>();
        LinkedQueue<Student> historyQueue = new LinkedQueue<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            boolean science = scanner.nextInt() == 1;
            boolean scifi = scanner.nextInt() == 1;
            boolean history = scanner.nextInt() == 1;
            scanner.nextLine();

            Student student = new Student(name, science, scifi, history);

            if (science) scienceQueue.enqueue(student);
            else if (scifi) scifiQueue.enqueue(student);
            else if (history) historyQueue.enqueue(student);
        }

        while (!scienceQueue.isEmpty() || !scifiQueue.isEmpty() || !historyQueue.isEmpty()) {
            if (scienceQueue.size() >= 2) {
                for (int i = 0; i <2 ; i++) {
                    Student tmp = scienceQueue.dequeue();
                    if (tmp.sciFi) scifiQueue.enqueue(tmp);
                    else if (tmp.history) historyQueue.enqueue(tmp);
                    else System.out.println(tmp.name);

        }
            } else if (scienceQueue.size() == 1) {
                Student tmp = scienceQueue.dequeue();
                if (tmp.sciFi) scifiQueue.enqueue(tmp);
                else if (tmp.history) historyQueue.enqueue(tmp);
                else System.out.println(tmp.name);
            }

            if (!scifiQueue.isEmpty()) {
                Student tmp = scifiQueue.dequeue();
                if (tmp.history) historyQueue.enqueue(tmp);
                else System.out.println(tmp.name);
            }

            if (historyQueue.size() >= 2) {
                for (int i = 0; i <2 ; i++) {
                    Student tmp = historyQueue.dequeue();
                    System.out.println(tmp.name);
                }
            } else if (historyQueue.size() == 1) {
                Student tmp = historyQueue.dequeue();
                System.out.println(tmp.name);
            }
        }
    }
}
