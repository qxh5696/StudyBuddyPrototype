import java.util.*;

/**
 * Created by Qadir on 3/22/2015.
 */
public class Student {
    public static int id = 1;
    public int idNumber;
    private String name; //Name of the student
    private String profile;//A short bio of the student (most commonly just their major)
    private List<Subject> subjects = new ArrayList<Subject>();//The list of subjects that each student wants to cover
    private List<Student> matches = new ArrayList<Student>(); //The matches for each student based off of subject
    private Map<Student, Integer> commonStudents = new HashMap<Student, Integer>();
    private boolean visibility = true;
    private static Community community = new Community();//The overall community of students
    private List<Integer> ratingsOfInteractions = new ArrayList<Integer>(); //The ratings of the student for each
                                                                        // interaction
    private int reliablity = 3;//A rating that each person will get based on how good of a study partner they were
                                //The higher the better

    public Student(){
        this.idNumber = id++;
    }

    public int getId(){
        return this.idNumber;
    }

    /**
     * Constructor for a new student object, automatically added to the overall community
     * @param name
     * @param profile
     */
    public Student(String name,String profile){
        this.idNumber = id++;//(REMEMBER TO DELETE THIS LATER)
        this.name = name;
        this.profile= profile;
        this.reliablity = 3;
        this.community.addStudent(this);
    }

    /**
    public Student createStudent(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = input.next();
        String profile = "";
        System.out.println("Enter a short bio of yourself.");
        while(input.hasNextLine()){
                profile += input.next();
        }
        Student stu = new Student(name, profile);
        System.out.println("Which subjects do you need help with?");
        System.out.println("Please enter the name, details, and priority level of the subject (1 being don't" +
                " worry about it, 5 being urgent).");

        while(input.hasNextLine()){
            int priority = 0;
            String subjectName = "";
            String details = "";
            System.out.println("Enter a subject name");
            if (input.hasNextLine()){
                subjectName = input.next();
            }
            System.out.println("Enter the subject's details");
            if (input.hasNextLine()){
                details = input.next();
            }
            System.out.println("Enter the subject's priority");
            if (input.hasNextInt()){
                priority = input.nextInt();
            }
            addSubject(subjectName, details, priority);
        }

        System.out.println("Would you like to be visible so that people can add you? (y/n)");
        if(input.hasNext()){
            if (input.next() == "y"){
                this.visibility = true;
            }
            else {
                this.visibility = false;
            }
        }
        System.out.println("Awesome, lets get started ");

        input.close();
        return stu;
    }*/

    /**
     * Adds a subject to the list of subjects that people want to cover
     * @param name name of the subject
     * @param details the certain details or criteria a person wants to cover for that subject in a study session
     */
    public void addSubject(String name, String details){
        this.subjects.add(new Subject(name, details));
        for (int i = 0; i < this.community.getCommunity().size(); i++){
            if (this.community.getCommunity().get(i) == this){
                continue;
            }
            else{
                this.addMatch(this.community.getCommunity().get(i));
            }

        }
    }

    /**
     * Adds a subject to the list of subjects that people want to cover
     * @param name name of the subject
     * @param details the certain details or criteria a person wants to cover for that subject in a study session
     * @param priority A rating that each person will get based on how good of a study partner they were
     */
    public void addSubject(String name, String details, int priority){
        this.subjects.add(new Subject(name, details, priority));
        for (int i = 0; i < this.community.getCommunity().size(); i++){
            if (this.community.getCommunity().get(i) == this){
                continue;
            }
            else{
                this.addMatch(this.community.getCommunity().get(i));
            }

        }
    }

    /**
     * Returns the "i" index of the subject in the list. if the i value is greater than the available number of subjects
     * a person has, it returns an i value equal to one less the size of the list and returns the last part
     * @param i the index of the subject in the student's subject list
     * @return the subject object that the person wanted
     */
    public Subject getSubject(int i){
        if (i > this.subjects.size()){
            i = this.subjects.size()-1;
        }
        return this.subjects.get(i);
    }

    /**
     * Only prints part1 of the student's toString function
     * @return
     */
    public String simplePrint(){
        String result = displayStudent();
        return result;
    }

