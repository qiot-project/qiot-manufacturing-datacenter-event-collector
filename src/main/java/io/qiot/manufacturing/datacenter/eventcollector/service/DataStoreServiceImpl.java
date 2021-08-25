/**
 * 
 */
package io.qiot.manufacturing.datacenter.eventcollector.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import io.qiot.manufacturing.datacenter.eventcollector.domain.PollutionTelemetry;
import io.qiot.manufacturing.datacenter.eventcollector.exception.DataServiceException;
import io.qiot.manufacturing.datacenter.eventcollector.persistence.RepositoryImpl;
import io.qiot.manufacturing.datacenter.eventcollector.pollution.util.event.MeasurementReceived;

/**
 * @author andreabattaglia
 *
 */
@ApplicationScoped
public class DataStoreServiceImpl {
    @Inject
    Logger LOGGER;

    @Inject
    RepositoryImpl repository;

    void HandleIncomingMessage(
            @Observes PollutionTelemetry pm)
            throws DataServiceException {
        LOGGER.info("Received internal event with content {}", pm);
        repository.save(pm);
    }
}
