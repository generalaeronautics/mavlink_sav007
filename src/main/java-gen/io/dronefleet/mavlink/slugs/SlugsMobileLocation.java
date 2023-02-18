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
 * Transmits the last known position of the mobile GS to the UAV. Very relevant when Track Mobile is 
 * enabled 
 */
@MavlinkMessageInfo(
        id = 186,
        crc = 101,
        description = "Transmits the last known position of the mobile GS to the UAV. Very relevant when Track Mobile is enabled"
)
public final class SlugsMobileLocation {
    private final int target;

    private final float latitude;

    private final float longitude;

    private SlugsMobileLocation(int target, float latitude, float longitude) {
        this.target = target;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system reporting the action 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "The system reporting the action"
    )
    public final int target() {
        return this.target;
    }

    /**
     * Mobile Latitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Mobile Latitude"
    )
    public final float latitude() {
        return this.latitude;
    }

    /**
     * Mobile Longitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Mobile Longitude"
    )
    public final float longitude() {
        return this.longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SlugsMobileLocation other = (SlugsMobileLocation)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(latitude, other.latitude)) return false;
        if (!Objects.deepEquals(longitude, other.longitude)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(latitude);
        result = 31 * result + Objects.hashCode(longitude);
        return result;
    }

    @Override
    public String toString() {
        return "SlugsMobileLocation{target=" + target
                 + ", latitude=" + latitude
                 + ", longitude=" + longitude + "}";
    }

    public static SlugsMobileLocation deserialize(ByteBuffer input) {
        float latitude = PayloadFieldDecoder.decodeFloat(input);
        float longitude = PayloadFieldDecoder.decodeFloat(input);
        int target = PayloadFieldDecoder.decodeUint8(input);
        return new SlugsMobileLocation(target, latitude, longitude);
    }

    public static final class Builder {
        private int target;

        private float latitude;

        private float longitude;

        /**
         * The system reporting the action 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "The system reporting the action"
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * Mobile Latitude 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Mobile Latitude"
        )
        public final Builder latitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Mobile Longitude 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Mobile Longitude"
        )
        public final Builder longitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        public final SlugsMobileLocation build() {
            return new SlugsMobileLocation(target, latitude, longitude);
        }
    }
}
