/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET C - Question 2:
 * Write a Java program to read the marks of students across multiple subjects, create a program to:
 * a) Group students by subject.
 * b) Display the top scorer(s) in each subject.
 * c) Handle ties (same marks) appropriately.
 * 
 * Hint: You may need a collection of maps or a map of lists depending on grouping and sorting needs.
 */

import java.util.*;

class StudentScore {
    String studentName;
    int marks;

    public StudentScore(String studentName, int marks) {
        this.studentName = studentName;
        this.marks = marks;
    }
}

public class StudentMarksGrouping {
    public static void main(String[] args) {
        // Map to group students by subject: Subject -> List<StudentScore>
        Map<String, List<StudentScore>> subjectMap = new LinkedHashMap<>();

        // Helper lambda to record a mark
        recordScore(subjectMap, "Java Programming", "Aarav", 95);
        recordScore(subjectMap, "Java Programming", "Meera", 95); // Tie with Aarav
        recordScore(subjectMap, "Java Programming", "Rohan", 88);

        recordScore(subjectMap, "Operating Systems", "Sneha", 92);
        recordScore(subjectMap, "Operating Systems", "Aditya", 89);
        recordScore(subjectMap, "Operating Systems", "Vikram", 92); // Tie with Sneha

        recordScore(subjectMap, "Database Systems", "Kiran", 98);
        recordScore(subjectMap, "Database Systems", "Pooja", 91);

        System.out.println("==================================================");
        System.out.println("         STUDENT MARKS GROUPED BY SUBJECT         ");
        System.out.println("==================================================");

        // a) Grouped display & b) Top scorers with c) tie handling
        for (Map.Entry<String, List<StudentScore>> entry : subjectMap.entrySet()) {
            String subject = entry.getKey();
            List<StudentScore> scores = entry.getValue();

            System.out.println("\nSubject: " + subject);
            System.out.println("  All Students:");
            int maxMarks = -1;
            for (StudentScore s : scores) {
                System.out.println("    - " + s.studentName + " : " + s.marks + " marks");
                if (s.marks > maxMarks) {
                    maxMarks = s.marks;
                }
            }

            // Find all top scorers matching maxMarks
            List<String> topScorers = new ArrayList<>();
            for (StudentScore s : scores) {
                if (s.marks == maxMarks) {
                    topScorers.add(s.studentName);
                }
            }

            System.out.print("  🏆 Top Scorer(s) [" + maxMarks + " marks]: ");
            if (topScorers.size() > 1) {
                System.out.println(String.join(", ", topScorers) + " (TIE!)");
            } else {
                System.out.println(topScorers.get(0));
            }
        }
    }

    private static void recordScore(Map<String, List<StudentScore>> map, String subject, String student, int marks) {
        map.computeIfAbsent(subject, k -> new ArrayList<>()).add(new StudentScore(student, marks));
    }
}

