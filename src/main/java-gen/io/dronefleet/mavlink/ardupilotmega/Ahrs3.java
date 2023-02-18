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
 * Status of third {@link io.dronefleet.mavlink.ardupilotmega.Ahrs AHRS} filter if available. This is for ANU research group (Ali and Sean). 
 */
@MavlinkMessageInfo(
        id = 182,
        crc = 229,
        description = "Status of third AHRS filter if available. This is for ANU research group (Ali and Sean)."
)
public final class Ahrs3 {
    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float altitude;

    private final int lat;

    private final int lng;

    private final float v1;

    private final float v2;

    private final float v3;

    private final float v4;

    private Ahrs3(float roll, float pitch, float yaw, float altitude, int lat, int lng, float v1,
            float v2, float v3, float v4) {
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.altitude = altitude;
        this.lat = lat;
        this.lng = lng;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Roll angle. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Roll angle."
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch angle. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Pitch angle."
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Yaw angle."
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Altitude (MSL). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Altitude (MSL)."
    )
    public final float altitude() {
        return this.altitude;
    }

    /**
     * Latitude. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Latitude."
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Longitude."
    )
    public final int lng() {
        return this.lng;
    }

    /**
     * Test variable1. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Test variable1."
    )
    public final float v1() {
        return this.v1;
    }

    /**
     * Test variable2. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Test variable2."
    )
    public final float v2() {
        return this.v2;
    }

    /**
     * Test variable3. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Test variable3."
    )
    public final float v3() {
        return this.v3;
    }

    /**
     * Test variable4. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Test variable4."
    )
    public final float v4() {
        return this.v4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Ahrs3 other = (Ahrs3)o;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lng, other.lng)) return false;
        if (!Objects.deepEquals(v1, other.v1)) return false;
        if (!Objects.deepEquals(v2, other.v2)) return false;
        if (!Objects.deepEquals(v3, other.v3)) return false;
        if (!Objects.deepEquals(v4, other.v4)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lng);
        result = 31 * result + Objects.hashCode(v1);
        result = 31 * result + Objects.hashCode(v2);
        result = 31 * result + Objects.hashCode(v3);
        result = 31 * result + Objects.hashCode(v4);
        return result;
    }

    @Override
    public String toString() {
        return "Ahrs3{roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", altitude=" + altitude
                 + ", lat=" + lat
                 + ", lng=" + lng
                 + ", v1=" + v1
                 + ", v2=" + v2
                 + ", v3=" + v3
                 + ", v4=" + v4 + "}";
    }

    public static Ahrs3 deserialize(ByteBuffer input) {
        float roll = PayloadFieldDecoder.decodeFloat(input);
        float pitch = PayloadFieldDecoder.decodeFloat(input);
        float yaw = PayloadFieldDecoder.decodeFloat(input);
        float altitude = PayloadFieldDecoder.decodeFloat(input);
        int lat = PayloadFieldDecoder.decodeInt32(input);
        int lng = PayloadFieldDecoder.decodeInt32(input);
        float v1 = PayloadFieldDecoder.decodeFloat(input);
        float v2 = PayloadFieldDecoder.decodeFloat(input);
        float v3 = PayloadFieldDecoder.decodeFloat(input);
        float v4 = PayloadFieldDecoder.decodeFloat(input);
        return new Ahrs3(roll, pitch, yaw, altitude, lat, lng, v1, v2, v3, v4);
    }

    public static final class Builder {
        private float roll;

        private float pitch;

        private float yaw;

        private float altitude;

        private int lat;

        private int lng;

        private float v1;

        private float v2;

        private float v3;

        private float v4;

        /**
         * Roll angle. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Roll angle."
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Pitch angle."
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Yaw angle."
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Altitude (MSL). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Altitude (MSL)."
        )
        public final Builder altitude(float altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Latitude. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Latitude."
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Longitude."
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Test variable1. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Test variable1."
        )
        public final Builder v1(float v1) {
            this.v1 = v1;
            return this;
        }

        /**
         * Test variable2. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Test variable2."
        )
        public final Builder v2(float v2) {
            this.v2 = v2;
            return this;
        }

        /**
         * Test variable3. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Test variable3."
        )
        public final Builder v3(float v3) {
            this.v3 = v3;
            return this;
        }

        /**
         * Test variable4. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Test variable4."
        )
        public final Builder v4(float v4) {
            this.v4 = v4;
            return this;
        }

        public final Ahrs3 build() {
            return new Ahrs3(roll, pitch, yaw, altitude, lat, lng, v1, v2, v3, v4);
        }
    }
}
