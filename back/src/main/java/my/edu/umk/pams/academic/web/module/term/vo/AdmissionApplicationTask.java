package my.edu.umk.pams.academic.web.module.term.vo;


import my.edu.umk.pams.academic.web.module.core.vo.Task;

/**
 * @author PAMS
 */
public class AdmissionApplicationTask extends Task {

    private AdmissionApplication application;

    public AdmissionApplication getApplication() {
        return application;
    }

    public void setApplication(AdmissionApplication application) {
        this.application = application;
    }
}
