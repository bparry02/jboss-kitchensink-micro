package org.jboss.as.quickstarts.kitchensink.service;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public interface MemberRegistration {

	void register(Member member) throws Exception;

}