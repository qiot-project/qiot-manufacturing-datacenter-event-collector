/**
 * 
 */
package io.qiot.manufacturing.datacenter.eventcollector.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.production.StageProductionValidationTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.exception.DataServiceException;
import io.qiot.manufacturing.datacenter.commons.service.persistence.events.TimeseriesRepository;

/**
 * @author andreabattaglia
 *
 */
@ApplicationScoped
public class DataStoreServiceImpl {
    @Inject
    Logger LOGGER;

    @Inject
    TimeseriesRepository<StageProductionValidationTelemetryDTO> repository;

    void handleIncomingMessage(
            @Observes StageProductionValidationTelemetryDTO pm)
            throws DataServiceException {
        LOGGER.info("Received internal event with content {}", pm);
        repository.save(pm);
    }
}
