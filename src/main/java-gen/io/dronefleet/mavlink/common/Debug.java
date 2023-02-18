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
 * Send a debug value. The index is used to discriminate between values. These values show up in the 
 * plot of QGroundControl as {@link io.dronefleet.mavlink.common.Debug DEBUG} N. 
 */
@MavlinkMessageInfo(
        id = 254,
        crc = 46,
        description = "Send a debug value. The index is used to discriminate between values. These values show up in the plot of QGroundControl as DEBUG N."
)
public final class Debug {
    private final long timeBootMs;

    private final int ind;

    private final float value;

    private Debug(long timeBootMs, int ind, float value) {
        this.timeBootMs = timeBootMs;
        this.ind = ind;
        this.value = value;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * index of debug variable 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "index of debug variable"
    )
    public final int ind() {
        return this.ind;
    }

    /**
     * {@link io.dronefleet.mavlink.common.Debug DEBUG} value 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "DEBUG value"
    )
    public final float value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Debug other = (Debug)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(ind, other.ind)) return false;
        if (!Objects.deepEquals(value, other.value)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(ind);
        result = 31 * result + Objects.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "Debug{timeBootMs=" + timeBootMs
                 + ", ind=" + ind
                 + ", value=" + value + "}";
    }

    public static Debug deserialize(ByteBuffer input) {
        long timeBootMs = PayloadFieldDecoder.decodeUint32(input);
        float value = PayloadFieldDecoder.decodeFloat(input);
        int ind = PayloadFieldDecoder.decodeUint8(input);
        return new Debug(timeBootMs, ind, value);
    }

    public static final class Builder {
        private long timeBootMs;

        private int ind;

        private float value;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * index of debug variable 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "index of debug variable"
        )
        public final Builder ind(int ind) {
            this.ind = ind;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.Debug DEBUG} value 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "DEBUG value"
        )
        public final Builder value(float value) {
            this.value = value;
            return this;
        }

        public final Debug build() {
            return new Debug(timeBootMs, ind, value);
        }
    }
}
