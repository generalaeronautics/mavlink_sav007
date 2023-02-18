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
 * Offsets and calibrations values for hardware sensors. This makes it easier to debug the 
 * calibration process. 
 */
@MavlinkMessageInfo(
        id = 150,
        crc = 134,
        description = "Offsets and calibrations values for hardware sensors. This makes it easier to debug the calibration process."
)
public final class SensorOffsets {
    private final int magOfsX;

    private final int magOfsY;

    private final int magOfsZ;

    private final float magDeclination;

    private final int rawPress;

    private final int rawTemp;

    private final float gyroCalX;

    private final float gyroCalY;

    private final float gyroCalZ;

    private final float accelCalX;

    private final float accelCalY;

    private final float accelCalZ;

    private SensorOffsets(int magOfsX, int magOfsY, int magOfsZ, float magDeclination, int rawPress,
            int rawTemp, float gyroCalX, float gyroCalY, float gyroCalZ, float accelCalX,
            float accelCalY, float accelCalZ) {
        this.magOfsX = magOfsX;
        this.magOfsY = magOfsY;
        this.magOfsZ = magOfsZ;
        this.magDeclination = magDeclination;
        this.rawPress = rawPress;
        this.rawTemp = rawTemp;
        this.gyroCalX = gyroCalX;
        this.gyroCalY = gyroCalY;
        this.gyroCalZ = gyroCalZ;
        this.accelCalX = accelCalX;
        this.accelCalY = accelCalY;
        this.accelCalZ = accelCalZ;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Magnetometer X offset. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            signed = true,
            description = "Magnetometer X offset."
    )
    public final int magOfsX() {
        return this.magOfsX;
    }

