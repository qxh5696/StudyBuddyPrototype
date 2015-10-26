import java.util.*;

/**
 * Created by Qadir on 3/22/2015.
 */
public class Community {
    private ArrayList<Student> community = new ArrayList<Student>();
    private ArrayList<Subject> studentSubjects = new ArrayList<Subject>();
    Map<Student, Integer> reliablity = new HashMap<Student, Integer>();
    Map<Integer, Student> identification = new HashMap<Integer, Student>();

    public Community(){
    }

    public void addStudent(Student student){
        identification.put(student.getId(), student);
        this.community.add(student);
        reliablity.put(student, 3);
    }

    public Student getStudent(int id){
       return identification.get(id);
    }

    /**
     * Return a the list of students in the community
     * @return a list of students in the community
     */
    public List<Student> getCommunity(){
        return this.community;
    }

/////SORTS////////
    //CRITERIA/PRIORITY OF ORDER:
    /*
        1. NUMBER OF SUBJECTS PEOPLE HAVE IN COMMON
        2. LEVEL OF RELIABILITY
        3. SORT BY NAME LAST OF ALL
     */
    /**
     * Go through every student and return them in list by name
     * @return a String of the people in this community using each student's toString
     */
    public String sortByName(){
        String result = "";
        for (int i = 0; i < this.community.size(); i++){
            result += community.get(i).toString() + "\n";
        }
        return result;
    }

    /**
     * Sorts people and subjects by alphabetical order and adds them to a list USING A STREAM
     * @return an alphabetical list of people by subjects
     */
    public List<String> sortBySubject(){
        List<Subject> tempList = new ArrayList<>(studentSubjects);
        List<String> subjectList = new ArrayList<String>();
        Collections.sort(tempList);
        for(int i = 0; i< tempList.size(); i++){
            subjectList.add(tempList.get(i).getName());
        }
        return subjectList;
    }
    //Stream through and get the students that have the subject name in their subject list
    public List<Student> sortBySubject(String name){
        List <Student> tempList = new ArrayList<Student>();
        for (int i = 0; i < this.community.size();i++){
            if (community.get(i).getSubjects().get(i).getName().equals(name)){
                tempList.add(community.get(i));
            }
        }
        return tempList;
    }




/////FUN WITH STREAMS!/////////
    /**
     * Prints out all the subjects of every student
     */
    public void testStreams(){
        this.community.stream()//<- works with a regular stream
                .forEach(s -> s.getSubjects()//Student subject list
                        .stream().forEach(t -> System.out.println(t.getName())));//t is a subject object

    }

    //prints out subject objects of every student that matches the one given in the parameter
    public void testStreams2(Subject subject){
        this.community.stream()
                .forEach(s -> s.getSubjects()
                .stream()
                        .filter(sub -> sub.getName().equals(subject.getName()))
                                                                    .forEach(t -> System.out.println(t)));//


    }

}
