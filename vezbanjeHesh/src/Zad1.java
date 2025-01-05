import java.util.*;

class Vraboten implements Comparable<Vraboten>{
    String ime;
    int age;

    public Vraboten(String ime, int age) {
        this.ime = ime;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vraboten vraboten = (Vraboten) o;
        return age == vraboten.age && Objects.equals(ime, vraboten.ime);
    }

    @Override
    public int hashCode() {
        return age * ime.charAt(0);
    }

    @Override
    public String toString() {
        return  "<"+ime + ", " + age+">";
    }

    @Override
    public int compareTo(Vraboten o) {
        return this.age-o.age;
    }
}

class Project{
    int time;
    int salary;

    public Project(int time, int salary) {
        this.time = time;
        this.salary = salary;
    }

    public int getFullPay(){
        return salary * time;
    }

    @Override
    public String toString() {
        return  "<"+time + ", " + salary+">";
    }
}
public class Zad1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        CBHT<Vraboten, Project> cbht = new CBHT<>(10);

        for (int i = 0; i <n ; i++) {
            String [] line = scanner.nextLine().split(" ");
            Vraboten vraboten = new Vraboten(line[0], Integer.parseInt(line[1]));
            Project project = new Project(Integer.parseInt(line[2]), Integer.parseInt(line[3]));

            if(cbht.search(vraboten) == null){
                cbht.insert(vraboten, project);
            }else if(project.getFullPay()>cbht.search(vraboten).element.value.getFullPay()){
                cbht.insert(vraboten, project);
            }
        }
        System.out.println(cbht);
    }
}