    /**
     * Prints out the student object
     * @return a string of the student object
     */
    public String toString(){
        String res1 = displayStudent();
        String result = "";
        res1 += displaySubjects();
        result += displayMatches();
        System.out.println(res1);
        for (Student stu: commonStudents.keySet()){
            System.out.println("Number of subjects in common with " + stu.getName() + ": " + this.commonStudents.get(stu));
        }

        return result;
    }

    /**
     * Part1 of the Student toString
     * @return String with student's name, profile, and reliability
     */
    public String displayStudent(){
        return "Name: " + this.name + "\n" + "Profile: " + this.profile + "\n" + "Reliability: " +
                this.reliablity + "\n";
    }

    /**
     * Part2 of the Student toString
     * @return String with student's subjects
     */
    public String displaySubjects(){
        String result = "";
        //Trying to get subjects to sort by priority when displayed
        for(int i = 0; i < this.subjects.size(); i++){
            result += "\t" + this.subjects.get(i).toString() + "\n";
        }

        return result;
    }

    /**
     * Part3 of the student's toString function
     * Only shows the people and the only subjects you match with
     * @return String of the subject details
     */
    public String displayMatches(){
        String result = "Matches: " + "\n";
        for(int i = 0; i < this.matches.size(); i++){
            if(this.matches.get(i).getVisibility() == true){
                result += "\t" + this.matches.get(i).getName() +
                        "\n\t" + this.matches.get(i).getReliablityString() + "\n";
                for (int j = 0; j < this.matches.get(i).getSubjects().size(); j++){
                    for (int k = 0; k < this.getSubjects().size(); k++){
                        if (this.matches.get(i).getSubjects().get(j).getName().equals(this.getSubjects().get(k).getName())){
                            if (!(this.commonStudents.containsKey(this.matches.get(i)))){
                                commonStudents.put(this.matches.get(i), 1);
                            }else{
                                commonStudents.put(this.matches.get(i), commonStudents.get(this.matches.get(i))+1);
                            }
                            result += "\t" + this.matches.get(i).getSubjects().get(j) + "\n";
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns the name field of the instance of this class
     * @return String name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Return the reliability of the student object
     * @return a double (sometimes an integer) of the student's reliability
     */
    public int getReliablity(){
        int totalRatings = 0;
        if(this.ratingsOfInteractions.size() == 1){
            return this.ratingsOfInteractions.get(0);
        }
        for(int i = 0; i < ratingsOfInteractions.size(); i++){
            totalRatings += ratingsOfInteractions.get(i);
        }

        return totalRatings/ratingsOfInteractions.size();
    }

    /**
     * Return the reliability of the student object in a string format
     * @return
     */
    public String getReliablityString(){
        return "Reliablity: " + this.reliablity;
    }

    /**
     * Get the list of subjects for the student
     * @return
     */
    public List<Subject> getSubjects(){
        return this.subjects;
    }

    //Change to private later
    public Map<Student, Integer> getCommonStudents(){
        return commonStudents;
    }

    //We need an integer that keeps track of the number of common subjects one student has with another

    /**
     * The actual match function that adds a student a match list and vice versa
     * @param stu
     */
    private void addMatch(Student stu){
        for(int i = 0; i < this.subjects.size(); i++){
            for (int j = 0; j < stu.getSubjects().size(); j++){
                if (this.getSubjects().get(i).getName().trim().toLowerCase()//This student object's subject
                        .equals(stu.getSubjects().get(j).getName().trim().toLowerCase())){//The other student object's subject
                    if (!(this.matches.contains(stu))){
                        this.matches.add(stu);
                        stu.matches.add(this);
                        //this.commonStudents.put(stu, 1);
                        //stu.getCommonStudents().put(this, 1);
                    }
                    /*
                    else  if (commonStudents.containsKey(stu)){
                        this.commonStudents.put(stu, this.commonStudents.get(stu) + 1);
                        stu.getCommonStudents().put(this, stu.getCommonStudents().get(this) + 1);
                        //System.out.println("AddMatch Stu: " + stu.getName() + ": " + this.commonStudents.get(stu));
                        //System.out.println("AddMatch This: " + this.getName() + ": " + this.commonStudents.get(stu));
                    }*/
                }
            }
        }
    }

    /**
     * Set visibility and get visibility
     */
    public void setVisibility(boolean vis){
        this.visibility = vis;
    }
    public boolean getVisibility(){
        return this.visibility;
    }


}
