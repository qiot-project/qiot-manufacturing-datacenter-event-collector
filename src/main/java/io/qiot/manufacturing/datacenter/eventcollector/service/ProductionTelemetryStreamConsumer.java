package io.qiot.manufacturing.datacenter.eventcollector.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.qiot.manufacturing.datacenter.commons.domain.events.production.StageProductionValidationTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.exception.telemetry.TelemetryDataValidationException;

@ApplicationScoped
public class ProductionTelemetryStreamConsumer {

    @Inject
    Logger LOGGER;

    @Inject
    ObjectMapper MAPPER;

    @Inject
    Event<StageProductionValidationTelemetryDTO> measurementReceivedEvent;

    // @Incoming("pollution")
    // public void process(String data) throws TelemetryDataValidationException
    // {
    // LOGGER.info("Consumed message {} from the POLLUTION Stream", data);
    // // PollutionTelemetry gm = converter.jsonToMeasurement(data);
    // PollutionTelemetry pm;
    // try {
    // pm = MAPPER.readValue(data, PollutionTelemetry.class);
    // } catch (Exception e) {
    // throw new TelemetryDataValidationException(e);
    // }
    // measurementReceivedEvent.fire(pm);
    // }

    @Incoming("telemetryproduction")
    public void process(StageProductionValidationTelemetryDTO data)
            throws TelemetryDataValidationException {
        LOGGER.info("Consumed message {} from the Prosuction Telemetry Stream",
                data);
        measurementReceivedEvent.fire(data);
    }
}
