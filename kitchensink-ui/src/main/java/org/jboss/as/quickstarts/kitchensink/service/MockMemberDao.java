package org.jboss.as.quickstarts.kitchensink.service;

import java.util.logging.Logger;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public class MockMemberDao implements MemberDao {

	private static final Logger LOG = Logger.getLogger(MockMemberDao.class.getName()); 
	
	@Override
	public void register(Member member) throws Exception {
		LOG.info("Received Member: "+ member.getName());
	}

}
