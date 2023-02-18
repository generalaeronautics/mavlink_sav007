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
 * Transmits the actual Pan, Tilt and Zoom values of the camera unit 
 */
@MavlinkMessageInfo(
        id = 192,
        crc = 187,
        description = "Transmits the actual Pan, Tilt and Zoom values of the camera unit"
)
public final class PtzStatus {
    private final int zoom;

    private final int pan;

    private final int tilt;

    private PtzStatus(int zoom, int pan, int tilt) {
        this.zoom = zoom;
        this.pan = pan;
        this.tilt = tilt;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The actual Zoom Value 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "The actual Zoom Value"
    )
    public final int zoom() {
        return this.zoom;
    }

    /**
     * The Pan value in 10ths of degree 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "The Pan value in 10ths of degree"
    )
    public final int pan() {
        return this.pan;
    }

    /**
     * The Tilt value in 10ths of degree 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "The Tilt value in 10ths of degree"
    )
    public final int tilt() {
        return this.tilt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        PtzStatus other = (PtzStatus)o;
        if (!Objects.deepEquals(zoom, other.zoom)) return false;
        if (!Objects.deepEquals(pan, other.pan)) return false;
        if (!Objects.deepEquals(tilt, other.tilt)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(zoom);
        result = 31 * result + Objects.hashCode(pan);
        result = 31 * result + Objects.hashCode(tilt);
        return result;
    }

    @Override
    public String toString() {
        return "PtzStatus{zoom=" + zoom
                 + ", pan=" + pan
                 + ", tilt=" + tilt + "}";
    }

    public static PtzStatus deserialize(ByteBuffer input) {
        int pan = PayloadFieldDecoder.decodeInt16(input);
        int tilt = PayloadFieldDecoder.decodeInt16(input);
        int zoom = PayloadFieldDecoder.decodeUint8(input);
        return new PtzStatus(zoom, pan, tilt);
    }

    public static final class Builder {
        private int zoom;

        private int pan;

        private int tilt;

        /**
         * The actual Zoom Value 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "The actual Zoom Value"
        )
        public final Builder zoom(int zoom) {
            this.zoom = zoom;
            return this;
        }

        /**
         * The Pan value in 10ths of degree 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "The Pan value in 10ths of degree"
        )
        public final Builder pan(int pan) {
            this.pan = pan;
            return this;
        }

        /**
         * The Tilt value in 10ths of degree 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "The Tilt value in 10ths of degree"
        )
        public final Builder tilt(int tilt) {
            this.tilt = tilt;
            return this;
        }

        public final PtzStatus build() {
            return new PtzStatus(zoom, pan, tilt);
        }
    }
}
