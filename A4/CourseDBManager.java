import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure structure = new CourseDBStructure(100);

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(element);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			//CourseDBElement element = structure.get(crn);
			return structure.get(crn);

		} catch (IOException e) {

			e.getMessage();
			return null;
		}
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		ArrayList<String> a = new ArrayList<>();
		Scanner file;
		try {
			file = new Scanner(input);
			while (file.hasNext()) {
		        a.add(file.nextLine());
		    }
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found");
		}

		while(file.hasNextLine()) {
			Scanner S = new Scanner(file.nextLine());
			String ID = S.next();
			String ROOM = S.next();
			String Instr = null;
			int CRN = S.nextInt();
			int Credits = S.nextInt();
			while (S.hasNext()) {
				 Instr += S.next() + " ";
				
			}
			CourseDBElement e = new CourseDBElement(ID, CRN, Credits, ROOM, Instr);
			structure.add(e);
		}
		file.close();
	}

	@Override
	public ArrayList<String> showAll() {
        ArrayList<String> List = new ArrayList<String>();
        for (LinkedList<?> linkedList: structure.hashTable) {
            if (linkedList!=null) {
                CourseDBElement[] Array = (CourseDBElement[]) linkedList.toArray(new CourseDBElement[linkedList.size()]);

                for (CourseDBElement element: Array) {
                    String courseInfo = "\nCourse:"+element.getCourseId()+ " CRN:"+element.getCRN() +
                            " Credits:"+ element.getNumberOfCredits()+" Instructor:"+ element.getInstructorName()+
                            " Room:"+ element.getRoomNumber();
                    List.add(courseInfo);
                }
            }
        }
        return List;
		
	}

}
