package org.jboss.as.quickstarts.kitchensink.service;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public interface MemberDao {

	void register(Member member) throws Exception;

}