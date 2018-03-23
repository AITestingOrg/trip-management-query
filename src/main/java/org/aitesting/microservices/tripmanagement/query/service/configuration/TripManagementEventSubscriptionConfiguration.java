package org.aitesting.microservices.tripmanagement.query.service.configuration;

import org.aist.libs.eventsourcing.configuration.configurations.AmqpEventSubscriptionConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TripManagementEventSubscriptionConfiguration extends AmqpEventSubscriptionConfiguration {
}
