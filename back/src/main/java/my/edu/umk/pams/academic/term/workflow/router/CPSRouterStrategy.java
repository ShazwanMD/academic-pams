package my.edu.umk.pams.academic.term.workflow.router;

import java.util.Arrays;
import java.util.List;

import my.edu.umk.pams.academic.common.router.RouterStrategySupport;

public class CPSRouterStrategy extends RouterStrategySupport {
	
	  public CPSRouterStrategy() {
	    }

	    @Override
	    public String findVerifierCandidate() {
	        return "GRP_KRN_ADM_CPS";  //cps-kerani
	    }

	    @Override
	    public List<String> findRegistererCandidates(){
	    	return Arrays.asList("GRP_PGW_ADM_CPS","GRP_ADM");
	    }
	    
	    @Override
	    public List<String> findVerifierCandidates(){
	    	return Arrays.asList("GRP_PGW_ADM_CPS","GRP_ADM");
	    }


}
