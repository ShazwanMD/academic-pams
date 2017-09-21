package my.edu.umk.pams.academic.identity.model;

public interface AdSponsor extends AdActor {
	
    String getSponsorNo();

    void setSponsorNo(String sponsorNo);

    AdSponsorType getSponsorType();

    void setSponsorType(AdSponsorType sponsorType);

}
