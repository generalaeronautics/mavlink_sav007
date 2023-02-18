package io.dronefleet.mavlink.matrixpilot;

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
 * Acknowldge success or failure of a flexifunction command 
 */
@MavlinkMessageInfo(
        id = 158,
        crc = 208,
        description = "Acknowldge success or failure of a flexifunction command"
)
public final class FlexifunctionCommandAck {
    private final int commandType;

    private final int result;

    private FlexifunctionCommandAck(int commandType, int result) {
        this.commandType = commandType;
        this.result = result;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Command acknowledged 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "Command acknowledged"
    )
    public final int commandType() {
        return this.commandType;
    }

    /**
     * result of acknowledge 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "result of acknowledge"
    )
    public final int result() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FlexifunctionCommandAck other = (FlexifunctionCommandAck)o;
        if (!Objects.deepEquals(commandType, other.commandType)) return false;
        if (!Objects.deepEquals(result, other.result)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(commandType);
        result = 31 * result + Objects.hashCode(result);
        return result;
    }

    @Override
    public String toString() {
        return "FlexifunctionCommandAck{commandType=" + commandType
                 + ", result=" + result + "}";
    }

    public static FlexifunctionCommandAck deserialize(ByteBuffer input) {
        int commandType = PayloadFieldDecoder.decodeUint16(input);
        int result = PayloadFieldDecoder.decodeUint16(input);
        return new FlexifunctionCommandAck(commandType, result);
    }

    public static final class Builder {
        private int commandType;

        private int result;

        /**
         * Command acknowledged 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "Command acknowledged"
        )
        public final Builder commandType(int commandType) {
            this.commandType = commandType;
            return this;
        }

        /**
         * result of acknowledge 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "result of acknowledge"
        )
        public final Builder result(int result) {
            this.result = result;
            return this;
        }

        public final FlexifunctionCommandAck build() {
            return new FlexifunctionCommandAck(commandType, result);
        }
    }
}
