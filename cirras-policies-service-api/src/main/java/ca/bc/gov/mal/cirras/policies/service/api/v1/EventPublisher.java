package ca.bc.gov.mal.cirras.policies.service.api.v1;

import java.util.Map;

public interface EventPublisher {

	public void publish(
			String eventType, 
			Object resourceBeforeUpdate, 
			Object resourceAfterUpdate,
			Map<String, String> sourceIdentifiers)
		throws EventPublisherException;
}

