public class Main {
    public static void main(String[] args) {
        Students stud1 = new Students("Dhanish", 70, 70, 70);  
        Students stud2 = new Students("Abinesh", 80, 80, 80);  
        Students stud3 = new Students("Aswin", 90, 90, 90);  
        Students stud4 = new Students("Balaji", 100, 100, 100);  
        Students stud5 = new Students("Sanjay", 100, 100, 100);
        Students temp;  // Temp to store student object to swap

        Students[] studArr = {stud1, stud2, stud3, stud4, stud5};

        // Sorting students by average marks in descending order
        for (int i = 0; i < studArr.length; i++) {
            for (int j = i + 1; j < studArr.length; j++) {
                if (studArr[i].getAverage() < studArr[j].getAverage()) {
                    temp = studArr[i];
                    studArr[i] = studArr[j];
                    studArr[j] = temp;
                }
            }
        }

        // Printing students averages after sorting
        for (Students student : studArr) {
            System.out.println(student.getStudName() + ": " + student.getAverage());
        }
    }
}