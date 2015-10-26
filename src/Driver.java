/**
 * Created by Qadir on 3/22/2015.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        System.out.println("Study Buddy: The App meant for RIT Students.");
        System.out.println("\tCopyright 4 Blind Mice 2015.\n");

        System.out.println("Enter your name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter a short bio of yourself.");
        String profile = new Scanner(System.in).nextLine();
        Student stu = new Student(name, profile);
        System.out.println("Would you like to remain visible so that other students may be able to find you?");
        String response = new Scanner(System.in).next();
        if(!response.toLowerCase().equals("yes") && !response.toLowerCase().equals("y")){
            stu.setVisibility(true);
        }
        else{
            stu.setVisibility(false);
        }
        System.out.println("Please enter the name, details, and priority level of the subject (1 being don't" +
                " worry about it, 5 being urgent).");

        String finished;
        do{
            int priority;
            String subjectName;
            String details;
            System.out.println("Enter a subject name.");
            subjectName = new Scanner(System.in).nextLine();
            System.out.println("Enter the subject's details.");
            details = new Scanner(System.in).nextLine();
            System.out.println("Enter the subject's priority level.");
            priority = new Scanner(System.in).nextInt();
            stu.addSubject(subjectName, details, priority);
            System.out.println("Are you finished?");
            finished = new Scanner(System.in).next();

        }while(!finished.toLowerCase().equals("yes") && !finished.toLowerCase().equals("y"));

        System.out.println("Student " + stu.getName() + "'s" + " identification: " + stu.getId());
        System.out.println(stu.toString());



        Student qadir = new Student("Qadir Haqq", "Computer Science Major" );
        Student phil = new Student("Philip Bedward", "Software Engineer");
        Student cam = new Student("Cameron Clark", "Computer Security");
        Student dan = new Student("Daniel Roach", "Software Engineer");



        qadir.addSubject("American Sign Language", "Unit 6: Telling Time");
        cam.addSubject("Discrete Math", "Unit 2.2: Set Theory");
        qadir.addSubject("Calculus B", "Unit 6.2: Integrals - Area under Curve");
        dan.addSubject("CS Theory", "Gates");
        phil.addSubject("Discrete Math", "Unit 5.1: Sequences");
        qadir.addSubject("CS Theory", "Gates");
        cam.addSubject("American Sign Language", "Unit 5");
        dan.addSubject("Calculus B", "Unit 6.1: Integrals - U-Sub");

        //Group fbm = new Group("Four Blind Mice");
        //fbm.addStudent(cam);
        //fbm.addStudent(dan);
        //fbm.addStudent(phil);
        //fbm.addStudent(qadir);

        //qadir.setVisibility(false);
        System.out.println("Identification for Qadir: " + qadir.getId());
        System.out.println("Identification for Cam: " + cam.getId());
        System.out.println("Identification for Phil: " + phil.getId());
        System.out.println("Identification for Dan: " + dan.getId());

        System.out.println(qadir.toString());
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println(stu.toString());
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println(phil.toString());
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println(cam.toString());
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println(dan.toString());
        System.out.println("////////////////////////////////////////////////////////////");
        //System.out.println(fbm.toString());
        //System.out.println("////////////////////////////////////////////////////////////");

    }
}