    /**
     * Magnetometer Y offset. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "Magnetometer Y offset."
    )
    public final int magOfsY() {
        return this.magOfsY;
    }

    /**
     * Magnetometer Z offset. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Magnetometer Z offset."
    )
    public final int magOfsZ() {
        return this.magOfsZ;
    }

    /**
     * Magnetic declination. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Magnetic declination."
    )
    public final float magDeclination() {
        return this.magDeclination;
    }

    /**
     * Raw pressure from barometer. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Raw pressure from barometer."
    )
    public final int rawPress() {
        return this.rawPress;
    }

    /**
     * Raw temperature from barometer. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Raw temperature from barometer."
    )
    public final int rawTemp() {
        return this.rawTemp;
    }

    /**
     * Gyro X calibration. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Gyro X calibration."
    )
    public final float gyroCalX() {
        return this.gyroCalX;
    }

    /**
     * Gyro Y calibration. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Gyro Y calibration."
    )
    public final float gyroCalY() {
        return this.gyroCalY;
    }

    /**
     * Gyro Z calibration. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Gyro Z calibration."
    )
    public final float gyroCalZ() {
        return this.gyroCalZ;
    }

    /**
     * Accel X calibration. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Accel X calibration."
    )
    public final float accelCalX() {
        return this.accelCalX;
    }

    /**
     * Accel Y calibration. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Accel Y calibration."
    )
    public final float accelCalY() {
        return this.accelCalY;
    }

    /**
     * Accel Z calibration. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Accel Z calibration."
    )
    public final float accelCalZ() {
        return this.accelCalZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensorOffsets other = (SensorOffsets)o;
        if (!Objects.deepEquals(magOfsX, other.magOfsX)) return false;
        if (!Objects.deepEquals(magOfsY, other.magOfsY)) return false;
        if (!Objects.deepEquals(magOfsZ, other.magOfsZ)) return false;
        if (!Objects.deepEquals(magDeclination, other.magDeclination)) return false;
        if (!Objects.deepEquals(rawPress, other.rawPress)) return false;
        if (!Objects.deepEquals(rawTemp, other.rawTemp)) return false;
        if (!Objects.deepEquals(gyroCalX, other.gyroCalX)) return false;
        if (!Objects.deepEquals(gyroCalY, other.gyroCalY)) return false;
        if (!Objects.deepEquals(gyroCalZ, other.gyroCalZ)) return false;
        if (!Objects.deepEquals(accelCalX, other.accelCalX)) return false;
        if (!Objects.deepEquals(accelCalY, other.accelCalY)) return false;
        if (!Objects.deepEquals(accelCalZ, other.accelCalZ)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(magOfsX);
        result = 31 * result + Objects.hashCode(magOfsY);
        result = 31 * result + Objects.hashCode(magOfsZ);
        result = 31 * result + Objects.hashCode(magDeclination);
        result = 31 * result + Objects.hashCode(rawPress);
        result = 31 * result + Objects.hashCode(rawTemp);
        result = 31 * result + Objects.hashCode(gyroCalX);
        result = 31 * result + Objects.hashCode(gyroCalY);
        result = 31 * result + Objects.hashCode(gyroCalZ);
        result = 31 * result + Objects.hashCode(accelCalX);
        result = 31 * result + Objects.hashCode(accelCalY);
        result = 31 * result + Objects.hashCode(accelCalZ);
        return result;
    }

    @Override
    public String toString() {
        return "SensorOffsets{magOfsX=" + magOfsX
                 + ", magOfsY=" + magOfsY
                 + ", magOfsZ=" + magOfsZ
                 + ", magDeclination=" + magDeclination
                 + ", rawPress=" + rawPress
                 + ", rawTemp=" + rawTemp
                 + ", gyroCalX=" + gyroCalX
                 + ", gyroCalY=" + gyroCalY
                 + ", gyroCalZ=" + gyroCalZ
                 + ", accelCalX=" + accelCalX
                 + ", accelCalY=" + accelCalY
                 + ", accelCalZ=" + accelCalZ + "}";
    }

    public static SensorOffsets deserialize(ByteBuffer input) {
        float magDeclination = PayloadFieldDecoder.decodeFloat(input);
        int rawPress = PayloadFieldDecoder.decodeInt32(input);
        int rawTemp = PayloadFieldDecoder.decodeInt32(input);
        float gyroCalX = PayloadFieldDecoder.decodeFloat(input);
        float gyroCalY = PayloadFieldDecoder.decodeFloat(input);
        float gyroCalZ = PayloadFieldDecoder.decodeFloat(input);
        float accelCalX = PayloadFieldDecoder.decodeFloat(input);
        float accelCalY = PayloadFieldDecoder.decodeFloat(input);
        float accelCalZ = PayloadFieldDecoder.decodeFloat(input);
        int magOfsX = PayloadFieldDecoder.decodeInt16(input);
        int magOfsY = PayloadFieldDecoder.decodeInt16(input);
        int magOfsZ = PayloadFieldDecoder.decodeInt16(input);
        return new SensorOffsets(magOfsX, magOfsY, magOfsZ, magDeclination, rawPress, rawTemp, gyroCalX, gyroCalY, gyroCalZ, accelCalX, accelCalY, accelCalZ);
    }

    public static final class Builder {
        private int magOfsX;

        private int magOfsY;

        private int magOfsZ;

        private float magDeclination;

        private int rawPress;

        private int rawTemp;

        private float gyroCalX;

        private float gyroCalY;

        private float gyroCalZ;

        private float accelCalX;

        private float accelCalY;

        private float accelCalZ;

        /**
         * Magnetometer X offset. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                signed = true,
                description = "Magnetometer X offset."
        )
        public final Builder magOfsX(int magOfsX) {
            this.magOfsX = magOfsX;
            return this;
        }

        /**
         * Magnetometer Y offset. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "Magnetometer Y offset."
        )
        public final Builder magOfsY(int magOfsY) {
            this.magOfsY = magOfsY;
            return this;
        }

        /**
         * Magnetometer Z offset. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Magnetometer Z offset."
        )
        public final Builder magOfsZ(int magOfsZ) {
            this.magOfsZ = magOfsZ;
            return this;
        }

        /**
         * Magnetic declination. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Magnetic declination."
        )
        public final Builder magDeclination(float magDeclination) {
            this.magDeclination = magDeclination;
            return this;
        }

        /**
         * Raw pressure from barometer. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Raw pressure from barometer."
        )
        public final Builder rawPress(int rawPress) {
            this.rawPress = rawPress;
            return this;
        }

        /**
         * Raw temperature from barometer. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Raw temperature from barometer."
        )
        public final Builder rawTemp(int rawTemp) {
            this.rawTemp = rawTemp;
            return this;
        }

        /**
         * Gyro X calibration. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Gyro X calibration."
        )
        public final Builder gyroCalX(float gyroCalX) {
            this.gyroCalX = gyroCalX;
            return this;
        }

        /**
         * Gyro Y calibration. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Gyro Y calibration."
        )
        public final Builder gyroCalY(float gyroCalY) {
            this.gyroCalY = gyroCalY;
            return this;
        }

        /**
         * Gyro Z calibration. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Gyro Z calibration."
        )
        public final Builder gyroCalZ(float gyroCalZ) {
            this.gyroCalZ = gyroCalZ;
            return this;
        }

        /**
         * Accel X calibration. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Accel X calibration."
        )
        public final Builder accelCalX(float accelCalX) {
            this.accelCalX = accelCalX;
            return this;
        }

        /**
         * Accel Y calibration. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Accel Y calibration."
        )
        public final Builder accelCalY(float accelCalY) {
            this.accelCalY = accelCalY;
            return this;
        }

        /**
         * Accel Z calibration. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Accel Z calibration."
        )
        public final Builder accelCalZ(float accelCalZ) {
            this.accelCalZ = accelCalZ;
            return this;
        }

        public final SensorOffsets build() {
            return new SensorOffsets(magOfsX, magOfsY, magOfsZ, magDeclination, rawPress, rawTemp, gyroCalX, gyroCalY, gyroCalZ, accelCalX, accelCalY, accelCalZ);
        }
    }
}
