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
 * Request a chunk of a log 
 */
@MavlinkMessageInfo(
        id = 119,
        crc = 116,
        description = "Request a chunk of a log"
)
public final class LogRequestData {
    private final int targetSystem;

    private final int targetComponent;

    private final int id;

    private final long ofs;

    private final long count;

    private LogRequestData(int targetSystem, int targetComponent, int id, long ofs, long count) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.id = id;
        this.ofs = ofs;
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
     * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LOG_ENTRY} reply) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Log id (from LOG_ENTRY reply)"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Offset into the log 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Offset into the log"
    )
    public final long ofs() {
        return this.ofs;
    }

    /**
     * Number of bytes 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Number of bytes"
    )
    public final long count() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LogRequestData other = (LogRequestData)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(ofs, other.ofs)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(ofs);
        result = 31 * result + Objects.hashCode(count);
        return result;
    }

    @Override
    public String toString() {
        return "LogRequestData{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", id=" + id
                 + ", ofs=" + ofs
                 + ", count=" + count + "}";
    }

    public static LogRequestData deserialize(ByteBuffer input) {
        long ofs = PayloadFieldDecoder.decodeUint32(input);
        long count = PayloadFieldDecoder.decodeUint32(input);
        int id = PayloadFieldDecoder.decodeUint16(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        return new LogRequestData(targetSystem, targetComponent, id, ofs, count);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int id;

        private long ofs;

        private long count;

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
         * Log id (from {@link io.dronefleet.mavlink.common.LogEntry LOG_ENTRY} reply) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Log id (from LOG_ENTRY reply)"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Offset into the log 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Offset into the log"
        )
        public final Builder ofs(long ofs) {
            this.ofs = ofs;
            return this;
        }

        /**
         * Number of bytes 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Number of bytes"
        )
        public final Builder count(long count) {
            this.count = count;
            return this;
        }

        public final LogRequestData build() {
            return new LogRequestData(targetSystem, targetComponent, id, ofs, count);
        }
    }
}
