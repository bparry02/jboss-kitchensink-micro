package org.jboss.as.quickstarts.kitchensink.service;

import java.util.logging.Logger;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public class MockMemberRegistration implements MemberRegistration {

	private static final Logger LOG = Logger.getLogger(MockMemberRegistration.class.getName()); 
	
	@Override
	public void register(Member member) throws Exception {
		LOG.info("Received Member: "+ member.getName());
	}

}
