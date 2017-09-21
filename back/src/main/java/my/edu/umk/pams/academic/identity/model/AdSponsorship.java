package my.edu.umk.pams.academic.identity.model;

import java.math.BigDecimal;
import java.util.Date;

import my.edu.umk.pams.academic.core.AdMetaObject;

public interface AdSponsorship extends AdMetaObject {
	
    String getReferenceNo();

    void setReferenceNo(String referenceNo);
    
    BigDecimal getAmount();

    void setAmount(BigDecimal amount);

    void setStartDate(Date startDate);

    Date getStartDate();
    
    void setEndDate(Date endDate);

    Date getEndDate();
    
    Boolean getActive();

	void setActive(Boolean active);

    AdSponsor getSponsor();
    
	void setSponsor(AdSponsor sponsor);
	
	AdStudent getStudent();
	
	void setStudent(AdStudent student);

}
