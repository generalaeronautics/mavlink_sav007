package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Objects;

/**
 * Sets a desired vehicle position, velocity, and/or acceleration in a global coordinate system 
 * (WGS84). Used by an external controller to command the vehicle (manual controller or other 
 * system). 
 */
@MavlinkMessageInfo(
        id = 86,
        crc = 5,
        description = "Sets a desired vehicle position, velocity, and/or acceleration in a global coordinate system (WGS84). Used by an external controller to command the vehicle (manual controller or other system)."
)
public final class SetPositionTargetGlobalInt {
    private final long timeBootMs;

    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavFrame> coordinateFrame;

    private final EnumValue<PositionTargetTypemask> typeMask;

    private final int latInt;

    private final int lonInt;

    private final float alt;

    private final float vx;

    private final float vy;

    private final float vz;

    private final float afx;

    private final float afy;

    private final float afz;

    private final float yaw;

    private final float yawRate;

    private SetPositionTargetGlobalInt(long timeBootMs, int targetSystem, int targetComponent,
            EnumValue<MavFrame> coordinateFrame, EnumValue<PositionTargetTypemask> typeMask,
            int latInt, int lonInt, float alt, float vx, float vy, float vz, float afx, float afy,
            float afz, float yaw, float yawRate) {
        this.timeBootMs = timeBootMs;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.coordinateFrame = coordinateFrame;
        this.typeMask = typeMask;
        this.latInt = latInt;
        this.lonInt = lonInt;
        this.alt = alt;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.afx = afx;
        this.afy = afy;
        this.afz = afz;
        this.yaw = yaw;
        this.yawRate = yawRate;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow 
     * the system to compensate for the transport delay of the setpoint. This allows the system to 
     * compensate processing latency. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow the system to compensate for the transport delay of the setpoint. This allows the system to compensate processing latency."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
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
     * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
     * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11"
    )
    public final EnumValue<MavFrame> coordinateFrame() {
        return this.coordinateFrame;
    }

