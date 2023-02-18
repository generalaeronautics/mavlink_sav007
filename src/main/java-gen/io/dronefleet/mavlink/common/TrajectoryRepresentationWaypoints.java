package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Describe a trajectory using an array of up-to 5 waypoints in the local frame 
 * (MAV_FRAME_LOCAL_NED). 
 */
@MavlinkMessageInfo(
        id = 332,
        crc = 236,
        description = "Describe a trajectory using an array of up-to 5 waypoints in the local frame (MAV_FRAME_LOCAL_NED)."
)
public final class TrajectoryRepresentationWaypoints {
    private final BigInteger timeUsec;

    private final int validPoints;

    private final List<Float> posX;

    private final List<Float> posY;

    private final List<Float> posZ;

    private final List<Float> velX;

    private final List<Float> velY;

    private final List<Float> velZ;

    private final List<Float> accX;

    private final List<Float> accY;

    private final List<Float> accZ;

    private final List<Float> posYaw;

    private final List<Float> velYaw;

    private final EnumValue<MavCmd> command;

    private TrajectoryRepresentationWaypoints(BigInteger timeUsec, int validPoints,
            List<Float> posX, List<Float> posY, List<Float> posZ, List<Float> velX,
            List<Float> velY, List<Float> velZ, List<Float> accX, List<Float> accY,
            List<Float> accZ, List<Float> posYaw, List<Float> velYaw, EnumValue<MavCmd> command) {
        this.timeUsec = timeUsec;
        this.validPoints = validPoints;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.velX = velX;
        this.velY = velY;
        this.velZ = velZ;
        this.accX = accX;
        this.accY = accY;
        this.accZ = accZ;
        this.posYaw = posYaw;
        this.velYaw = velYaw;
        this.command = command;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Number of valid points (up-to 5 waypoints are possible) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Number of valid points (up-to 5 waypoints are possible)"
    )
    public final int validPoints() {
        return this.validPoints;
    }

