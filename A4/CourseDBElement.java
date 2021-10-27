
public class CourseDBElement implements Comparable{

	String CourseID;
	int CRN;
	int NumOfCredits;
	String RoomNum;
	String InterctorName;
	public CourseDBElement(String CourseID, int CRN, int NumOfCredits, String RoomNum, String InterctorName) {
		this.CourseID = CourseID;
        this.NumOfCredits = NumOfCredits;
        this.RoomNum = RoomNum;
        this.InterctorName = InterctorName;
        this.CRN = CRN;	}
	public CourseDBElement() {
		CourseID = null;
		CRN = 0;
		NumOfCredits = 0;
		RoomNum = null;
		InterctorName = null;
	}
	public void setCRN(int parseInt) {
		this.CRN = parseInt;
	}
	public Object getCRN() {
		return CRN;
	}
	public int getNumberOfCredits() {
		return NumOfCredits;
	}
	public void setNumberOfCredits(int NumOfCredits) {
		this.NumOfCredits = NumOfCredits;
	}

	public String getRoomNumber() {
		return RoomNum;
	}
	public void setRoomNumber(String RoomNum) {
		this.RoomNum = RoomNum;
	}
	public String getCourseId() {
		return CourseID;
	}
	public void serCourseId(String CourseID) {
		this.CourseID = CourseID;
	}
	public String getInstructorName() {
		return InterctorName;
	}
	public void setInstructorName(String InterctorName) {
		this.InterctorName= InterctorName;
	}
	@Override
	public int compareTo(CourseDBElement element) {
        if ( element.CRN < this.CRN )
            return 1;
        else if (element.CRN > this.CRN)
            return -1;
        else
            return 0;
	}
    @Override
    public int hashCode() {
        String crn = Integer.toString(CRN);
        int hashCode = crn.hashCode();
        return hashCode;
    }
    
    
}
