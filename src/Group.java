import java.util.ArrayList;
import java.util.List;

/**
 * Created by qadirhaqq on 3/26/15.
 */
public class Group {

    private List<Student> group = new ArrayList<Student>();
    private String meetingPlace;
    private String groupName;
    private String focus;

    public Group(){

    }

    public Group(String name){
        this.groupName = name;
    }

    public Group(String name, String focus){
        this.groupName = name;
        this.focus = focus;
    }

    public void setGroupName(String name){
        this.groupName = name;
    }
    public String getGroupName(){
        return this.groupName;
    }

    public void addStudent(Student student){
        group.add(student);
    }

    public void setMeetingPlace(String place){
        this.meetingPlace = place;
    }

    public String getMeetingPlace(){
        return  this.meetingPlace;
    }

    public void setFocus(String focus){
        this.focus = focus;
    }

    public String getFocus(){
        return this.focus;
    }

    public String toString(){
        String result = "";
        result += this.getGroupName() + "\n";
        for (int i = 0; i < this.group.size(); i++){
            result += "\t" + group.get(i).simplePrint() + "\n\n";
        }
        return result;
    }

    public List<Student> getGroup(){
        return this.group;
    }
}
