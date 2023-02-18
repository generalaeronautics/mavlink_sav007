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
 * Send a key-value pair as float. The use of this message is discouraged for normal packets, but a 
 * quite efficient way for testing new messages and getting experimental debug output. 
 */
@MavlinkMessageInfo(
        id = 251,
        crc = 170,
        description = "Send a key-value pair as float. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output."
)
public final class NamedValueFloat {
    private final long timeBootMs;

    private final String name;

    private final float value;

    private NamedValueFloat(long timeBootMs, String name, float value) {
        this.timeBootMs = timeBootMs;
        this.name = name;
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
     * Name of the debug variable 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 10,
            description = "Name of the debug variable"
    )
    public final String name() {
        return this.name;
    }

    /**
     * Floating point value 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Floating point value"
    )
    public final float value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        NamedValueFloat other = (NamedValueFloat)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(name, other.name)) return false;
        if (!Objects.deepEquals(value, other.value)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "NamedValueFloat{timeBootMs=" + timeBootMs
                 + ", name=" + name
                 + ", value=" + value + "}";
    }

    public static NamedValueFloat deserialize(ByteBuffer input) {
        long timeBootMs = PayloadFieldDecoder.decodeUint32(input);
        float value = PayloadFieldDecoder.decodeFloat(input);
        String name = PayloadFieldDecoder.decodeString(input, 10);
        return new NamedValueFloat(timeBootMs, name, value);
    }

    public static final class Builder {
        private long timeBootMs;

        private String name;

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
         * Name of the debug variable 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 10,
                description = "Name of the debug variable"
        )
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Floating point value 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Floating point value"
        )
        public final Builder value(float value) {
            this.value = value;
            return this;
        }

        public final NamedValueFloat build() {
            return new NamedValueFloat(timeBootMs, name, value);
        }
    }
}
