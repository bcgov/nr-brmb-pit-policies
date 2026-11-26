package ca.bc.gov.mal.cirras.policies.api.rest.v1.spring;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.publisher.EventPublisherImpl;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.publisher.NatsAuthHandler;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.publisher.NatsConnectionListener;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.publisher.NatsErrorListener;
import ca.bc.gov.mal.cirras.policies.service.api.v1.EventPublisher;
import io.nats.client.Options;

@Configuration
public class EventPublisherSpringConfig  {

	private static final Logger logger = LoggerFactory.getLogger(EventPublisherSpringConfig.class);
	
	public EventPublisherSpringConfig() {
		logger.info("<EventPublisherSpringConfig");
		
		logger.info(">EventPublisherSpringConfig");
	}

	@Value("${message-queue.url}")
	private String natsURL;
	
	@Value("${message-queue.policies.rest.nkey.seed}")
	private String nkeySeed;
	
	@Bean 
	Options natsConnectionOptions() {

		logger.info("NATS Server URL: " + natsURL);
		
		NatsAuthHandler authHandler = new NatsAuthHandler(nkeySeed);
		NatsConnectionListener connListener = new NatsConnectionListener();
		NatsErrorListener errListener = new NatsErrorListener();

		Options.Builder builder = new Options.Builder()
                .server(natsURL)
                .connectionTimeout(Duration.ofSeconds(10))
                .pingInterval(Duration.ofSeconds(30))
                .reconnectWait(Duration.ofSeconds(5))
                .authHandler(authHandler)
                .connectionListener(connListener)
                .errorListener(errListener)
                .maxReconnects(3);
		
        Options options = builder.build();

        return options;

	}
	
	@Bean
	public EventPublisher eventPublisher() {
		EventPublisherImpl result;
		
		result = new EventPublisherImpl();
		result.setMessageQueueOptions(natsConnectionOptions());
		result.setMessageQueueSubject("policies-event-channel");
		
		return result;
	}
}
