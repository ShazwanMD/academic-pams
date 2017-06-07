package my.edu.umk.pams.academic.web.module.term.vo;


import my.edu.umk.pams.academic.web.module.core.vo.Task;

/**
 * @author PAMS
 */
public class EnrollmentApplicationTask extends Task {

    private EnrollmentApplication application;

    // denormalize
    private String matricNo;


    public EnrollmentApplication getApplication() {
        return application;
    }

    public void setApplication(EnrollmentApplication application) {
        this.application = application;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }
}
