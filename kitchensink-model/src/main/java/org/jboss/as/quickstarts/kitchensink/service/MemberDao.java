package org.jboss.as.quickstarts.kitchensink.service;

import java.util.List;

import org.jboss.as.quickstarts.kitchensink.model.Member;

public interface MemberDao {

	void register(Member member) throws Exception;

	Member findById(Long id);

	Member findByEmail(String email);

	List<Member> findAllOrderedByName();

}