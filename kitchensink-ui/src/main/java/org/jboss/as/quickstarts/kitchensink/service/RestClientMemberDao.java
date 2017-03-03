package org.jboss.as.quickstarts.kitchensink.service;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

@ApplicationScoped
public class RestClientMemberDao implements MemberDao {

	private static final Logger LOG = Logger.getLogger(RestClientMemberDao.class.getName());

	private String kitchenSinkServiceUrl;

	@PostConstruct
	private void init() {
		// bootstrap Resteasy client
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());

		kitchenSinkServiceUrl = resolveKitchensinkServiceUrl();
	}

	private String resolveKitchensinkServiceUrl() {
		String host = null;

		host = System.getenv("KITCHENSINK_SVC_HOST");

		if (host == null || host.isEmpty()) {
			host = System.getProperty("kitchensink.svc.host", "localhost:8080/jboss-kitchensink-data");
		}

		String url = String.format("http://%s/rest", host);
		LOG.info("Setting KitchenSink Service url to: " + url);

		return url;
	}

	@Override
	public void register(Member member) throws Exception {
		throw new UnsupportedOperationException("Not yet implemented");
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
		KitchensinkServiceClient client = ProxyFactory.create(KitchensinkServiceClient.class, kitchenSinkServiceUrl);
		List<Member> members = client.getAllMembers();

		return members;
	}

	private static interface KitchensinkServiceClient {
		@GET
		@Path("/members")
		@Produces(MediaType.APPLICATION_JSON)
		List<Member> getAllMembers();
	}
}
