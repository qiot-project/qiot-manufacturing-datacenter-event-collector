package io.qiot.manufacturing.datacenter.eventcollector.service;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.AbstractTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.exception.telemetry.TelemetryTransformationException;

/**
 * @author andreabattaglia
 *
 * @param <M>
 */
public abstract class AbstractTelemetryStreamConsumer<M extends AbstractTelemetryDTO> {

    @Inject
    Logger LOGGER;

    @Inject
    ObjectMapper MAPPER;

    abstract void process(String telemetryJson)
            throws TelemetryTransformationException;

    abstract Class<M> getTelemetryClass();

    protected M deserialize(String telemetryJson)
            throws TelemetryTransformationException {

        M telemetry;
        try {
            telemetry = MAPPER.readValue(telemetryJson, getTelemetryClass());
        } catch (Exception e) {
            throw new TelemetryTransformationException(e);
        }
        return telemetry;
    }
}