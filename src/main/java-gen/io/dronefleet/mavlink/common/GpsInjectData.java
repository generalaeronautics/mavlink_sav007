package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * Data for injecting into the onboard GPS (used for DGPS) 
 * @deprecated Since 2022-05, replaced by {@link io.dronefleet.mavlink.common.GpsRtcmData GPS_RTCM_DATA}. 
 */
@MavlinkMessageInfo(
        id = 123,
        crc = 250,
        description = "Data for injecting into the onboard GPS (used for DGPS)"
)
@Deprecated
public final class GpsInjectData {
    private final int targetSystem;

    private final int targetComponent;

    private final int len;

    private final byte[] data;

    private GpsInjectData(int targetSystem, int targetComponent, int len, byte[] data) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.len = len;
        this.data = data;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Data length 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Data length"
    )
    public final int len() {
        return this.len;
    }

    /**
     * Raw data (110 is enough for 12 satellites of RTCMv2) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 110,
            description = "Raw data (110 is enough for 12 satellites of RTCMv2)"
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GpsInjectData other = (GpsInjectData)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(len, other.len)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(len);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "GpsInjectData{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", len=" + len
                 + ", data=" + data + "}";
    }

    public static GpsInjectData deserialize(ByteBuffer input) {
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        int len = PayloadFieldDecoder.decodeUint8(input);
        byte[] data = PayloadFieldDecoder.decodeUint8Array(input, 110);
        return new GpsInjectData(targetSystem, targetComponent, len, data);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int len;

        private byte[] data;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Data length 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Data length"
        )
        public final Builder len(int len) {
            this.len = len;
            return this;
        }

        /**
         * Raw data (110 is enough for 12 satellites of RTCMv2) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 110,
                description = "Raw data (110 is enough for 12 satellites of RTCMv2)"
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final GpsInjectData build() {
            return new GpsInjectData(targetSystem, targetComponent, len, data);
        }
    }
}