    /**
     * Bitmap to indicate which dimensions should be ignored by the vehicle. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            enumType = PositionTargetTypemask.class,
            description = "Bitmap to indicate which dimensions should be ignored by the vehicle."
    )
    public final EnumValue<PositionTargetTypemask> typeMask() {
        return this.typeMask;
    }

    /**
     * X Position in WGS84 frame 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "X Position in WGS84 frame"
    )
    public final int latInt() {
        return this.latInt;
    }

    /**
     * Y Position in WGS84 frame 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true,
            description = "Y Position in WGS84 frame"
    )
    public final int lonInt() {
        return this.lonInt;
    }

    /**
     * Altitude (MSL, Relative to home, or AGL - depending on frame) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Altitude (MSL, Relative to home, or AGL - depending on frame)"
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * X velocity in NED frame 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "X velocity in NED frame"
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y velocity in NED frame 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Y velocity in NED frame"
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z velocity in NED frame 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Z velocity in NED frame"
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
    )
    public final float afx() {
        return this.afx;
    }

    /**
     * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
    )
    public final float afy() {
        return this.afy;
    }

    /**
     * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
    )
    public final float afz() {
        return this.afz;
    }

    /**
     * yaw setpoint 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "yaw setpoint"
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * yaw rate setpoint 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "yaw rate setpoint"
    )
    public final float yawRate() {
        return this.yawRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SetPositionTargetGlobalInt other = (SetPositionTargetGlobalInt)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(coordinateFrame, other.coordinateFrame)) return false;
        if (!Objects.deepEquals(typeMask, other.typeMask)) return false;
        if (!Objects.deepEquals(latInt, other.latInt)) return false;
        if (!Objects.deepEquals(lonInt, other.lonInt)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(vx, other.vx)) return false;
        if (!Objects.deepEquals(vy, other.vy)) return false;
        if (!Objects.deepEquals(vz, other.vz)) return false;
        if (!Objects.deepEquals(afx, other.afx)) return false;
        if (!Objects.deepEquals(afy, other.afy)) return false;
        if (!Objects.deepEquals(afz, other.afz)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(yawRate, other.yawRate)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(coordinateFrame);
        result = 31 * result + Objects.hashCode(typeMask);
        result = 31 * result + Objects.hashCode(latInt);
        result = 31 * result + Objects.hashCode(lonInt);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(vx);
        result = 31 * result + Objects.hashCode(vy);
        result = 31 * result + Objects.hashCode(vz);
        result = 31 * result + Objects.hashCode(afx);
        result = 31 * result + Objects.hashCode(afy);
        result = 31 * result + Objects.hashCode(afz);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(yawRate);
        return result;
    }

    @Override
    public String toString() {
        return "SetPositionTargetGlobalInt{timeBootMs=" + timeBootMs
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", coordinateFrame=" + coordinateFrame
                 + ", typeMask=" + typeMask
                 + ", latInt=" + latInt
                 + ", lonInt=" + lonInt
                 + ", alt=" + alt
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz
                 + ", afx=" + afx
                 + ", afy=" + afy
                 + ", afz=" + afz
                 + ", yaw=" + yaw
                 + ", yawRate=" + yawRate + "}";
    }

    public static SetPositionTargetGlobalInt deserialize(ByteBuffer input) {
        long timeBootMs = PayloadFieldDecoder.decodeUint32(input);
        int latInt = PayloadFieldDecoder.decodeInt32(input);
        int lonInt = PayloadFieldDecoder.decodeInt32(input);
        float alt = PayloadFieldDecoder.decodeFloat(input);
        float vx = PayloadFieldDecoder.decodeFloat(input);
        float vy = PayloadFieldDecoder.decodeFloat(input);
        float vz = PayloadFieldDecoder.decodeFloat(input);
        float afx = PayloadFieldDecoder.decodeFloat(input);
        float afy = PayloadFieldDecoder.decodeFloat(input);
        float afz = PayloadFieldDecoder.decodeFloat(input);
        float yaw = PayloadFieldDecoder.decodeFloat(input);
        float yawRate = PayloadFieldDecoder.decodeFloat(input);
        EnumValue<PositionTargetTypemask> typeMask = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.PositionTargetTypemask.class, input, 2);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        EnumValue<MavFrame> coordinateFrame = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.MavFrame.class, input, 1);
        return new SetPositionTargetGlobalInt(timeBootMs, targetSystem, targetComponent, coordinateFrame, typeMask, latInt, lonInt, alt, vx, vy, vz, afx, afy, afz, yaw, yawRate);
    }

    public static final class Builder {
        private long timeBootMs;

        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavFrame> coordinateFrame;

        private EnumValue<PositionTargetTypemask> typeMask;

        private int latInt;

        private int lonInt;

        private float alt;

        private float vx;

        private float vy;

        private float vz;

        private float afx;

        private float afy;

        private float afz;

        private float yaw;

        private float yawRate;

        /**
         * Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow 
         * the system to compensate for the transport delay of the setpoint. This allows the system to 
         * compensate processing latency. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot). The rationale for the timestamp in the setpoint is to allow the system to compensate for the transport delay of the setpoint. This allows the system to compensate processing latency."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

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
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11"
        )
        public final Builder coordinateFrame(EnumValue<MavFrame> coordinateFrame) {
            this.coordinateFrame = coordinateFrame;
            return this;
        }

        /**
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        public final Builder coordinateFrame(MavFrame entry) {
            return coordinateFrame(EnumValue.of(entry));
        }

        /**
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        public final Builder coordinateFrame(Enum... flags) {
            return coordinateFrame(EnumValue.create(flags));
        }

        /**
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        public final Builder coordinateFrame(Collection<Enum> flags) {
            return coordinateFrame(EnumValue.create(flags));
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                enumType = PositionTargetTypemask.class,
                description = "Bitmap to indicate which dimensions should be ignored by the vehicle."
        )
        public final Builder typeMask(EnumValue<PositionTargetTypemask> typeMask) {
            this.typeMask = typeMask;
            return this;
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        public final Builder typeMask(PositionTargetTypemask entry) {
            return typeMask(EnumValue.of(entry));
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        public final Builder typeMask(Enum... flags) {
            return typeMask(EnumValue.create(flags));
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        public final Builder typeMask(Collection<Enum> flags) {
            return typeMask(EnumValue.create(flags));
        }

        /**
         * X Position in WGS84 frame 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "X Position in WGS84 frame"
        )
        public final Builder latInt(int latInt) {
            this.latInt = latInt;
            return this;
        }

        /**
         * Y Position in WGS84 frame 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true,
                description = "Y Position in WGS84 frame"
        )
        public final Builder lonInt(int lonInt) {
            this.lonInt = lonInt;
            return this;
        }

        /**
         * Altitude (MSL, Relative to home, or AGL - depending on frame) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Altitude (MSL, Relative to home, or AGL - depending on frame)"
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * X velocity in NED frame 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "X velocity in NED frame"
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y velocity in NED frame 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Y velocity in NED frame"
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z velocity in NED frame 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Z velocity in NED frame"
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        /**
         * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
        )
        public final Builder afx(float afx) {
            this.afx = afx;
            return this;
        }

        /**
         * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
        )
        public final Builder afy(float afy) {
            this.afy = afy;
            return this;
        }

        /**
         * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
        )
        public final Builder afz(float afz) {
            this.afz = afz;
            return this;
        }

        /**
         * yaw setpoint 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "yaw setpoint"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * yaw rate setpoint 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "yaw rate setpoint"
        )
        public final Builder yawRate(float yawRate) {
            this.yawRate = yawRate;
            return this;
        }

        public final SetPositionTargetGlobalInt build() {
            return new SetPositionTargetGlobalInt(timeBootMs, targetSystem, targetComponent, coordinateFrame, typeMask, latInt, lonInt, alt, vx, vy, vz, afx, afy, afz, yaw, yawRate);
        }
    }
}
