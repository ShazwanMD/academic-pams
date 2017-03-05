package my.edu.umk.pams.academic.core;

/**
 * @author canang technologies
 * @since 4/2/2016.
 */
public interface AdFlowObject extends AdMetaObject {
    /**
     * get flow data
     *
     * @return
     */
    AdFlowdata getFlowdata();

    /**
     * set flow data
     *
     * @param flowdata
     */
    void setFlowdata(AdFlowdata flowdata);

}
