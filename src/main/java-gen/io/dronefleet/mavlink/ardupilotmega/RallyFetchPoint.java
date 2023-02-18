package io.dronefleet.mavlink.ardupilotmega;

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
 * Request a current rally point from MAV. MAV should respond with a {@link io.dronefleet.mavlink.ardupilotmega.RallyPoint RALLY_POINT} message. MAV 
 * should not respond if the request is invalid. 
 */
@MavlinkMessageInfo(
        id = 176,
        crc = 234,
        description = "Request a current rally point from MAV. MAV should respond with a RALLY_POINT message. MAV should not respond if the request is invalid."
)
public final class RallyFetchPoint {
    private final int targetSystem;

    private final int targetComponent;

    private final int idx;

    private RallyFetchPoint(int targetSystem, int targetComponent, int idx) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idx = idx;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Point index (first point is 0). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Point index (first point is 0)."
    )
    public final int idx() {
        return this.idx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RallyFetchPoint other = (RallyFetchPoint)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idx, other.idx)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idx);
        return result;
    }

    @Override
    public String toString() {
        return "RallyFetchPoint{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idx=" + idx + "}";
    }

    public static RallyFetchPoint deserialize(ByteBuffer input) {
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        int idx = PayloadFieldDecoder.decodeUint8(input);
        return new RallyFetchPoint(targetSystem, targetComponent, idx);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int idx;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Point index (first point is 0). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Point index (first point is 0)."
        )
        public final Builder idx(int idx) {
            this.idx = idx;
            return this;
        }

        public final RallyFetchPoint build() {
            return new RallyFetchPoint(targetSystem, targetComponent, idx);
        }
    }
}
