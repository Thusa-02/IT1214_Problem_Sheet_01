class Student {
    private int studentid;
    private String name;
    private int daysAttended;

    
    public Student(int studentid, String name, int daysAttended) {
        this.studentid = studentid;
        this.name = name;
        this.daysAttended = daysAttended;
    }

   
    public int getStudentId() {
        return studentid;
    }

    public void setStudentId(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    
    public void displayDetails() {
        System.out.println("ID: " + studentid + ", Name: " + name + ", Days Attended: " + daysAttended);
    }
}

 class Classroom {
    private Student[] students;
    private int count;

    
    public Classroom() {
        students = new Student[10]; 
        count = 0;
    }

    
    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Classroom is full. Cannot add more students.");
        }
    }

    
    public void updateAttendance(int studentid, int newDaysAttended) {
        boolean show = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentid) {
                students[i].setDaysAttended(newDaysAttended);
                System.out.println("Attendance updated for student ID " + studentid);
                show = true;
                break;
            }
        }
        if (!show) {
            System.out.println("Student ID " + studentid + " not found.");
        }
    }

    
    public void displayAllStudents() {
        
        for (int i = 0; i < count; i++) {
			
            students[i].displayDetails();
        }
    }
}

 class Attendance {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

    
        Student s1 = new Student(101, "Anne", 12);
        Student s2 = new Student(102, "John", 15);
        Student s3 = new Student(103, "Miller", 10);

        classroom.addStudent(s1);
        classroom.addStudent(s2);
        classroom.addStudent(s3);

        classroom.updateAttendance(102, 16);
        
        classroom.updateAttendance(104, 8);

        classroom.displayAllStudents();
    }
}
