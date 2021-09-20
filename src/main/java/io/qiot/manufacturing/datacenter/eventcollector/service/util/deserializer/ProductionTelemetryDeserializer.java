package io.qiot.manufacturing.datacenter.eventcollector.service.util.deserializer;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.production.StageProductionValidationTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.util.serializer.AbstractTelemetryDeserializer;

/**
 * @author andreabattaglia
 *
 */
public class ProductionTelemetryDeserializer extends
        AbstractTelemetryDeserializer<StageProductionValidationTelemetryDTO> {
    public ProductionTelemetryDeserializer() {
        super(StageProductionValidationTelemetryDTO.class);
    }

}
