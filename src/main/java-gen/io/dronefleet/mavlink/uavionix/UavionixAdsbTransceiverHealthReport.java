package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Objects;

/**
 * Transceiver heartbeat with health report (updated every 10s) 
 */
@MavlinkMessageInfo(
        id = 10003,
        crc = 4,
        description = "Transceiver heartbeat with health report (updated every 10s)"
)
public final class UavionixAdsbTransceiverHealthReport {
    private final EnumValue<UavionixAdsbRfHealth> rfhealth;

    private UavionixAdsbTransceiverHealthReport(EnumValue<UavionixAdsbRfHealth> rfhealth) {
        this.rfhealth = rfhealth;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * ADS-B transponder messages 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = UavionixAdsbRfHealth.class,
            description = "ADS-B transponder messages"
    )
    public final EnumValue<UavionixAdsbRfHealth> rfhealth() {
        return this.rfhealth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        UavionixAdsbTransceiverHealthReport other = (UavionixAdsbTransceiverHealthReport)o;
        if (!Objects.deepEquals(rfhealth, other.rfhealth)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(rfhealth);
        return result;
    }

    @Override
    public String toString() {
        return "UavionixAdsbTransceiverHealthReport{rfhealth=" + rfhealth + "}";
    }

    public static UavionixAdsbTransceiverHealthReport deserialize(ByteBuffer input) {
        EnumValue<UavionixAdsbRfHealth> rfhealth = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.uavionix.UavionixAdsbRfHealth.class, input, 1);
        return new UavionixAdsbTransceiverHealthReport(rfhealth);
    }

    public static final class Builder {
        private EnumValue<UavionixAdsbRfHealth> rfhealth;

        /**
         * ADS-B transponder messages 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = UavionixAdsbRfHealth.class,
                description = "ADS-B transponder messages"
        )
        public final Builder rfhealth(EnumValue<UavionixAdsbRfHealth> rfhealth) {
            this.rfhealth = rfhealth;
            return this;
        }

        /**
         * ADS-B transponder messages 
         */
        public final Builder rfhealth(UavionixAdsbRfHealth entry) {
            return rfhealth(EnumValue.of(entry));
        }

        /**
         * ADS-B transponder messages 
         */
        public final Builder rfhealth(Enum... flags) {
            return rfhealth(EnumValue.create(flags));
        }

        /**
         * ADS-B transponder messages 
         */
        public final Builder rfhealth(Collection<Enum> flags) {
            return rfhealth(EnumValue.create(flags));
        }

        public final UavionixAdsbTransceiverHealthReport build() {
            return new UavionixAdsbTransceiverHealthReport(rfhealth);
        }
    }
}
