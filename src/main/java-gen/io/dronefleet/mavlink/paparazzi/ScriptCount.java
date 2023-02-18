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
 * This message is emitted as response to {@link io.dronefleet.mavlink.paparazzi.ScriptRequestList SCRIPT_REQUEST_LIST} by the MAV to get the number of 
 * mission scripts. 
 */
@MavlinkMessageInfo(
        id = 183,
        crc = 186,
        description = "This message is emitted as response to SCRIPT_REQUEST_LIST by the MAV to get the number of mission scripts."
)
public final class ScriptCount {
    private final int targetSystem;

    private final int targetComponent;

    private final int count;

    private ScriptCount(int targetSystem, int targetComponent, int count) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.count = count;
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
     * Number of script items in the sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Number of script items in the sequence"
    )
    public final int count() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ScriptCount other = (ScriptCount)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(count);
        return result;
    }

    @Override
    public String toString() {
        return "ScriptCount{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", count=" + count + "}";
    }

    public static ScriptCount deserialize(ByteBuffer input) {
        int count = PayloadFieldDecoder.decodeUint16(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        return new ScriptCount(targetSystem, targetComponent, count);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int count;

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
         * Number of script items in the sequence 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Number of script items in the sequence"
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        public final ScriptCount build() {
            return new ScriptCount(targetSystem, targetComponent, count);
        }
    }
}
