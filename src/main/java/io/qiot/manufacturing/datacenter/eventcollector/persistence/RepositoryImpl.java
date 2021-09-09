package io.qiot.manufacturing.datacenter.eventcollector.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import io.qiot.manufacturing.commons.service.persistence.events.AbstractTimeseriesRepository;
import io.qiot.manufacturing.datacenter.commons.domain.events.production.StageProductionValidationTelemetryDTO;
import io.quarkus.runtime.StartupEvent;

/**
 * The Class RepositoryImpl.
 */
@ApplicationScoped
public class RepositoryImpl extends
        AbstractTimeseriesRepository<StageProductionValidationTelemetryDTO> {

    @Inject
    Logger LOGGER;
    
    void onStart(@Observes StartupEvent ev) {
        super.onStart();
    }
    
    protected void onStop() {
        super.onStop();
    }
}