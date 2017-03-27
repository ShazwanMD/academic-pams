package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdSite;

/**
 * @author PAMS
 */
public interface AdSiteOffering extends AdMetaObject {

    public AdSite getSite();

    void setSite(AdSite site);

    public AdProgram getProgram();

    void setProgram(AdProgram program);
}
