package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * Accept / deny control of this MAV 
 */
@MavlinkMessageInfo(
        id = 6,
        crc = 104,
        description = "Accept / deny control of this MAV"
)
public final class ChangeOperatorControlAck {
    private final int gcsSystemId;

    private final int controlRequest;

    private final int ack;

    private ChangeOperatorControlAck(int gcsSystemId, int controlRequest, int ack) {
        this.gcsSystemId = gcsSystemId;
        this.controlRequest = controlRequest;
        this.ack = ack;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * ID of the GCS this message 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "ID of the GCS this message"
    )
    public final int gcsSystemId() {
        return this.gcsSystemId;
    }

    /**
     * 0: request control of this MAV, 1: Release control of this MAV 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "0: request control of this MAV, 1: Release control of this MAV"
    )
    public final int controlRequest() {
        return this.controlRequest;
    }

    /**
     * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: 
     * Already under control 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: Already under control"
    )
    public final int ack() {
        return this.ack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ChangeOperatorControlAck other = (ChangeOperatorControlAck)o;
        if (!Objects.deepEquals(gcsSystemId, other.gcsSystemId)) return false;
        if (!Objects.deepEquals(controlRequest, other.controlRequest)) return false;
        if (!Objects.deepEquals(ack, other.ack)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(gcsSystemId);
        result = 31 * result + Objects.hashCode(controlRequest);
        result = 31 * result + Objects.hashCode(ack);
        return result;
    }

    @Override
    public String toString() {
        return "ChangeOperatorControlAck{gcsSystemId=" + gcsSystemId
                 + ", controlRequest=" + controlRequest
                 + ", ack=" + ack + "}";
    }

    public static ChangeOperatorControlAck deserialize(ByteBuffer input) {
        int gcsSystemId = PayloadFieldDecoder.decodeUint8(input);
        int controlRequest = PayloadFieldDecoder.decodeUint8(input);
        int ack = PayloadFieldDecoder.decodeUint8(input);
        return new ChangeOperatorControlAck(gcsSystemId, controlRequest, ack);
    }

    public static final class Builder {
        private int gcsSystemId;

        private int controlRequest;

        private int ack;

        /**
         * ID of the GCS this message 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "ID of the GCS this message"
        )
        public final Builder gcsSystemId(int gcsSystemId) {
            this.gcsSystemId = gcsSystemId;
            return this;
        }

        /**
         * 0: request control of this MAV, 1: Release control of this MAV 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "0: request control of this MAV, 1: Release control of this MAV"
        )
        public final Builder controlRequest(int controlRequest) {
            this.controlRequest = controlRequest;
            return this;
        }

        /**
         * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: 
         * Already under control 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: Already under control"
        )
        public final Builder ack(int ack) {
            this.ack = ack;
            return this;
        }

        public final ChangeOperatorControlAck build() {
            return new ChangeOperatorControlAck(gcsSystemId, controlRequest, ack);
        }
    }
}
