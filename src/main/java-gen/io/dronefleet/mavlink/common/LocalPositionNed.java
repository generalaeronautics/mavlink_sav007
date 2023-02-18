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
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate 
 * frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessageInfo(
        id = 32,
        crc = 185,
        description = "The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)"
)
public final class LocalPositionNed {
    private final long timeBootMs;

    private final float x;

    private final float y;

    private final float z;

    private final float vx;

    private final float vy;

    private final float vz;

    private LocalPositionNed(long timeBootMs, float x, float y, float z, float vx, float vy,
            float vz) {
        this.timeBootMs = timeBootMs;
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
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
     * X Position 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "X Position"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Y Position"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Z Position"
    )
    public final float z() {
        return this.z;
    }

    /**
     * X Speed 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "X Speed"
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y Speed 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Y Speed"
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z Speed 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Z Speed"
    )
    public final float vz() {
        return this.vz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LocalPositionNed other = (LocalPositionNed)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(vx, other.vx)) return false;
        if (!Objects.deepEquals(vy, other.vy)) return false;
        if (!Objects.deepEquals(vz, other.vz)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(vx);
        result = 31 * result + Objects.hashCode(vy);
        result = 31 * result + Objects.hashCode(vz);
        return result;
    }

    @Override
    public String toString() {
        return "LocalPositionNed{timeBootMs=" + timeBootMs
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz + "}";
    }

    public static LocalPositionNed deserialize(ByteBuffer input) {
        long timeBootMs = PayloadFieldDecoder.decodeUint32(input);
        float x = PayloadFieldDecoder.decodeFloat(input);
        float y = PayloadFieldDecoder.decodeFloat(input);
        float z = PayloadFieldDecoder.decodeFloat(input);
        float vx = PayloadFieldDecoder.decodeFloat(input);
        float vy = PayloadFieldDecoder.decodeFloat(input);
        float vz = PayloadFieldDecoder.decodeFloat(input);
        return new LocalPositionNed(timeBootMs, x, y, z, vx, vy, vz);
    }

    public static final class Builder {
        private long timeBootMs;

        private float x;

        private float y;

        private float z;

        private float vx;

        private float vy;

        private float vz;

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
         * X Position 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "X Position"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Y Position"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Z Position"
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * X Speed 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "X Speed"
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y Speed 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Y Speed"
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z Speed 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Z Speed"
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        public final LocalPositionNed build() {
            return new LocalPositionNed(timeBootMs, x, y, z, vx, vy, vz);
        }
    }
}
