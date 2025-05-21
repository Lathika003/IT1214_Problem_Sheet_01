class Student {
    private String name;
    private int exam1;
    private int exam2;
    private int exam3;

    public Student(String name, int exam1, int exam2, int exam3) {
        if (!isValidScore(exam1) || !isValidScore(exam2) || !isValidScore(exam3)) {
            throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
        }
        this.name = name;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
    }

    private boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    public String getName() { return name; }
    public int getExam1() { return exam1; }
    public int getExam2() { return exam2; }
    public int getExam3() { return exam3; }

    public double calculateAverage() {
        return (exam1 + exam2 + exam3) / 3.0;
    }
}

 class GradeCalculator {
    public static void main(String[] args) {
        try {
            Student student = new Student("John", 75, 110, 90);
    System.out.println("Student:\t" + student.getName() + "\tAverage Score:\t" + student.calculateAverage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}