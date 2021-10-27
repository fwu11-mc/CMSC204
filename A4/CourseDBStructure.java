import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	
	public LinkedList<CourseDBElement>[] hashTable;
	
	int hashTableSize= 0;
	
	public CourseDBStructure(String string, int i) {
		hashTable = new LinkedList[i];
		this.hashTableSize = i;
	}

	public CourseDBStructure(int i) {
		hashTable = new LinkedList[i];
		this.hashTableSize = i;
	}

	@Override
	public int getTableSize() {
		return hashTable.length;
	}

	@Override
	public void add(CourseDBElement element) {
		int hashCode = element.hashCode();
        int index = hashCode%hashTable.length;
        if (hashTable[index] == null){
            hashTable[index] = new LinkedList<CourseDBElement>();
            hashTable[index].add(element);
        }
        else if (hashTable[index] != null){
            hashTable[index].add(element);
        }
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement element = null;
		int key = Integer.toString(crn).hashCode() % hashTableSize;
		
		try {
			if (hashTable[key] != null) {
				for (int x = 0; x < hashTable[key].size(); x++) {
					if (hashTable[key].get(x).CRN == crn) {
						element = hashTable[key].get(x);
						return element;
					} 
				}
			} 
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < hashTableSize; i++) {
			if (hashTable[i] != null) {
				for (int j = 0; j < hashTable[i].size(); j++) {
					list.add("\n"+hashTable[i].get(j).toString());
				}
			}
		}
		
		return list;
	}

}
