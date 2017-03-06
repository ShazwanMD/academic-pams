package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdSiteOffering extends AdMetaObject {

    public AdSite getSite();

    void setSite(AdSite site);

    public AdProgram getProgram();

    void setProgram(AdProgram program);
}
