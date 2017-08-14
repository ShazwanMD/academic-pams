package my.edu.umk.pams.academic.planner.model;/**
 * subject type
 * @author PAMS
 */
public enum AdSubjectElectiveStatus {
    NONE, //0
    ENTREPRENEURSHIP,  //1
    FINANCE, //2
    MARKETING,  //3
    HUMAN_RESOURCE_MANAGEMENT, //4
    OTHERS; //5
	
    public static AdSubjectElectiveStatus get(int index) {
        return values()[index];
    }
}
