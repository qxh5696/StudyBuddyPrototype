/**
* Created by Qadir on 3/22/2015.
 *
 */
public class Subject implements Comparable{
    private String name;//Name of the subject
    private String details;//Details of the subject
    private int priority;
    /**
     * Constructor for the Subject
     * @param name The name of the subject
     * @param details The details of the subject the person wants to study (Ex: Test soon in Calc, I want to study
     *                integrals)
     */
    public Subject(String name, String details){
        this.name = name.trim();
        this.details = details;
    }

    /**
     *
     * @param name Name of the subject
     * @param details the details of the subject
     * @param priority The priority level of the subject to the person who wants to study it
     */
    public Subject(String name, String details, int priority){
        this.name = name.trim();
        this.details = details;
        if (priority > 5){
            this.priority = 5;
        }
        else if (priority < 0){
            this.priority = 0;
        }
        else{
            this.priority = priority;
        }
    }

    /**
     * Returns a toString form of the subject
     * @return the subject name and details
     */
    public String toString(){
        if (this.priority == 0){
            return "Subject: " + this.name + "\n" + "\t\tDetails: " + this.details;
        }
        return "Subject: " + this.name + "\n" + "\t\tDetails: " + this.details + "\n\t\tPriority: " + this.priority;
    }

    /**
     * Returns just the subject name
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns just the details for the subject
     * @return
     */
    public String getDetails(){
        return this.details;
    }

    /**
     * Compare to method for "Collections.sort()" method, uses the String compare to method
     * @param o Subject object that will be compared to the object calling it
     * @return integer value based on the
     */
    public int compareTo(Object o){
        if (o instanceof Subject){
            Subject s = (Subject) o;
            return this.name.compareTo(s.getName());
        }
        return -1;
    }
}
