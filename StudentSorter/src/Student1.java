public class Student1 {
    private String firstName;
    private String lastName;
    private int id;
    private double grade;

    public Student1(String firstName, String lastName, int id, double grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.grade = grade;
    }

    //getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getId(){
        return id;
    }
    public double getGrade(){
        return grade;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + id + " " + grade;
    }


}
