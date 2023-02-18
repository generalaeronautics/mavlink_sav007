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
 * Setpoint in roll, pitch, yaw and thrust from the operator 
 */
@MavlinkMessageInfo(
        id = 81,
        crc = 106,
        description = "Setpoint in roll, pitch, yaw and thrust from the operator"
)
public final class ManualSetpoint {
    private final long timeBootMs;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float thrust;

    private final int modeSwitch;

    private final int manualOverrideSwitch;

    private ManualSetpoint(long timeBootMs, float roll, float pitch, float yaw, float thrust,
            int modeSwitch, int manualOverrideSwitch) {
        this.timeBootMs = timeBootMs;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.thrust = thrust;
        this.modeSwitch = modeSwitch;
        this.manualOverrideSwitch = manualOverrideSwitch;
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
     * Desired roll rate 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Desired roll rate"
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Desired pitch rate 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Desired pitch rate"
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Desired yaw rate 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Desired yaw rate"
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Collective thrust, normalized to 0 .. 1 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Collective thrust, normalized to 0 .. 1"
    )
    public final float thrust() {
        return this.thrust;
    }

    /**
     * Flight mode switch position, 0.. 255 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Flight mode switch position, 0.. 255"
    )
    public final int modeSwitch() {
        return this.modeSwitch;
    }

    /**
     * Override mode switch position, 0.. 255 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "Override mode switch position, 0.. 255"
    )
    public final int manualOverrideSwitch() {
        return this.manualOverrideSwitch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ManualSetpoint other = (ManualSetpoint)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(thrust, other.thrust)) return false;
        if (!Objects.deepEquals(modeSwitch, other.modeSwitch)) return false;
        if (!Objects.deepEquals(manualOverrideSwitch, other.manualOverrideSwitch)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(thrust);
        result = 31 * result + Objects.hashCode(modeSwitch);
        result = 31 * result + Objects.hashCode(manualOverrideSwitch);
        return result;
    }

    @Override
    public String toString() {
        return "ManualSetpoint{timeBootMs=" + timeBootMs
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", thrust=" + thrust
                 + ", modeSwitch=" + modeSwitch
                 + ", manualOverrideSwitch=" + manualOverrideSwitch + "}";
    }

    public static ManualSetpoint deserialize(ByteBuffer input) {
        long timeBootMs = PayloadFieldDecoder.decodeUint32(input);
        float roll = PayloadFieldDecoder.decodeFloat(input);
        float pitch = PayloadFieldDecoder.decodeFloat(input);
        float yaw = PayloadFieldDecoder.decodeFloat(input);
        float thrust = PayloadFieldDecoder.decodeFloat(input);
        int modeSwitch = PayloadFieldDecoder.decodeUint8(input);
        int manualOverrideSwitch = PayloadFieldDecoder.decodeUint8(input);
        return new ManualSetpoint(timeBootMs, roll, pitch, yaw, thrust, modeSwitch, manualOverrideSwitch);
    }

    public static final class Builder {
        private long timeBootMs;

        private float roll;

        private float pitch;

        private float yaw;

        private float thrust;

        private int modeSwitch;

        private int manualOverrideSwitch;

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
         * Desired roll rate 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Desired roll rate"
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Desired pitch rate 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Desired pitch rate"
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Desired yaw rate 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Desired yaw rate"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Collective thrust, normalized to 0 .. 1 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Collective thrust, normalized to 0 .. 1"
        )
        public final Builder thrust(float thrust) {
            this.thrust = thrust;
            return this;
        }

        /**
         * Flight mode switch position, 0.. 255 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "Flight mode switch position, 0.. 255"
        )
        public final Builder modeSwitch(int modeSwitch) {
            this.modeSwitch = modeSwitch;
            return this;
        }

        /**
         * Override mode switch position, 0.. 255 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "Override mode switch position, 0.. 255"
        )
        public final Builder manualOverrideSwitch(int manualOverrideSwitch) {
            this.manualOverrideSwitch = manualOverrideSwitch;
            return this;
        }

        public final ManualSetpoint build() {
            return new ManualSetpoint(timeBootMs, roll, pitch, yaw, thrust, modeSwitch, manualOverrideSwitch);
        }
    }
}
