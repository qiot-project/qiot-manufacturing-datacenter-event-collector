package io.qiot.manufacturing.datacenter.eventcollector.domain;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.influxdb.annotations.Column;

import io.qiot.manufacturing.all.commons.domain.production.ProductionChainStageEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public abstract class AbstractValitationTelemetry {
    @Column(name = "factory_id", tag = true)
    public String factoryId;
    
    @Column(name = "machinery_id", tag = true)
    public String machineryId;
    
    @Column(name = "product_line_id", tag = true)
    public UUID productLineId;
    
    @Column(name = "item_id", tag = true)
    public int itemId;
    /*
     * not needed as we specialize by stage type
     */
//    @Column(name = "stage", tag = true)
//    public ProductionChainStageEnum stage;
    
    @JsonProperty(value = "instant")
    @Column(timestamp = true)
    public Instant time;

    @Override
    public int hashCode() {
        return Objects.hash(factoryId, machineryId, itemId, productLineId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractValitationTelemetry other = (AbstractValitationTelemetry) obj;
        return Objects.equals(factoryId, other.factoryId)
                && Objects.equals(machineryId, other.machineryId)
                && itemId == other.itemId
                && Objects.equals(productLineId, other.productLineId);
    }

    

}