    /**
     * X-coordinate of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            arraySize = 5,
            description = "X-coordinate of waypoint, set to NaN if not being used"
    )
    public final List<Float> posX() {
        return this.posX;
    }

    /**
     * Y-coordinate of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            arraySize = 5,
            description = "Y-coordinate of waypoint, set to NaN if not being used"
    )
    public final List<Float> posY() {
        return this.posY;
    }

    /**
     * Z-coordinate of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 5,
            description = "Z-coordinate of waypoint, set to NaN if not being used"
    )
    public final List<Float> posZ() {
        return this.posZ;
    }

    /**
     * X-velocity of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 5,
            description = "X-velocity of waypoint, set to NaN if not being used"
    )
    public final List<Float> velX() {
        return this.velX;
    }

    /**
     * Y-velocity of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 5,
            description = "Y-velocity of waypoint, set to NaN if not being used"
    )
    public final List<Float> velY() {
        return this.velY;
    }

    /**
     * Z-velocity of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 5,
            description = "Z-velocity of waypoint, set to NaN if not being used"
    )
    public final List<Float> velZ() {
        return this.velZ;
    }

    /**
     * X-acceleration of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            arraySize = 5,
            description = "X-acceleration of waypoint, set to NaN if not being used"
    )
    public final List<Float> accX() {
        return this.accX;
    }

    /**
     * Y-acceleration of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            arraySize = 5,
            description = "Y-acceleration of waypoint, set to NaN if not being used"
    )
    public final List<Float> accY() {
        return this.accY;
    }

    /**
     * Z-acceleration of waypoint, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            arraySize = 5,
            description = "Z-acceleration of waypoint, set to NaN if not being used"
    )
    public final List<Float> accZ() {
        return this.accZ;
    }

    /**
     * Yaw angle, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            arraySize = 5,
            description = "Yaw angle, set to NaN if not being used"
    )
    public final List<Float> posYaw() {
        return this.posYaw;
    }

    /**
     * Yaw rate, set to NaN if not being used 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            arraySize = 5,
            description = "Yaw rate, set to NaN if not being used"
    )
    public final List<Float> velYaw() {
        return this.velYaw;
    }

    /**
     * {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} command id of waypoint, set to UINT16_MAX if not being used. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            arraySize = 5,
            enumType = MavCmd.class,
            description = "MAV_CMD command id of waypoint, set to UINT16_MAX if not being used."
    )
    public final EnumValue<MavCmd> command() {
        return this.command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        TrajectoryRepresentationWaypoints other = (TrajectoryRepresentationWaypoints)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(validPoints, other.validPoints)) return false;
        if (!Objects.deepEquals(posX, other.posX)) return false;
        if (!Objects.deepEquals(posY, other.posY)) return false;
        if (!Objects.deepEquals(posZ, other.posZ)) return false;
        if (!Objects.deepEquals(velX, other.velX)) return false;
        if (!Objects.deepEquals(velY, other.velY)) return false;
        if (!Objects.deepEquals(velZ, other.velZ)) return false;
        if (!Objects.deepEquals(accX, other.accX)) return false;
        if (!Objects.deepEquals(accY, other.accY)) return false;
        if (!Objects.deepEquals(accZ, other.accZ)) return false;
        if (!Objects.deepEquals(posYaw, other.posYaw)) return false;
        if (!Objects.deepEquals(velYaw, other.velYaw)) return false;
        if (!Objects.deepEquals(command, other.command)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(validPoints);
        result = 31 * result + Objects.hashCode(posX);
        result = 31 * result + Objects.hashCode(posY);
        result = 31 * result + Objects.hashCode(posZ);
        result = 31 * result + Objects.hashCode(velX);
        result = 31 * result + Objects.hashCode(velY);
        result = 31 * result + Objects.hashCode(velZ);
        result = 31 * result + Objects.hashCode(accX);
        result = 31 * result + Objects.hashCode(accY);
        result = 31 * result + Objects.hashCode(accZ);
        result = 31 * result + Objects.hashCode(posYaw);
        result = 31 * result + Objects.hashCode(velYaw);
        result = 31 * result + Objects.hashCode(command);
        return result;
    }

    @Override
    public String toString() {
        return "TrajectoryRepresentationWaypoints{timeUsec=" + timeUsec
                 + ", validPoints=" + validPoints
                 + ", posX=" + posX
                 + ", posY=" + posY
                 + ", posZ=" + posZ
                 + ", velX=" + velX
                 + ", velY=" + velY
                 + ", velZ=" + velZ
                 + ", accX=" + accX
                 + ", accY=" + accY
                 + ", accZ=" + accZ
                 + ", posYaw=" + posYaw
                 + ", velYaw=" + velYaw
                 + ", command=" + command + "}";
    }

    public static TrajectoryRepresentationWaypoints deserialize(ByteBuffer input) {
        BigInteger timeUsec = PayloadFieldDecoder.decodeUint64(input);
        List<Float> posX = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> posY = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> posZ = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> velX = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> velY = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> velZ = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> accX = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> accY = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> accZ = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> posYaw = PayloadFieldDecoder.decodeFloatArray(input, 20);
        List<Float> velYaw = PayloadFieldDecoder.decodeFloatArray(input, 20);
        EnumValue<MavCmd> command = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.MavCmd.class, input, 10);
        int validPoints = PayloadFieldDecoder.decodeUint8(input);
        return new TrajectoryRepresentationWaypoints(timeUsec, validPoints, posX, posY, posZ, velX, velY, velZ, accX, accY, accZ, posYaw, velYaw, command);
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int validPoints;

        private List<Float> posX;

        private List<Float> posY;

        private List<Float> posZ;

        private List<Float> velX;

        private List<Float> velY;

        private List<Float> velZ;

        private List<Float> accX;

        private List<Float> accY;

        private List<Float> accZ;

        private List<Float> posYaw;

        private List<Float> velYaw;

        private EnumValue<MavCmd> command;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Number of valid points (up-to 5 waypoints are possible) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Number of valid points (up-to 5 waypoints are possible)"
        )
        public final Builder validPoints(int validPoints) {
            this.validPoints = validPoints;
            return this;
        }

        /**
         * X-coordinate of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                arraySize = 5,
                description = "X-coordinate of waypoint, set to NaN if not being used"
        )
        public final Builder posX(List<Float> posX) {
            this.posX = posX;
            return this;
        }

        /**
         * Y-coordinate of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                arraySize = 5,
                description = "Y-coordinate of waypoint, set to NaN if not being used"
        )
        public final Builder posY(List<Float> posY) {
            this.posY = posY;
            return this;
        }

        /**
         * Z-coordinate of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 5,
                description = "Z-coordinate of waypoint, set to NaN if not being used"
        )
        public final Builder posZ(List<Float> posZ) {
            this.posZ = posZ;
            return this;
        }

        /**
         * X-velocity of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 5,
                description = "X-velocity of waypoint, set to NaN if not being used"
        )
        public final Builder velX(List<Float> velX) {
            this.velX = velX;
            return this;
        }

        /**
         * Y-velocity of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 5,
                description = "Y-velocity of waypoint, set to NaN if not being used"
        )
        public final Builder velY(List<Float> velY) {
            this.velY = velY;
            return this;
        }

        /**
         * Z-velocity of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 5,
                description = "Z-velocity of waypoint, set to NaN if not being used"
        )
        public final Builder velZ(List<Float> velZ) {
            this.velZ = velZ;
            return this;
        }

        /**
         * X-acceleration of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                arraySize = 5,
                description = "X-acceleration of waypoint, set to NaN if not being used"
        )
        public final Builder accX(List<Float> accX) {
            this.accX = accX;
            return this;
        }

        /**
         * Y-acceleration of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                arraySize = 5,
                description = "Y-acceleration of waypoint, set to NaN if not being used"
        )
        public final Builder accY(List<Float> accY) {
            this.accY = accY;
            return this;
        }

        /**
         * Z-acceleration of waypoint, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                arraySize = 5,
                description = "Z-acceleration of waypoint, set to NaN if not being used"
        )
        public final Builder accZ(List<Float> accZ) {
            this.accZ = accZ;
            return this;
        }

        /**
         * Yaw angle, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                arraySize = 5,
                description = "Yaw angle, set to NaN if not being used"
        )
        public final Builder posYaw(List<Float> posYaw) {
            this.posYaw = posYaw;
            return this;
        }

        /**
         * Yaw rate, set to NaN if not being used 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                arraySize = 5,
                description = "Yaw rate, set to NaN if not being used"
        )
        public final Builder velYaw(List<Float> velYaw) {
            this.velYaw = velYaw;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} command id of waypoint, set to UINT16_MAX if not being used. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                arraySize = 5,
                enumType = MavCmd.class,
                description = "MAV_CMD command id of waypoint, set to UINT16_MAX if not being used."
        )
        public final Builder command(EnumValue<MavCmd> command) {
            this.command = command;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} command id of waypoint, set to UINT16_MAX if not being used. 
         */
        public final Builder command(MavCmd entry) {
            return command(EnumValue.of(entry));
        }

        /**
         * {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} command id of waypoint, set to UINT16_MAX if not being used. 
         */
        public final Builder command(Enum... flags) {
            return command(EnumValue.create(flags));
        }

        /**
         * {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} command id of waypoint, set to UINT16_MAX if not being used. 
         */
        public final Builder command(Collection<Enum> flags) {
            return command(EnumValue.create(flags));
        }

        public final TrajectoryRepresentationWaypoints build() {
            return new TrajectoryRepresentationWaypoints(timeUsec, validPoints, posX, posY, posZ, velX, velY, velZ, accX, accY, accZ, posYaw, velYaw, command);
        }
    }
}
