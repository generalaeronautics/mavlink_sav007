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
 * A fence point. Used to set a point when from GCS -&gt; MAV. Also used to return a point from MAV -&gt; GCS. 
 */
@MavlinkMessageInfo(
        id = 160,
        crc = 78,
        description = "A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS."
)
public final class FencePoint {
    private final int targetSystem;

    private final int targetComponent;

    private final int idx;

    private final int count;

    private final float lat;

    private final float lng;

    private FencePoint(int targetSystem, int targetComponent, int idx, int count, float lat,
            float lng) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idx = idx;
        this.count = count;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Point index (first point is 1, 0 is for return point). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Point index (first point is 1, 0 is for return point)."
    )
    public final int idx() {
        return this.idx;
    }

    /**
     * Total number of points (for sanity checking). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Total number of points (for sanity checking)."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Latitude of point. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Latitude of point."
    )
    public final float lat() {
        return this.lat;
    }

    /**
     * Longitude of point. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Longitude of point."
    )
    public final float lng() {
        return this.lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FencePoint other = (FencePoint)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idx, other.idx)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lng, other.lng)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idx);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lng);
        return result;
    }

    @Override
    public String toString() {
        return "FencePoint{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idx=" + idx
                 + ", count=" + count
                 + ", lat=" + lat
                 + ", lng=" + lng + "}";
    }

    public static FencePoint deserialize(ByteBuffer input) {
        float lat = PayloadFieldDecoder.decodeFloat(input);
        float lng = PayloadFieldDecoder.decodeFloat(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        int idx = PayloadFieldDecoder.decodeUint8(input);
        int count = PayloadFieldDecoder.decodeUint8(input);
        return new FencePoint(targetSystem, targetComponent, idx, count, lat, lng);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int idx;

        private int count;

        private float lat;

        private float lng;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Point index (first point is 1, 0 is for return point). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Point index (first point is 1, 0 is for return point)."
        )
        public final Builder idx(int idx) {
            this.idx = idx;
            return this;
        }

        /**
         * Total number of points (for sanity checking). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Total number of points (for sanity checking)."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Latitude of point. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Latitude of point."
        )
        public final Builder lat(float lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude of point. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Longitude of point."
        )
        public final Builder lng(float lng) {
            this.lng = lng;
            return this;
        }

        public final FencePoint build() {
            return new FencePoint(targetSystem, targetComponent, idx, count, lat, lng);
        }
    }
}
