package my.edu.umk.pams.academic.common.router;

import java.math.BigDecimal;
import java.util.List;

public class RouterStrategySupport implements RouterStrategy {
	
    @Override
    public List<String> findVerifierCandidates() {
        return null;
    }
	
    @Override
    public List<String> findRegistererCandidates() {
        return null;
    }

	@Override
	public String findDrafterCandidate() {
		return null;
	}

	@Override
	public List<String> findDrafterCandidates() {
		return null;
	}

	@Override
	public String findDrafterCandidate(BigDecimal amount, Enum type) {
		return null;
	}

	@Override
	public List<String> findDrafterCandidates(BigDecimal amount, Enum type) {
		return null;
	}

	@Override
	public String findRequesterCandidate() {
		return null;
	}

	@Override
	public String findRequesterCandidate(BigDecimal amount, Enum type) {
		return null;
	}

	@Override
	public String findRegistererCandidate() {
		return null;
	}

	@Override
	public String findRegistererCandidate(BigDecimal amount, Enum Type) {
		return null;
	}

	@Override
	public String findVerifierCandidate() {
		return null;
	}

	@Override
	public String findUpperVerifierCandidate() {
		return null;
	}

	@Override
	public String findVerifierCandidate(BigDecimal amount) {
		return null;
	}

	@Override
	public String findUpperCheckerCandidate() {
		return null;
	}

	@Override
	public String findUpperCheckerCandidate(BigDecimal amount) {
		return null;
	}

	@Override
	public String findCheckerCandidate() {
		return null;
	}

	@Override
	public String findCheckerCandidate(BigDecimal amount) {
		return null;
	}

	@Override
	public String findQuerierCandidate() {
		return null;
	}

	@Override
	public String findUpperQuerierCandidate() {
		return null;
	}

	@Override
	public String findUpperQuerierCandidate(BigDecimal amount) {
		return null;
	}

	@Override
	public String findApproverCandidate() {
		return null;
	}

	@Override
	public String findApproverCandidate(BigDecimal amount) {
		return null;
	}

	@Override
	public String findPreparerCandidate() {
		return null;
	}

	@Override
	public List<String> findPreparerCandidates() {
		return null;
	}

	@Override
	public String findPreparerCandidate(BigDecimal amount, Enum type) {
		return null;
	}

	@Override
	public List<String> findPreparerCandidates(BigDecimal amount, Enum type) {
		return null;
	}

	@Override
	public String findEvaluatorCandidate() {
		return null;
	}

	@Override
	public String findEvaluatorCandidate(BigDecimal amount, Enum type) {
		return null;
	}

	@Override
	public String findSelectorCandidate() {
		return null;
	}


	
	
	
	

}
