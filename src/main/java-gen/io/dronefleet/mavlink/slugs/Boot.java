package io.dronefleet.mavlink.slugs;

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
 * The boot message indicates that a system is starting. The onboard software version allows to 
 * keep track of onboard soft/firmware revisions. This message allows the sensor and control 
 * MCUs to communicate version numbers on startup. 
 */
@MavlinkMessageInfo(
        id = 197,
        crc = 39,
        description = "The boot message indicates that a system is starting. The onboard software version allows to keep track of onboard soft/firmware revisions. This message allows the sensor and control MCUs to communicate version numbers on startup."
)
public final class Boot {
    private final long version;

    private Boot(long version) {
        this.version = version;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The onboard software version 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "The onboard software version"
    )
    public final long version() {
        return this.version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Boot other = (Boot)o;
        if (!Objects.deepEquals(version, other.version)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(version);
        return result;
    }

    @Override
    public String toString() {
        return "Boot{version=" + version + "}";
    }

    public static Boot deserialize(ByteBuffer input) {
        long version = PayloadFieldDecoder.decodeUint32(input);
        return new Boot(version);
    }

    public static final class Builder {
        private long version;

        /**
         * The onboard software version 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "The onboard software version"
        )
        public final Builder version(long version) {
            this.version = version;
            return this;
        }

        public final Boot build() {
            return new Boot(version);
        }
    }
}
