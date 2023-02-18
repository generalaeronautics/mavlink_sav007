package io.dronefleet.mavlink.matrixpilot;

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
 * Backwards compatible version of SERIAL_UDB_EXTRA F8: format 
 */
@MavlinkMessageInfo(
        id = 176,
        crc = 142,
        description = "Backwards compatible version of SERIAL_UDB_EXTRA F8: format"
)
public final class SerialUdbExtraF8 {
    private final float sueHeightTargetMax;

    private final float sueHeightTargetMin;

    private final float sueAltHoldThrottleMin;

    private final float sueAltHoldThrottleMax;

    private final float sueAltHoldPitchMin;

    private final float sueAltHoldPitchMax;

    private final float sueAltHoldPitchHigh;

    private SerialUdbExtraF8(float sueHeightTargetMax, float sueHeightTargetMin,
            float sueAltHoldThrottleMin, float sueAltHoldThrottleMax, float sueAltHoldPitchMin,
            float sueAltHoldPitchMax, float sueAltHoldPitchHigh) {
        this.sueHeightTargetMax = sueHeightTargetMax;
        this.sueHeightTargetMin = sueHeightTargetMin;
        this.sueAltHoldThrottleMin = sueAltHoldThrottleMin;
        this.sueAltHoldThrottleMax = sueAltHoldThrottleMax;
        this.sueAltHoldPitchMin = sueAltHoldPitchMin;
        this.sueAltHoldPitchMax = sueAltHoldPitchMax;
        this.sueAltHoldPitchHigh = sueAltHoldPitchHigh;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra HEIGHT_TARGET_MAX 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Serial UDB Extra HEIGHT_TARGET_MAX"
    )
    public final float sueHeightTargetMax() {
        return this.sueHeightTargetMax;
    }

