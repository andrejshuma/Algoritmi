package Kniga;

import java.util.*;

public class KolokviumskaNedela {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numAssistants = scanner.nextInt();
        scanner.nextLine();

        Queue<String> asistenti = new LinkedList<>();

        for (int i = 0; i < numAssistants; i++) {
            asistenti.add(scanner.nextLine());
        }

        int numCourses = scanner.nextInt();
        scanner.nextLine();

        Queue<Course> courses = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            String[] input = scanner.nextLine().split(" ");
            courses.add(new Course(input[0], Integer.parseInt(input[1])));
        }

        LinkedList<String> missing = new LinkedList<>();
        int miss = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < miss; i++) {
            missing.add(scanner.nextLine());
        }

        for (int i = 0; i < asistenti.size(); i++) {
            String poll = asistenti.poll();
            if (!missing.contains(poll)) {
                asistenti.add(poll);
            }
        }


        while (!courses.isEmpty()) {
            Course course = courses.poll();
            System.out.println(course.name);
            System.out.println(course.num);
            for (int i = 0; i < course.num; i++) {
                String as = asistenti.poll();
                asistenti.add(as);
                System.out.println(as);
            }
        }
    }
}
