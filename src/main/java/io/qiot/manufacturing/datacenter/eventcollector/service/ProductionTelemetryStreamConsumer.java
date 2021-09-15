package io.qiot.manufacturing.datacenter.eventcollector.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.production.StageProductionValidationTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.exception.telemetry.TelemetryTransformationException;

/**
 * @author andreabattaglia
 *
 */
@ApplicationScoped
public class ProductionTelemetryStreamConsumer extends
        AbstractTelemetryStreamConsumer<StageProductionValidationTelemetryDTO> {

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

    @Override
    @Incoming("telemetryproduction")
    public void process(String telemetryJson)
            throws TelemetryTransformationException {
        LOGGER.info("Consumed message {} from the Prosuction Telemetry Stream",
                telemetryJson);
        measurementReceivedEvent.fire(deserialize(telemetryJson));
    }

    @Override
    Class<StageProductionValidationTelemetryDTO> getTelemetryClass() {
        return StageProductionValidationTelemetryDTO.class;
    }
}
