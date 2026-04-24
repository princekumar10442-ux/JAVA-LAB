import java.io.*;
import java.util.*;

// Student class to store student data
class Student {
    int id;
    String name, branch;
    int m1, m2, m3, m4, m5;
    double percentage;

    //  Constructor to initialize student data
    Student(int id, String name, String branch, int m1, int m2, int m3, int m4, int m5) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
    }

    //  Method to calculate percentage
    void calculatePercentage() {
        this.percentage = (m1 + m2 + m3 + m4 + m5) / 5.0;
    }

    //  Convert object data into CSV format (String)
    public String toString() {
        return id + "," + name + "," + branch + "," +
                m1 + "," + m2 + "," + m3 + "," +
                m4 + "," + m5 + "," + percentage;
    }
}

//  Class containing all CRUD operations
public class StudentOperations {

    //  CSV file name
    static String fileName = "Students.csv";

    //  CREATE (ADD) 
    public static void addStudents() {

        try (FileWriter fw = new FileWriter(fileName, true)) { // true → append mode

            //  Creating 3 new students (marks4 & marks5 = 0 initially)
            Student s1 = new Student(3, "Rahul", "CS", 70, 65, 60, 0, 0);
            Student s2 = new Student(4, "Neha", "IT", 88, 92, 85, 0, 0);
            Student s3 = new Student(5, "Aman", "ENTC", 75, 80, 78, 0, 0);

            //  Writing data into CSV file
            fw.write("\n" + s1);
            fw.write("\n" + s2);
            fw.write("\n" + s3);

            System.out.println("Added 3 students");

        } catch (IOException e) {
            //  Handling file error
            System.out.println("Error in ADD: " + e);
        }
    }

    // UPDATE 
    public static void updateStudents() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            List<String> list = new ArrayList<>();

            //  Read header row
            String line = br.readLine();
            list.add(line);

            //  Read each student row
            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");

                // ➤ Updating marks4 and marks5
                Student s = new Student(
                        Integer.parseInt(d[0]), // id
                        d[1],                  // name
                        d[2],                  // branch
                        Integer.parseInt(d[3]),
                        Integer.parseInt(d[4]),
                        Integer.parseInt(d[5]),
                        80, // new marks4
                        85  // new marks5
                );

                //  Calculate percentage
                s.calculatePercentage();

                //  Add updated row
                list.add(s.toString());
            }

            br.close();

            //  Rewrite entire file with updated data
            FileWriter fw = new FileWriter(fileName);
            for (String row : list) {
                fw.write(row + "\n");
            }
            fw.close();

            System.out.println("Updated marks + percentage");

        } catch (IOException e) {
            System.out.println("Error in UPDATE: " + e);
        }
    }

    //  DELETE 
    public static void deleteStudent(int id) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            List<String> list = new ArrayList<>();

            //  Keep header
            String line = br.readLine();
            list.add(line);

            //  Remove row with matching ID
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                if (Integer.parseInt(d[0]) != id) {
                    list.add(line); // keep row
                }
            }

            br.close();

            //  Rewrite file without deleted row
            FileWriter fw = new FileWriter(fileName);
            for (String row : list) {
                fw.write(row + "\n");
            }
            fw.close();

            System.out.println("Deleted student ID: " + id);

        } catch (IOException e) {
            System.out.println("Error in DELETE: " + e);
        }
    }

    //  READ 
    public static void display() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\n--- FILE DATA ---");

            //  Print each line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error in READ: " + e);
        }
    }
}