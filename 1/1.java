class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    public Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getDaysAttended() { return daysAttended; }
    public void setDaysAttended(int daysAttended) { this.daysAttended = daysAttended; }
}

class Classroom {
    private Student[] students = new Student[10]; 
    private int studentCount = 0;

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        } else {
            System.out.println("Classroom is full, cannot add more students.");
        }
    }

    public void updateAttendance(int studentId, int newDays) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(newDays);
                return;
            }
        }
        System.out.println("Student ID " + studentId + " not found.");
    }

    public void displayStudents() {
        System.out.println("Student ID  Name        Days Attended");
        for (int i = 0; i < studentCount; i++) {
            
            System.out.println(students[i].getStudentId() + "\t\t" + students[i].getName() + "\t" + students[i].getDaysAttended());
        }
    }
}

class AttendanceSystem {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        classroom.updateAttendance(102, 16);
        classroom.updateAttendance(104, 20); 

        classroom.displayStudents();
    }
}