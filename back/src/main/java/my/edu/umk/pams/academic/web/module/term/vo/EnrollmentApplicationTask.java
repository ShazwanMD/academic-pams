package my.edu.umk.pams.academic.web.module.term.vo;


import my.edu.umk.pams.academic.web.module.core.vo.Task;

/**
 * @author PAMS
 */
public class EnrollmentApplicationTask extends Task {

    private EnrollmentApplication application;

    public EnrollmentApplication getApplication() {
        return application;
    }

    public void setApplication(EnrollmentApplication application) {
        this.application = application;
    }
}
