package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * Publishes the GPS coordinates of the vehicle local origin (0,0,0) position. Emitted whenever 
 * a new GPS-Local position mapping is requested or set - e.g. following {@link io.dronefleet.mavlink.common.SetGpsGlobalOrigin SET_GPS_GLOBAL_ORIGIN} 
 * message. 
 */
@MavlinkMessageInfo(
        id = 49,
        crc = 39,
        description = "Publishes the GPS coordinates of the vehicle local origin (0,0,0) position. Emitted whenever a new GPS-Local position mapping is requested or set - e.g. following SET_GPS_GLOBAL_ORIGIN message."
)
public final class GpsGlobalOrigin {
    private final int latitude;

    private final int longitude;

    private final int altitude;

    private final BigInteger timeUsec;

    private GpsGlobalOrigin(int latitude, int longitude, int altitude, BigInteger timeUsec) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timeUsec = timeUsec;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Latitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            signed = true,
            description = "Latitude (WGS84)"
    )
    public final int latitude() {
        return this.latitude;
    }

    /**
     * Longitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Longitude (WGS84)"
    )
    public final int longitude() {
        return this.longitude;
    }

    /**
     * Altitude (MSL). Positive for up. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL). Positive for up."
    )
    public final int altitude() {
        return this.altitude;
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 8,
            extension = true,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GpsGlobalOrigin other = (GpsGlobalOrigin)o;
        if (!Objects.deepEquals(latitude, other.latitude)) return false;
        if (!Objects.deepEquals(longitude, other.longitude)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(latitude);
        result = 31 * result + Objects.hashCode(longitude);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(timeUsec);
        return result;
    }

    @Override
    public String toString() {
        return "GpsGlobalOrigin{latitude=" + latitude
                 + ", longitude=" + longitude
                 + ", altitude=" + altitude
                 + ", timeUsec=" + timeUsec + "}";
    }

    public static GpsGlobalOrigin deserialize(ByteBuffer input) {
        int latitude = PayloadFieldDecoder.decodeInt32(input);
        int longitude = PayloadFieldDecoder.decodeInt32(input);
        int altitude = PayloadFieldDecoder.decodeInt32(input);
        BigInteger timeUsec = PayloadFieldDecoder.decodeUint64(input);
        return new GpsGlobalOrigin(latitude, longitude, altitude, timeUsec);
    }

    public static final class Builder {
        private int latitude;

        private int longitude;

        private int altitude;

        private BigInteger timeUsec;

        /**
         * Latitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                signed = true,
                description = "Latitude (WGS84)"
        )
        public final Builder latitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Longitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Longitude (WGS84)"
        )
        public final Builder longitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Altitude (MSL). Positive for up. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL). Positive for up."
        )
        public final Builder altitude(int altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 8,
                extension = true,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        public final GpsGlobalOrigin build() {
            return new GpsGlobalOrigin(latitude, longitude, altitude, timeUsec);
        }
    }
}
