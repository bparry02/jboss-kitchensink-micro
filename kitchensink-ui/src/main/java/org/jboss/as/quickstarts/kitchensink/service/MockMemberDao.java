package org.jboss.as.quickstarts.kitchensink.service;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;

import org.jboss.as.quickstarts.kitchensink.model.Member;

@Alternative
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
		LOG.info("Returning empty list of Members");
		return Collections.emptyList();
	}

}
