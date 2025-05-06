import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Studentss{
    String name;
    int score;

    Studentss(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " - " + score;
    }
}
public class Bai3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("An" ,9),
                new Student("Tú", 7),
                new Student("Dương", 4),
                new Student("Viet", 9),
                new Student("Hồng", 4)
        );

        Map<String, List<Student>> result = students.stream().collect(Collectors.groupingBy(student ->{
            if (student.score >= 5) {
               return "Pass";
            } else {
                return "Fail";
            }
        } ));
        System.out.println("Phân loại kết quả: ");
        for(String key : result.keySet()) {
            System.out.println(key + ":");
            for(Student s : result.get(key)) {
                System.out.println(" " + s.name + " - " + s.score);
            }
        }
    }
}