    /**
     * Serial UDB Extra HEIGHT_TARGET_MIN 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Serial UDB Extra HEIGHT_TARGET_MIN"
    )
    public final float sueHeightTargetMin() {
        return this.sueHeightTargetMin;
    }

    /**
     * Serial UDB Extra ALT_HOLD_THROTTLE_MIN 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Serial UDB Extra ALT_HOLD_THROTTLE_MIN"
    )
    public final float sueAltHoldThrottleMin() {
        return this.sueAltHoldThrottleMin;
    }

    /**
     * Serial UDB Extra ALT_HOLD_THROTTLE_MAX 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Serial UDB Extra ALT_HOLD_THROTTLE_MAX"
    )
    public final float sueAltHoldThrottleMax() {
        return this.sueAltHoldThrottleMax;
    }

    /**
     * Serial UDB Extra ALT_HOLD_PITCH_MIN 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Serial UDB Extra ALT_HOLD_PITCH_MIN"
    )
    public final float sueAltHoldPitchMin() {
        return this.sueAltHoldPitchMin;
    }

    /**
     * Serial UDB Extra ALT_HOLD_PITCH_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Serial UDB Extra ALT_HOLD_PITCH_MAX"
    )
    public final float sueAltHoldPitchMax() {
        return this.sueAltHoldPitchMax;
    }

    /**
     * Serial UDB Extra ALT_HOLD_PITCH_HIGH 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Serial UDB Extra ALT_HOLD_PITCH_HIGH"
    )
    public final float sueAltHoldPitchHigh() {
        return this.sueAltHoldPitchHigh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF8 other = (SerialUdbExtraF8)o;
        if (!Objects.deepEquals(sueHeightTargetMax, other.sueHeightTargetMax)) return false;
        if (!Objects.deepEquals(sueHeightTargetMin, other.sueHeightTargetMin)) return false;
        if (!Objects.deepEquals(sueAltHoldThrottleMin, other.sueAltHoldThrottleMin)) return false;
        if (!Objects.deepEquals(sueAltHoldThrottleMax, other.sueAltHoldThrottleMax)) return false;
        if (!Objects.deepEquals(sueAltHoldPitchMin, other.sueAltHoldPitchMin)) return false;
        if (!Objects.deepEquals(sueAltHoldPitchMax, other.sueAltHoldPitchMax)) return false;
        if (!Objects.deepEquals(sueAltHoldPitchHigh, other.sueAltHoldPitchHigh)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueHeightTargetMax);
        result = 31 * result + Objects.hashCode(sueHeightTargetMin);
        result = 31 * result + Objects.hashCode(sueAltHoldThrottleMin);
        result = 31 * result + Objects.hashCode(sueAltHoldThrottleMax);
        result = 31 * result + Objects.hashCode(sueAltHoldPitchMin);
        result = 31 * result + Objects.hashCode(sueAltHoldPitchMax);
        result = 31 * result + Objects.hashCode(sueAltHoldPitchHigh);
        return result;
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF8{sueHeightTargetMax=" + sueHeightTargetMax
                 + ", sueHeightTargetMin=" + sueHeightTargetMin
                 + ", sueAltHoldThrottleMin=" + sueAltHoldThrottleMin
                 + ", sueAltHoldThrottleMax=" + sueAltHoldThrottleMax
                 + ", sueAltHoldPitchMin=" + sueAltHoldPitchMin
                 + ", sueAltHoldPitchMax=" + sueAltHoldPitchMax
                 + ", sueAltHoldPitchHigh=" + sueAltHoldPitchHigh + "}";
    }

    public static SerialUdbExtraF8 deserialize(ByteBuffer input) {
        float sueHeightTargetMax = PayloadFieldDecoder.decodeFloat(input);
        float sueHeightTargetMin = PayloadFieldDecoder.decodeFloat(input);
        float sueAltHoldThrottleMin = PayloadFieldDecoder.decodeFloat(input);
        float sueAltHoldThrottleMax = PayloadFieldDecoder.decodeFloat(input);
        float sueAltHoldPitchMin = PayloadFieldDecoder.decodeFloat(input);
        float sueAltHoldPitchMax = PayloadFieldDecoder.decodeFloat(input);
        float sueAltHoldPitchHigh = PayloadFieldDecoder.decodeFloat(input);
        return new SerialUdbExtraF8(sueHeightTargetMax, sueHeightTargetMin, sueAltHoldThrottleMin, sueAltHoldThrottleMax, sueAltHoldPitchMin, sueAltHoldPitchMax, sueAltHoldPitchHigh);
    }

    public static final class Builder {
        private float sueHeightTargetMax;

        private float sueHeightTargetMin;

        private float sueAltHoldThrottleMin;

        private float sueAltHoldThrottleMax;

        private float sueAltHoldPitchMin;

        private float sueAltHoldPitchMax;

        private float sueAltHoldPitchHigh;

        /**
         * Serial UDB Extra HEIGHT_TARGET_MAX 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Serial UDB Extra HEIGHT_TARGET_MAX"
        )
        public final Builder sueHeightTargetMax(float sueHeightTargetMax) {
            this.sueHeightTargetMax = sueHeightTargetMax;
            return this;
        }

        /**
         * Serial UDB Extra HEIGHT_TARGET_MIN 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Serial UDB Extra HEIGHT_TARGET_MIN"
        )
        public final Builder sueHeightTargetMin(float sueHeightTargetMin) {
            this.sueHeightTargetMin = sueHeightTargetMin;
            return this;
        }

        /**
         * Serial UDB Extra ALT_HOLD_THROTTLE_MIN 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Serial UDB Extra ALT_HOLD_THROTTLE_MIN"
        )
        public final Builder sueAltHoldThrottleMin(float sueAltHoldThrottleMin) {
            this.sueAltHoldThrottleMin = sueAltHoldThrottleMin;
            return this;
        }

        /**
         * Serial UDB Extra ALT_HOLD_THROTTLE_MAX 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Serial UDB Extra ALT_HOLD_THROTTLE_MAX"
        )
        public final Builder sueAltHoldThrottleMax(float sueAltHoldThrottleMax) {
            this.sueAltHoldThrottleMax = sueAltHoldThrottleMax;
            return this;
        }

        /**
         * Serial UDB Extra ALT_HOLD_PITCH_MIN 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Serial UDB Extra ALT_HOLD_PITCH_MIN"
        )
        public final Builder sueAltHoldPitchMin(float sueAltHoldPitchMin) {
            this.sueAltHoldPitchMin = sueAltHoldPitchMin;
            return this;
        }

        /**
         * Serial UDB Extra ALT_HOLD_PITCH_MAX 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Serial UDB Extra ALT_HOLD_PITCH_MAX"
        )
        public final Builder sueAltHoldPitchMax(float sueAltHoldPitchMax) {
            this.sueAltHoldPitchMax = sueAltHoldPitchMax;
            return this;
        }

        /**
         * Serial UDB Extra ALT_HOLD_PITCH_HIGH 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Serial UDB Extra ALT_HOLD_PITCH_HIGH"
        )
        public final Builder sueAltHoldPitchHigh(float sueAltHoldPitchHigh) {
            this.sueAltHoldPitchHigh = sueAltHoldPitchHigh;
            return this;
        }

        public final SerialUdbExtraF8 build() {
            return new SerialUdbExtraF8(sueHeightTargetMax, sueHeightTargetMin, sueAltHoldThrottleMin, sueAltHoldThrottleMax, sueAltHoldPitchMin, sueAltHoldPitchMax, sueAltHoldPitchHigh);
        }
    }
}
