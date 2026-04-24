public class MainApp {

    public static void main(String[] args) {

        //  Display initial data (READ)
        StudentOperations.display();

        //  CREATE operation
        StudentOperations.addStudents();
        StudentOperations.display();

        // UPDATE operation (marks + percentage)
        StudentOperations.updateStudents();
        StudentOperations.display();

        //  DELETE operation (remove student with ID = 2)
        StudentOperations.deleteStudent(2);
        StudentOperations.display();

        //  Exception demonstration (file not found)
        try {
            java.io.FileReader fr = new java.io.FileReader("WrongFile.csv");
        } catch (java.io.IOException e) {
            System.out.println("\nException occurred: " + e);
        }
    }
}
