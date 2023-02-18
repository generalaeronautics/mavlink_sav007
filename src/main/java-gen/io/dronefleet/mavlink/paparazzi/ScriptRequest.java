package io.dronefleet.mavlink.paparazzi;

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
 * Request script item with the sequence number seq. The response of the system to this message 
 * should be a {@link io.dronefleet.mavlink.paparazzi.ScriptItem SCRIPT_ITEM} message. 
 */
@MavlinkMessageInfo(
        id = 181,
        crc = 129,
        description = "Request script item with the sequence number seq. The response of the system to this message should be a SCRIPT_ITEM message."
)
public final class ScriptRequest {
    private final int targetSystem;

    private final int targetComponent;

    private final int seq;

    private ScriptRequest(int targetSystem, int targetComponent, int seq) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.seq = seq;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Sequence"
    )
    public final int seq() {
        return this.seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ScriptRequest other = (ScriptRequest)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(seq);
        return result;
    }

    @Override
    public String toString() {
        return "ScriptRequest{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seq=" + seq + "}";
    }

    public static ScriptRequest deserialize(ByteBuffer input) {
        int seq = PayloadFieldDecoder.decodeUint16(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        return new ScriptRequest(targetSystem, targetComponent, seq);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int seq;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Sequence 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Sequence"
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        public final ScriptRequest build() {
            return new ScriptRequest(targetSystem, targetComponent, seq);
        }
    }
}
