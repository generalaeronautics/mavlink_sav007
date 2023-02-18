package io.dronefleet.mavlink.ardupilotmega;

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
 * Send Status of each log block that autopilot board might have sent. 
 */
@MavlinkMessageInfo(
        id = 185,
        crc = 186,
        description = "Send Status of each log block that autopilot board might have sent."
)
public final class RemoteLogBlockStatus {
    private final int targetSystem;

    private final int targetComponent;

    private final long seqno;

    private final EnumValue<MavRemoteLogDataBlockStatuses> status;

    private RemoteLogBlockStatus(int targetSystem, int targetComponent, long seqno,
            EnumValue<MavRemoteLogDataBlockStatuses> status) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.seqno = seqno;
        this.status = status;
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
     * Log data block sequence number. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Log data block sequence number."
    )
    public final long seqno() {
        return this.seqno;
    }

    /**
     * Log data block status. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavRemoteLogDataBlockStatuses.class,
            description = "Log data block status."
    )
    public final EnumValue<MavRemoteLogDataBlockStatuses> status() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RemoteLogBlockStatus other = (RemoteLogBlockStatus)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(seqno, other.seqno)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(seqno);
        result = 31 * result + Objects.hashCode(status);
        return result;
    }

    @Override
    public String toString() {
        return "RemoteLogBlockStatus{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", seqno=" + seqno
                 + ", status=" + status + "}";
    }

    public static RemoteLogBlockStatus deserialize(ByteBuffer input) {
        long seqno = PayloadFieldDecoder.decodeUint32(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        EnumValue<MavRemoteLogDataBlockStatuses> status = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.ardupilotmega.MavRemoteLogDataBlockStatuses.class, input, 1);
        return new RemoteLogBlockStatus(targetSystem, targetComponent, seqno, status);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long seqno;

        private EnumValue<MavRemoteLogDataBlockStatuses> status;

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
         * Log data block sequence number. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Log data block sequence number."
        )
        public final Builder seqno(long seqno) {
            this.seqno = seqno;
            return this;
        }

        /**
         * Log data block status. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavRemoteLogDataBlockStatuses.class,
                description = "Log data block status."
        )
        public final Builder status(EnumValue<MavRemoteLogDataBlockStatuses> status) {
            this.status = status;
            return this;
        }

        /**
         * Log data block status. 
         */
        public final Builder status(MavRemoteLogDataBlockStatuses entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Log data block status. 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Log data block status. 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        public final RemoteLogBlockStatus build() {
            return new RemoteLogBlockStatus(targetSystem, targetComponent, seqno, status);
        }
    }
}
