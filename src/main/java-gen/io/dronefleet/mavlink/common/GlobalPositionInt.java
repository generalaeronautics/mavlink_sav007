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
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in 
 * GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the 
 * resolution of float is not sufficient. 
 */
@MavlinkMessageInfo(
        id = 33,
        crc = 104,
        description = "The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It\n"
                        + "               is designed as scaled integer message since the resolution of float is not sufficient."
)
public final class GlobalPositionInt {
    private final long timeBootMs;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int relativeAlt;

    private final int vx;

    private final int vy;

    private final int vz;

    private final int hdg;

    private GlobalPositionInt(long timeBootMs, int lat, int lon, int alt, int relativeAlt, int vx,
            int vy, int vz, int hdg) {
        this.timeBootMs = timeBootMs;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.relativeAlt = relativeAlt;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.hdg = hdg;
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
     * Latitude, expressed 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Latitude, expressed"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude, expressed 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Longitude, expressed"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL."
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * Altitude above ground 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Altitude above ground"
    )
    public final int relativeAlt() {
        return this.relativeAlt;
    }

    /**
     * Ground X Speed (Latitude, positive north) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "Ground X Speed (Latitude, positive north)"
    )
    public final int vx() {
        return this.vx;
    }

    /**
     * Ground Y Speed (Longitude, positive east) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Ground Y Speed (Longitude, positive east)"
    )
    public final int vy() {
        return this.vy;
    }

    /**
     * Ground Z Speed (Altitude, positive down) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "Ground Z Speed (Altitude, positive down)"
    )
    public final int vz() {
        return this.vz;
    }

    /**
     * Vehicle heading (yaw angle), 0.0..359.99 degrees. If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Vehicle heading (yaw angle), 0.0..359.99 degrees. If unknown, set to: UINT16_MAX"
    )
    public final int hdg() {
        return this.hdg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GlobalPositionInt other = (GlobalPositionInt)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(relativeAlt, other.relativeAlt)) return false;
        if (!Objects.deepEquals(vx, other.vx)) return false;
        if (!Objects.deepEquals(vy, other.vy)) return false;
        if (!Objects.deepEquals(vz, other.vz)) return false;
        if (!Objects.deepEquals(hdg, other.hdg)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(relativeAlt);
        result = 31 * result + Objects.hashCode(vx);
        result = 31 * result + Objects.hashCode(vy);
        result = 31 * result + Objects.hashCode(vz);
        result = 31 * result + Objects.hashCode(hdg);
        return result;
    }

    @Override
    public String toString() {
        return "GlobalPositionInt{timeBootMs=" + timeBootMs
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", relativeAlt=" + relativeAlt
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz
                 + ", hdg=" + hdg + "}";
    }

    public static GlobalPositionInt deserialize(ByteBuffer input) {
        long timeBootMs = PayloadFieldDecoder.decodeUint32(input);
        int lat = PayloadFieldDecoder.decodeInt32(input);
        int lon = PayloadFieldDecoder.decodeInt32(input);
        int alt = PayloadFieldDecoder.decodeInt32(input);
        int relativeAlt = PayloadFieldDecoder.decodeInt32(input);
        int vx = PayloadFieldDecoder.decodeInt16(input);
        int vy = PayloadFieldDecoder.decodeInt16(input);
        int vz = PayloadFieldDecoder.decodeInt16(input);
        int hdg = PayloadFieldDecoder.decodeUint16(input);
        return new GlobalPositionInt(timeBootMs, lat, lon, alt, relativeAlt, vx, vy, vz, hdg);
    }

    public static final class Builder {
        private long timeBootMs;

        private int lat;

        private int lon;

        private int alt;

        private int relativeAlt;

        private int vx;

        private int vy;

        private int vz;

        private int hdg;

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
         * Latitude, expressed 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Latitude, expressed"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude, expressed 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Longitude, expressed"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL."
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Altitude above ground 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Altitude above ground"
        )
        public final Builder relativeAlt(int relativeAlt) {
            this.relativeAlt = relativeAlt;
            return this;
        }

        /**
         * Ground X Speed (Latitude, positive north) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "Ground X Speed (Latitude, positive north)"
        )
        public final Builder vx(int vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Ground Y Speed (Longitude, positive east) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Ground Y Speed (Longitude, positive east)"
        )
        public final Builder vy(int vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Ground Z Speed (Altitude, positive down) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "Ground Z Speed (Altitude, positive down)"
        )
        public final Builder vz(int vz) {
            this.vz = vz;
            return this;
        }

        /**
         * Vehicle heading (yaw angle), 0.0..359.99 degrees. If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Vehicle heading (yaw angle), 0.0..359.99 degrees. If unknown, set to: UINT16_MAX"
        )
        public final Builder hdg(int hdg) {
            this.hdg = hdg;
            return this;
        }

        public final GlobalPositionInt build() {
            return new GlobalPositionInt(timeBootMs, lat, lon, alt, relativeAlt, vx, vy, vz, hdg);
        }
    }
}
