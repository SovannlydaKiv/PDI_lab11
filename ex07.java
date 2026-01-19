import java.io.*;
import java.util.*;

public class ex07 {
    
    static class Candidate {
        String id;
        String gender;
        String group;
        String education;
        String testPreparationCourse;
        int math;
        int english;
        int computer;
        int total;
        double average;
        
        public Candidate(String line) {
            String[] parts = line.split(",");
            this.id = parts[0];
            this.gender = parts[1];
            this.group = parts[2];
            this.education = parts[3];
            this.testPreparationCourse = parts[4];
            this.math = Integer.parseInt(parts[5]);
            this.english = Integer.parseInt(parts[6]);
            this.computer = Integer.parseInt(parts[7]);
            this.total = Integer.parseInt(parts[8]);
            this.average = Double.parseDouble(parts[9]);
        }
        
        public String toCSV() {
            return id + "," + gender + "," + group + "," + education + "," +
                   testPreparationCourse + "," + math + "," + english + "," + computer + "," + total + "," + average;
        }
    }
    
    public static void bubbleSort(Candidate[] candidates) {
        int n = candidates.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (candidates[j].average > candidates[j + 1].average) {
                    // Swap candidates[j] and candidates[j+1]
                    Candidate temp = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Admin/Documents/y2/PDI/TP/TP11/CandidatePerformanceTest.csv"));
            reader.readLine(); 
            reader.readLine(); 
            
            List<Candidate> candidateList = new ArrayList<>();
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; 
                System.out.println("Reading line " + lineNum + ": " + line);
                candidateList.add(new Candidate(line));
                lineNum++;
            }
            reader.close();

            Candidate[] candidates = candidateList.toArray(new Candidate[0]);

            bubbleSort(candidates);

            BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_candidates.csv"));
            writer.write("ID,gender,group,Education,test_preparation_course,Math,English,Computer,Total,Average\n");
            
            for (Candidate candidate : candidates) {
                writer.write(candidate.toCSV() + "\n");
            }
            writer.close();
            
            System.out.println("Data sorted by average score using Bubble Sort!");
            System.out.println("Sorted data written to 'sorted_candidates.csv'");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}