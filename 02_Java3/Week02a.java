import java.util.*;

class Student {
    public String sid;
    public String name;
    private float gpa;

    public Student(String sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    // getter (accessor)
    public float getGPA() {
        return gpa;
    }

    // setter (mutator)
    public void setGPA(float gpa) {
        this.gpa = gpa;
    }
    
    public String toString() {
        return "Student(" +
               sid + ", " +
               name + ", " +
               gpa + ")";
    }
}

interface FloatFilter {
    boolean match(float value);
}

class PassingFilter implements FloatFilter {
    public boolean match(float value) {
        if (value >= 50.0f) {
            return true;
        } else {
            return false;
        }
    }
}

public class Week02a {
    public static List<Float> applyFilter(
        List<Float> items,
        FloatFilter filter
    ) {
        ArrayList<Float> results = new ArrayList<>();
        for (float item: items) {
            if (filter.match(item)) {
                results.add(item);
            }
        }
        return results;
    }

    static void runDemo() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ashfaq");
        names.add("Vishan");
        names.add("Harambe");

        for (String name: names) {
            System.out.println(name);
        }

        Student sally = new Student(
            "100000000", 
            "Sally Smith"
        );
        sally.setGPA(4.3f);
        Pair<String,Student> sallyPair = new Pair<>(
            "100000000",
            sally
        );

        System.out.println(sallyPair);

        ArrayList<Float> grades = new ArrayList<>();
        grades.add(45.0f);
        grades.add(61.0f);
        grades.add(17.0f);
        grades.add(74.0f);

        PassingFilter passingFilter = new PassingFilter();

        List<Float> filteredGrades = applyFilter(grades, passingFilter);

        System.out.println("Passing grades:");
        for (float grade: filteredGrades) {
            System.out.println(grade);
        }
    }

    public static void main(String[] args) {
        runDemo();
    }
}