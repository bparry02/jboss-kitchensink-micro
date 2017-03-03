package org.jboss.as.quickstarts.kitchensink.service;

import java.util.List;
import java.util.logging.Logger;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public class MockMemberDao implements MemberDao {

	private static final Logger LOG = Logger.getLogger(MockMemberDao.class.getName()); 
	
	@Override
	public void register(Member member) throws Exception {
		LOG.info("Received Member: "+ member.getName());
	}

	@Override
	public Member findById(Long id) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public Member findByEmail(String email) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public List<Member> findAllOrderedByName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
