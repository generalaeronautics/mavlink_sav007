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
 * Backwards compatible version of SERIAL_UDB_EXTRA - F2: Part B 
 */
@MavlinkMessageInfo(
        id = 171,
        crc = 245,
        description = "Backwards compatible version of SERIAL_UDB_EXTRA - F2: Part B"
)
public final class SerialUdbExtraF2B {
    private final long sueTime;

    private final int suePwmInput1;

    private final int suePwmInput2;

    private final int suePwmInput3;

    private final int suePwmInput4;

    private final int suePwmInput5;

    private final int suePwmInput6;

    private final int suePwmInput7;

    private final int suePwmInput8;

    private final int suePwmInput9;

    private final int suePwmInput10;

    private final int suePwmInput11;

    private final int suePwmInput12;

    private final int suePwmOutput1;

    private final int suePwmOutput2;

    private final int suePwmOutput3;

    private final int suePwmOutput4;

    private final int suePwmOutput5;

    private final int suePwmOutput6;

    private final int suePwmOutput7;

    private final int suePwmOutput8;

    private final int suePwmOutput9;

    private final int suePwmOutput10;

    private final int suePwmOutput11;

    private final int suePwmOutput12;

    private final int sueImuLocationX;

    private final int sueImuLocationY;

    private final int sueImuLocationZ;

    private final int sueLocationErrorEarthX;

    private final int sueLocationErrorEarthY;

    private final int sueLocationErrorEarthZ;

    private final long sueFlags;

    private final int sueOscFails;

    private final int sueImuVelocityX;

    private final int sueImuVelocityY;

    private final int sueImuVelocityZ;

    private final int sueWaypointGoalX;

    private final int sueWaypointGoalY;

    private final int sueWaypointGoalZ;

    private final int sueAeroX;

    private final int sueAeroY;

    private final int sueAeroZ;

    private final int sueBaromTemp;

    private final int sueBaromPress;

    private final int sueBaromAlt;

    private final int sueBatVolt;

    private final int sueBatAmp;

    private final int sueBatAmpHours;

    private final int sueDesiredHeight;

    private final int sueMemoryStackFree;

    private SerialUdbExtraF2B(long sueTime, int suePwmInput1, int suePwmInput2, int suePwmInput3,
            int suePwmInput4, int suePwmInput5, int suePwmInput6, int suePwmInput7,
            int suePwmInput8, int suePwmInput9, int suePwmInput10, int suePwmInput11,
            int suePwmInput12, int suePwmOutput1, int suePwmOutput2, int suePwmOutput3,
            int suePwmOutput4, int suePwmOutput5, int suePwmOutput6, int suePwmOutput7,
            int suePwmOutput8, int suePwmOutput9, int suePwmOutput10, int suePwmOutput11,
            int suePwmOutput12, int sueImuLocationX, int sueImuLocationY, int sueImuLocationZ,
            int sueLocationErrorEarthX, int sueLocationErrorEarthY, int sueLocationErrorEarthZ,
            long sueFlags, int sueOscFails, int sueImuVelocityX, int sueImuVelocityY,
            int sueImuVelocityZ, int sueWaypointGoalX, int sueWaypointGoalY, int sueWaypointGoalZ,
            int sueAeroX, int sueAeroY, int sueAeroZ, int sueBaromTemp, int sueBaromPress,
            int sueBaromAlt, int sueBatVolt, int sueBatAmp, int sueBatAmpHours,
            int sueDesiredHeight, int sueMemoryStackFree) {
        this.sueTime = sueTime;
        this.suePwmInput1 = suePwmInput1;
        this.suePwmInput2 = suePwmInput2;
        this.suePwmInput3 = suePwmInput3;
        this.suePwmInput4 = suePwmInput4;
        this.suePwmInput5 = suePwmInput5;
        this.suePwmInput6 = suePwmInput6;
        this.suePwmInput7 = suePwmInput7;
        this.suePwmInput8 = suePwmInput8;
        this.suePwmInput9 = suePwmInput9;
        this.suePwmInput10 = suePwmInput10;
        this.suePwmInput11 = suePwmInput11;
        this.suePwmInput12 = suePwmInput12;
        this.suePwmOutput1 = suePwmOutput1;
        this.suePwmOutput2 = suePwmOutput2;
        this.suePwmOutput3 = suePwmOutput3;
        this.suePwmOutput4 = suePwmOutput4;
        this.suePwmOutput5 = suePwmOutput5;
        this.suePwmOutput6 = suePwmOutput6;
        this.suePwmOutput7 = suePwmOutput7;
        this.suePwmOutput8 = suePwmOutput8;
        this.suePwmOutput9 = suePwmOutput9;
        this.suePwmOutput10 = suePwmOutput10;
        this.suePwmOutput11 = suePwmOutput11;
        this.suePwmOutput12 = suePwmOutput12;
        this.sueImuLocationX = sueImuLocationX;
        this.sueImuLocationY = sueImuLocationY;
        this.sueImuLocationZ = sueImuLocationZ;
        this.sueLocationErrorEarthX = sueLocationErrorEarthX;
        this.sueLocationErrorEarthY = sueLocationErrorEarthY;
        this.sueLocationErrorEarthZ = sueLocationErrorEarthZ;
        this.sueFlags = sueFlags;
        this.sueOscFails = sueOscFails;
        this.sueImuVelocityX = sueImuVelocityX;
        this.sueImuVelocityY = sueImuVelocityY;
        this.sueImuVelocityZ = sueImuVelocityZ;
        this.sueWaypointGoalX = sueWaypointGoalX;
        this.sueWaypointGoalY = sueWaypointGoalY;
        this.sueWaypointGoalZ = sueWaypointGoalZ;
        this.sueAeroX = sueAeroX;
        this.sueAeroY = sueAeroY;
        this.sueAeroZ = sueAeroZ;
        this.sueBaromTemp = sueBaromTemp;
        this.sueBaromPress = sueBaromPress;
        this.sueBaromAlt = sueBaromAlt;
        this.sueBatVolt = sueBatVolt;
        this.sueBatAmp = sueBatAmp;
        this.sueBatAmpHours = sueBatAmpHours;
        this.sueDesiredHeight = sueDesiredHeight;
        this.sueMemoryStackFree = sueMemoryStackFree;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra Time 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Serial UDB Extra Time"
    )
    public final long sueTime() {
        return this.sueTime;
    }

    /**
     * Serial UDB Extra PWM Input Channel 1 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 1"
    )
    public final int suePwmInput1() {
        return this.suePwmInput1;
    }

    /**
     * Serial UDB Extra PWM Input Channel 2 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 2"
    )
    public final int suePwmInput2() {
        return this.suePwmInput2;
    }

    /**
     * Serial UDB Extra PWM Input Channel 3 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 3"
    )
    public final int suePwmInput3() {
        return this.suePwmInput3;
    }

    /**
     * Serial UDB Extra PWM Input Channel 4 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 4"
    )
    public final int suePwmInput4() {
        return this.suePwmInput4;
    }

    /**
     * Serial UDB Extra PWM Input Channel 5 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 5"
    )
    public final int suePwmInput5() {
        return this.suePwmInput5;
    }

    /**
     * Serial UDB Extra PWM Input Channel 6 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 6"
    )
    public final int suePwmInput6() {
        return this.suePwmInput6;
    }

    /**
     * Serial UDB Extra PWM Input Channel 7 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 7"
    )
    public final int suePwmInput7() {
        return this.suePwmInput7;
    }

    /**
     * Serial UDB Extra PWM Input Channel 8 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 8"
    )
    public final int suePwmInput8() {
        return this.suePwmInput8;
    }

    /**
     * Serial UDB Extra PWM Input Channel 9 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 9"
    )
    public final int suePwmInput9() {
        return this.suePwmInput9;
    }

    /**
     * Serial UDB Extra PWM Input Channel 10 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 10"
    )
    public final int suePwmInput10() {
        return this.suePwmInput10;
    }

    /**
     * Serial UDB Extra PWM Input Channel 11 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 11"
    )
    public final int suePwmInput11() {
        return this.suePwmInput11;
    }

    /**
     * Serial UDB Extra PWM Input Channel 12 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Input Channel 12"
    )
    public final int suePwmInput12() {
        return this.suePwmInput12;
    }

    /**
     * Serial UDB Extra PWM Output Channel 1 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 1"
    )
    public final int suePwmOutput1() {
        return this.suePwmOutput1;
    }

    /**
     * Serial UDB Extra PWM Output Channel 2 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 2"
    )
    public final int suePwmOutput2() {
        return this.suePwmOutput2;
    }

    /**
     * Serial UDB Extra PWM Output Channel 3 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 3"
    )
    public final int suePwmOutput3() {
        return this.suePwmOutput3;
    }

    /**
     * Serial UDB Extra PWM Output Channel 4 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 4"
    )
    public final int suePwmOutput4() {
        return this.suePwmOutput4;
    }

    /**
     * Serial UDB Extra PWM Output Channel 5 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 5"
    )
    public final int suePwmOutput5() {
        return this.suePwmOutput5;
    }

    /**
     * Serial UDB Extra PWM Output Channel 6 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 6"
    )
    public final int suePwmOutput6() {
        return this.suePwmOutput6;
    }

    /**
     * Serial UDB Extra PWM Output Channel 7 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 7"
    )
    public final int suePwmOutput7() {
        return this.suePwmOutput7;
    }

    /**
     * Serial UDB Extra PWM Output Channel 8 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 8"
    )
    public final int suePwmOutput8() {
        return this.suePwmOutput8;
    }

    /**
     * Serial UDB Extra PWM Output Channel 9 
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 9"
    )
    public final int suePwmOutput9() {
        return this.suePwmOutput9;
    }

    /**
     * Serial UDB Extra PWM Output Channel 10 
     */
    @MavlinkFieldInfo(
            position = 23,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 10"
    )
    public final int suePwmOutput10() {
        return this.suePwmOutput10;
    }

    /**
     * Serial UDB Extra PWM Output Channel 11 
     */
    @MavlinkFieldInfo(
            position = 24,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 11"
    )
    public final int suePwmOutput11() {
        return this.suePwmOutput11;
    }

    /**
     * Serial UDB Extra PWM Output Channel 12 
     */
    @MavlinkFieldInfo(
            position = 25,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra PWM Output Channel 12"
    )
    public final int suePwmOutput12() {
        return this.suePwmOutput12;
    }

    /**
     * Serial UDB Extra IMU Location X 
     */
    @MavlinkFieldInfo(
            position = 26,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra IMU Location X"
    )
    public final int sueImuLocationX() {
        return this.sueImuLocationX;
    }

    /**
     * Serial UDB Extra IMU Location Y 
     */
    @MavlinkFieldInfo(
            position = 27,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra IMU Location Y"
    )
    public final int sueImuLocationY() {
        return this.sueImuLocationY;
    }

    /**
     * Serial UDB Extra IMU Location Z 
     */
    @MavlinkFieldInfo(
            position = 28,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra IMU Location Z"
    )
    public final int sueImuLocationZ() {
        return this.sueImuLocationZ;
    }

    /**
     * Serial UDB Location Error Earth X 
     */
    @MavlinkFieldInfo(
            position = 29,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Location Error Earth X"
    )
    public final int sueLocationErrorEarthX() {
        return this.sueLocationErrorEarthX;
    }

    /**
     * Serial UDB Location Error Earth Y 
     */
    @MavlinkFieldInfo(
            position = 30,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Location Error Earth Y"
    )
    public final int sueLocationErrorEarthY() {
        return this.sueLocationErrorEarthY;
    }

    /**
     * Serial UDB Location Error Earth Z 
     */
    @MavlinkFieldInfo(
            position = 31,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Location Error Earth Z"
    )
    public final int sueLocationErrorEarthZ() {
        return this.sueLocationErrorEarthZ;
    }

    /**
     * Serial UDB Extra Status Flags 
     */
    @MavlinkFieldInfo(
            position = 32,
            unitSize = 4,
            description = "Serial UDB Extra Status Flags"
    )
    public final long sueFlags() {
        return this.sueFlags;
    }

    /**
     * Serial UDB Extra Oscillator Failure Count 
     */
    @MavlinkFieldInfo(
            position = 33,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Oscillator Failure Count"
    )
    public final int sueOscFails() {
        return this.sueOscFails;
    }

    /**
     * Serial UDB Extra IMU Velocity X 
     */
    @MavlinkFieldInfo(
            position = 34,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra IMU Velocity X"
    )
    public final int sueImuVelocityX() {
        return this.sueImuVelocityX;
    }

    /**
     * Serial UDB Extra IMU Velocity Y 
     */
    @MavlinkFieldInfo(
            position = 35,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra IMU Velocity Y"
    )
    public final int sueImuVelocityY() {
        return this.sueImuVelocityY;
    }

    /**
     * Serial UDB Extra IMU Velocity Z 
     */
    @MavlinkFieldInfo(
            position = 36,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra IMU Velocity Z"
    )
    public final int sueImuVelocityZ() {
        return this.sueImuVelocityZ;
    }

    /**
     * Serial UDB Extra Current Waypoint Goal X 
     */
    @MavlinkFieldInfo(
            position = 37,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Current Waypoint Goal X"
    )
    public final int sueWaypointGoalX() {
        return this.sueWaypointGoalX;
    }

    /**
     * Serial UDB Extra Current Waypoint Goal Y 
     */
    @MavlinkFieldInfo(
            position = 38,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Current Waypoint Goal Y"
    )
    public final int sueWaypointGoalY() {
        return this.sueWaypointGoalY;
    }

    /**
     * Serial UDB Extra Current Waypoint Goal Z 
     */
    @MavlinkFieldInfo(
            position = 39,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Current Waypoint Goal Z"
    )
    public final int sueWaypointGoalZ() {
        return this.sueWaypointGoalZ;
    }

    /**
     * Aeroforce in UDB X Axis 
     */
    @MavlinkFieldInfo(
            position = 40,
            unitSize = 2,
            signed = true,
            description = "Aeroforce in UDB X Axis"
    )
    public final int sueAeroX() {
        return this.sueAeroX;
    }

    /**
     * Aeroforce in UDB Y Axis 
     */
    @MavlinkFieldInfo(
            position = 41,
            unitSize = 2,
            signed = true,
            description = "Aeroforce in UDB Y Axis"
    )
    public final int sueAeroY() {
        return this.sueAeroY;
    }

    /**
     * Aeroforce in UDB Z axis 
     */
    @MavlinkFieldInfo(
            position = 42,
            unitSize = 2,
            signed = true,
            description = "Aeroforce in UDB Z axis"
    )
    public final int sueAeroZ() {
        return this.sueAeroZ;
    }

    /**
     * SUE barometer temperature 
     */
    @MavlinkFieldInfo(
            position = 43,
            unitSize = 2,
            signed = true,
            description = "SUE barometer temperature"
    )
    public final int sueBaromTemp() {
        return this.sueBaromTemp;
    }

    /**
     * SUE barometer pressure 
     */
    @MavlinkFieldInfo(
            position = 44,
            unitSize = 4,
            signed = true,
            description = "SUE barometer pressure"
    )
    public final int sueBaromPress() {
        return this.sueBaromPress;
    }

    /**
     * SUE barometer altitude 
     */
    @MavlinkFieldInfo(
            position = 45,
            unitSize = 4,
            signed = true,
            description = "SUE barometer altitude"
    )
    public final int sueBaromAlt() {
        return this.sueBaromAlt;
    }

    /**
     * SUE battery voltage 
     */
    @MavlinkFieldInfo(
            position = 46,
            unitSize = 2,
            signed = true,
            description = "SUE battery voltage"
    )
    public final int sueBatVolt() {
        return this.sueBatVolt;
    }

    /**
     * SUE battery current 
     */
    @MavlinkFieldInfo(
            position = 47,
            unitSize = 2,
            signed = true,
            description = "SUE battery current"
    )
    public final int sueBatAmp() {
        return this.sueBatAmp;
    }

    /**
     * SUE battery milli amp hours used 
     */
    @MavlinkFieldInfo(
            position = 48,
            unitSize = 2,
            signed = true,
            description = "SUE battery milli amp hours used"
    )
    public final int sueBatAmpHours() {
        return this.sueBatAmpHours;
    }

    /**
     * Sue autopilot desired height 
     */
    @MavlinkFieldInfo(
            position = 49,
            unitSize = 2,
            signed = true,
            description = "Sue autopilot desired height"
    )
    public final int sueDesiredHeight() {
        return this.sueDesiredHeight;
    }

    /**
     * Serial UDB Extra Stack Memory Free 
     */
    @MavlinkFieldInfo(
            position = 50,
            unitSize = 2,
            signed = true,
            description = "Serial UDB Extra Stack Memory Free"
    )
    public final int sueMemoryStackFree() {
        return this.sueMemoryStackFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF2B other = (SerialUdbExtraF2B)o;
        if (!Objects.deepEquals(sueTime, other.sueTime)) return false;
        if (!Objects.deepEquals(suePwmInput1, other.suePwmInput1)) return false;
        if (!Objects.deepEquals(suePwmInput2, other.suePwmInput2)) return false;
        if (!Objects.deepEquals(suePwmInput3, other.suePwmInput3)) return false;
        if (!Objects.deepEquals(suePwmInput4, other.suePwmInput4)) return false;
        if (!Objects.deepEquals(suePwmInput5, other.suePwmInput5)) return false;
        if (!Objects.deepEquals(suePwmInput6, other.suePwmInput6)) return false;
        if (!Objects.deepEquals(suePwmInput7, other.suePwmInput7)) return false;
        if (!Objects.deepEquals(suePwmInput8, other.suePwmInput8)) return false;
        if (!Objects.deepEquals(suePwmInput9, other.suePwmInput9)) return false;
        if (!Objects.deepEquals(suePwmInput10, other.suePwmInput10)) return false;
        if (!Objects.deepEquals(suePwmInput11, other.suePwmInput11)) return false;
        if (!Objects.deepEquals(suePwmInput12, other.suePwmInput12)) return false;
        if (!Objects.deepEquals(suePwmOutput1, other.suePwmOutput1)) return false;
        if (!Objects.deepEquals(suePwmOutput2, other.suePwmOutput2)) return false;
        if (!Objects.deepEquals(suePwmOutput3, other.suePwmOutput3)) return false;
        if (!Objects.deepEquals(suePwmOutput4, other.suePwmOutput4)) return false;
        if (!Objects.deepEquals(suePwmOutput5, other.suePwmOutput5)) return false;
        if (!Objects.deepEquals(suePwmOutput6, other.suePwmOutput6)) return false;
        if (!Objects.deepEquals(suePwmOutput7, other.suePwmOutput7)) return false;
        if (!Objects.deepEquals(suePwmOutput8, other.suePwmOutput8)) return false;
        if (!Objects.deepEquals(suePwmOutput9, other.suePwmOutput9)) return false;
        if (!Objects.deepEquals(suePwmOutput10, other.suePwmOutput10)) return false;
        if (!Objects.deepEquals(suePwmOutput11, other.suePwmOutput11)) return false;
        if (!Objects.deepEquals(suePwmOutput12, other.suePwmOutput12)) return false;
        if (!Objects.deepEquals(sueImuLocationX, other.sueImuLocationX)) return false;
        if (!Objects.deepEquals(sueImuLocationY, other.sueImuLocationY)) return false;
        if (!Objects.deepEquals(sueImuLocationZ, other.sueImuLocationZ)) return false;
        if (!Objects.deepEquals(sueLocationErrorEarthX, other.sueLocationErrorEarthX)) return false;
        if (!Objects.deepEquals(sueLocationErrorEarthY, other.sueLocationErrorEarthY)) return false;
        if (!Objects.deepEquals(sueLocationErrorEarthZ, other.sueLocationErrorEarthZ)) return false;
        if (!Objects.deepEquals(sueFlags, other.sueFlags)) return false;
        if (!Objects.deepEquals(sueOscFails, other.sueOscFails)) return false;
        if (!Objects.deepEquals(sueImuVelocityX, other.sueImuVelocityX)) return false;
        if (!Objects.deepEquals(sueImuVelocityY, other.sueImuVelocityY)) return false;
        if (!Objects.deepEquals(sueImuVelocityZ, other.sueImuVelocityZ)) return false;
        if (!Objects.deepEquals(sueWaypointGoalX, other.sueWaypointGoalX)) return false;
        if (!Objects.deepEquals(sueWaypointGoalY, other.sueWaypointGoalY)) return false;
        if (!Objects.deepEquals(sueWaypointGoalZ, other.sueWaypointGoalZ)) return false;
        if (!Objects.deepEquals(sueAeroX, other.sueAeroX)) return false;
        if (!Objects.deepEquals(sueAeroY, other.sueAeroY)) return false;
        if (!Objects.deepEquals(sueAeroZ, other.sueAeroZ)) return false;
        if (!Objects.deepEquals(sueBaromTemp, other.sueBaromTemp)) return false;
        if (!Objects.deepEquals(sueBaromPress, other.sueBaromPress)) return false;
        if (!Objects.deepEquals(sueBaromAlt, other.sueBaromAlt)) return false;
        if (!Objects.deepEquals(sueBatVolt, other.sueBatVolt)) return false;
        if (!Objects.deepEquals(sueBatAmp, other.sueBatAmp)) return false;
        if (!Objects.deepEquals(sueBatAmpHours, other.sueBatAmpHours)) return false;
        if (!Objects.deepEquals(sueDesiredHeight, other.sueDesiredHeight)) return false;
        if (!Objects.deepEquals(sueMemoryStackFree, other.sueMemoryStackFree)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueTime);
        result = 31 * result + Objects.hashCode(suePwmInput1);
        result = 31 * result + Objects.hashCode(suePwmInput2);
        result = 31 * result + Objects.hashCode(suePwmInput3);
        result = 31 * result + Objects.hashCode(suePwmInput4);
        result = 31 * result + Objects.hashCode(suePwmInput5);
        result = 31 * result + Objects.hashCode(suePwmInput6);
        result = 31 * result + Objects.hashCode(suePwmInput7);
        result = 31 * result + Objects.hashCode(suePwmInput8);
        result = 31 * result + Objects.hashCode(suePwmInput9);
        result = 31 * result + Objects.hashCode(suePwmInput10);
        result = 31 * result + Objects.hashCode(suePwmInput11);
        result = 31 * result + Objects.hashCode(suePwmInput12);
        result = 31 * result + Objects.hashCode(suePwmOutput1);
        result = 31 * result + Objects.hashCode(suePwmOutput2);
        result = 31 * result + Objects.hashCode(suePwmOutput3);
        result = 31 * result + Objects.hashCode(suePwmOutput4);
        result = 31 * result + Objects.hashCode(suePwmOutput5);
        result = 31 * result + Objects.hashCode(suePwmOutput6);
        result = 31 * result + Objects.hashCode(suePwmOutput7);
        result = 31 * result + Objects.hashCode(suePwmOutput8);
        result = 31 * result + Objects.hashCode(suePwmOutput9);
        result = 31 * result + Objects.hashCode(suePwmOutput10);
        result = 31 * result + Objects.hashCode(suePwmOutput11);
        result = 31 * result + Objects.hashCode(suePwmOutput12);
        result = 31 * result + Objects.hashCode(sueImuLocationX);
        result = 31 * result + Objects.hashCode(sueImuLocationY);
        result = 31 * result + Objects.hashCode(sueImuLocationZ);
        result = 31 * result + Objects.hashCode(sueLocationErrorEarthX);
        result = 31 * result + Objects.hashCode(sueLocationErrorEarthY);
        result = 31 * result + Objects.hashCode(sueLocationErrorEarthZ);
        result = 31 * result + Objects.hashCode(sueFlags);
        result = 31 * result + Objects.hashCode(sueOscFails);
        result = 31 * result + Objects.hashCode(sueImuVelocityX);
        result = 31 * result + Objects.hashCode(sueImuVelocityY);
        result = 31 * result + Objects.hashCode(sueImuVelocityZ);
        result = 31 * result + Objects.hashCode(sueWaypointGoalX);
        result = 31 * result + Objects.hashCode(sueWaypointGoalY);
        result = 31 * result + Objects.hashCode(sueWaypointGoalZ);
        result = 31 * result + Objects.hashCode(sueAeroX);
        result = 31 * result + Objects.hashCode(sueAeroY);
        result = 31 * result + Objects.hashCode(sueAeroZ);
        result = 31 * result + Objects.hashCode(sueBaromTemp);
        result = 31 * result + Objects.hashCode(sueBaromPress);
        result = 31 * result + Objects.hashCode(sueBaromAlt);
        result = 31 * result + Objects.hashCode(sueBatVolt);
        result = 31 * result + Objects.hashCode(sueBatAmp);
        result = 31 * result + Objects.hashCode(sueBatAmpHours);
        result = 31 * result + Objects.hashCode(sueDesiredHeight);
        result = 31 * result + Objects.hashCode(sueMemoryStackFree);
        return result;
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF2B{sueTime=" + sueTime
                 + ", suePwmInput1=" + suePwmInput1
                 + ", suePwmInput2=" + suePwmInput2
                 + ", suePwmInput3=" + suePwmInput3
                 + ", suePwmInput4=" + suePwmInput4
                 + ", suePwmInput5=" + suePwmInput5
                 + ", suePwmInput6=" + suePwmInput6
                 + ", suePwmInput7=" + suePwmInput7
                 + ", suePwmInput8=" + suePwmInput8
                 + ", suePwmInput9=" + suePwmInput9
                 + ", suePwmInput10=" + suePwmInput10
                 + ", suePwmInput11=" + suePwmInput11
                 + ", suePwmInput12=" + suePwmInput12
                 + ", suePwmOutput1=" + suePwmOutput1
                 + ", suePwmOutput2=" + suePwmOutput2
                 + ", suePwmOutput3=" + suePwmOutput3
                 + ", suePwmOutput4=" + suePwmOutput4
                 + ", suePwmOutput5=" + suePwmOutput5
                 + ", suePwmOutput6=" + suePwmOutput6
                 + ", suePwmOutput7=" + suePwmOutput7
                 + ", suePwmOutput8=" + suePwmOutput8
                 + ", suePwmOutput9=" + suePwmOutput9
                 + ", suePwmOutput10=" + suePwmOutput10
                 + ", suePwmOutput11=" + suePwmOutput11
                 + ", suePwmOutput12=" + suePwmOutput12
                 + ", sueImuLocationX=" + sueImuLocationX
                 + ", sueImuLocationY=" + sueImuLocationY
                 + ", sueImuLocationZ=" + sueImuLocationZ
                 + ", sueLocationErrorEarthX=" + sueLocationErrorEarthX
                 + ", sueLocationErrorEarthY=" + sueLocationErrorEarthY
                 + ", sueLocationErrorEarthZ=" + sueLocationErrorEarthZ
                 + ", sueFlags=" + sueFlags
                 + ", sueOscFails=" + sueOscFails
                 + ", sueImuVelocityX=" + sueImuVelocityX
                 + ", sueImuVelocityY=" + sueImuVelocityY
                 + ", sueImuVelocityZ=" + sueImuVelocityZ
                 + ", sueWaypointGoalX=" + sueWaypointGoalX
                 + ", sueWaypointGoalY=" + sueWaypointGoalY
                 + ", sueWaypointGoalZ=" + sueWaypointGoalZ
                 + ", sueAeroX=" + sueAeroX
                 + ", sueAeroY=" + sueAeroY
                 + ", sueAeroZ=" + sueAeroZ
                 + ", sueBaromTemp=" + sueBaromTemp
                 + ", sueBaromPress=" + sueBaromPress
                 + ", sueBaromAlt=" + sueBaromAlt
                 + ", sueBatVolt=" + sueBatVolt
                 + ", sueBatAmp=" + sueBatAmp
                 + ", sueBatAmpHours=" + sueBatAmpHours
                 + ", sueDesiredHeight=" + sueDesiredHeight
                 + ", sueMemoryStackFree=" + sueMemoryStackFree + "}";
    }

    public static SerialUdbExtraF2B deserialize(ByteBuffer input) {
        long sueTime = PayloadFieldDecoder.decodeUint32(input);
        long sueFlags = PayloadFieldDecoder.decodeUint32(input);
        int sueBaromPress = PayloadFieldDecoder.decodeInt32(input);
        int sueBaromAlt = PayloadFieldDecoder.decodeInt32(input);
        int suePwmInput1 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput2 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput3 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput4 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput5 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput6 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput7 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput8 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput9 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput10 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput11 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmInput12 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput1 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput2 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput3 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput4 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput5 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput6 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput7 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput8 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput9 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput10 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput11 = PayloadFieldDecoder.decodeInt16(input);
        int suePwmOutput12 = PayloadFieldDecoder.decodeInt16(input);
        int sueImuLocationX = PayloadFieldDecoder.decodeInt16(input);
        int sueImuLocationY = PayloadFieldDecoder.decodeInt16(input);
        int sueImuLocationZ = PayloadFieldDecoder.decodeInt16(input);
        int sueLocationErrorEarthX = PayloadFieldDecoder.decodeInt16(input);
        int sueLocationErrorEarthY = PayloadFieldDecoder.decodeInt16(input);
        int sueLocationErrorEarthZ = PayloadFieldDecoder.decodeInt16(input);
        int sueOscFails = PayloadFieldDecoder.decodeInt16(input);
        int sueImuVelocityX = PayloadFieldDecoder.decodeInt16(input);
        int sueImuVelocityY = PayloadFieldDecoder.decodeInt16(input);
        int sueImuVelocityZ = PayloadFieldDecoder.decodeInt16(input);
        int sueWaypointGoalX = PayloadFieldDecoder.decodeInt16(input);
        int sueWaypointGoalY = PayloadFieldDecoder.decodeInt16(input);
        int sueWaypointGoalZ = PayloadFieldDecoder.decodeInt16(input);
        int sueAeroX = PayloadFieldDecoder.decodeInt16(input);
        int sueAeroY = PayloadFieldDecoder.decodeInt16(input);
        int sueAeroZ = PayloadFieldDecoder.decodeInt16(input);
        int sueBaromTemp = PayloadFieldDecoder.decodeInt16(input);
        int sueBatVolt = PayloadFieldDecoder.decodeInt16(input);
        int sueBatAmp = PayloadFieldDecoder.decodeInt16(input);
        int sueBatAmpHours = PayloadFieldDecoder.decodeInt16(input);
        int sueDesiredHeight = PayloadFieldDecoder.decodeInt16(input);
        int sueMemoryStackFree = PayloadFieldDecoder.decodeInt16(input);
        return new SerialUdbExtraF2B(sueTime, suePwmInput1, suePwmInput2, suePwmInput3, suePwmInput4, suePwmInput5, suePwmInput6, suePwmInput7, suePwmInput8, suePwmInput9, suePwmInput10, suePwmInput11, suePwmInput12, suePwmOutput1, suePwmOutput2, suePwmOutput3, suePwmOutput4, suePwmOutput5, suePwmOutput6, suePwmOutput7, suePwmOutput8, suePwmOutput9, suePwmOutput10, suePwmOutput11, suePwmOutput12, sueImuLocationX, sueImuLocationY, sueImuLocationZ, sueLocationErrorEarthX, sueLocationErrorEarthY, sueLocationErrorEarthZ, sueFlags, sueOscFails, sueImuVelocityX, sueImuVelocityY, sueImuVelocityZ, sueWaypointGoalX, sueWaypointGoalY, sueWaypointGoalZ, sueAeroX, sueAeroY, sueAeroZ, sueBaromTemp, sueBaromPress, sueBaromAlt, sueBatVolt, sueBatAmp, sueBatAmpHours, sueDesiredHeight, sueMemoryStackFree);
    }

    public static final class Builder {
        private long sueTime;

        private int suePwmInput1;

        private int suePwmInput2;

        private int suePwmInput3;

        private int suePwmInput4;

        private int suePwmInput5;

        private int suePwmInput6;

        private int suePwmInput7;

        private int suePwmInput8;

        private int suePwmInput9;

        private int suePwmInput10;

        private int suePwmInput11;

        private int suePwmInput12;

        private int suePwmOutput1;

        private int suePwmOutput2;

        private int suePwmOutput3;

        private int suePwmOutput4;

        private int suePwmOutput5;

        private int suePwmOutput6;

        private int suePwmOutput7;

        private int suePwmOutput8;

        private int suePwmOutput9;

        private int suePwmOutput10;

        private int suePwmOutput11;

        private int suePwmOutput12;

        private int sueImuLocationX;

        private int sueImuLocationY;

        private int sueImuLocationZ;

        private int sueLocationErrorEarthX;

        private int sueLocationErrorEarthY;

        private int sueLocationErrorEarthZ;

        private long sueFlags;

        private int sueOscFails;

        private int sueImuVelocityX;

        private int sueImuVelocityY;

        private int sueImuVelocityZ;

        private int sueWaypointGoalX;

        private int sueWaypointGoalY;

        private int sueWaypointGoalZ;

        private int sueAeroX;

        private int sueAeroY;

        private int sueAeroZ;

        private int sueBaromTemp;

        private int sueBaromPress;

        private int sueBaromAlt;

        private int sueBatVolt;

        private int sueBatAmp;

        private int sueBatAmpHours;

        private int sueDesiredHeight;

        private int sueMemoryStackFree;

        /**
         * Serial UDB Extra Time 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Serial UDB Extra Time"
        )
        public final Builder sueTime(long sueTime) {
            this.sueTime = sueTime;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 1 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 1"
        )
        public final Builder suePwmInput1(int suePwmInput1) {
            this.suePwmInput1 = suePwmInput1;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 2 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 2"
        )
        public final Builder suePwmInput2(int suePwmInput2) {
            this.suePwmInput2 = suePwmInput2;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 3 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 3"
        )
        public final Builder suePwmInput3(int suePwmInput3) {
            this.suePwmInput3 = suePwmInput3;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 4 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 4"
        )
        public final Builder suePwmInput4(int suePwmInput4) {
            this.suePwmInput4 = suePwmInput4;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 5 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 5"
        )
        public final Builder suePwmInput5(int suePwmInput5) {
            this.suePwmInput5 = suePwmInput5;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 6 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 6"
        )
        public final Builder suePwmInput6(int suePwmInput6) {
            this.suePwmInput6 = suePwmInput6;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 7 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 7"
        )
        public final Builder suePwmInput7(int suePwmInput7) {
            this.suePwmInput7 = suePwmInput7;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 8 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 8"
        )
        public final Builder suePwmInput8(int suePwmInput8) {
            this.suePwmInput8 = suePwmInput8;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 9 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 9"
        )
        public final Builder suePwmInput9(int suePwmInput9) {
            this.suePwmInput9 = suePwmInput9;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 10 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 10"
        )
        public final Builder suePwmInput10(int suePwmInput10) {
            this.suePwmInput10 = suePwmInput10;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 11 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 11"
        )
        public final Builder suePwmInput11(int suePwmInput11) {
            this.suePwmInput11 = suePwmInput11;
            return this;
        }

        /**
         * Serial UDB Extra PWM Input Channel 12 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Input Channel 12"
        )
        public final Builder suePwmInput12(int suePwmInput12) {
            this.suePwmInput12 = suePwmInput12;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 1 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 1"
        )
        public final Builder suePwmOutput1(int suePwmOutput1) {
            this.suePwmOutput1 = suePwmOutput1;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 2 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 2"
        )
        public final Builder suePwmOutput2(int suePwmOutput2) {
            this.suePwmOutput2 = suePwmOutput2;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 3 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 3"
        )
        public final Builder suePwmOutput3(int suePwmOutput3) {
            this.suePwmOutput3 = suePwmOutput3;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 4 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 4"
        )
        public final Builder suePwmOutput4(int suePwmOutput4) {
            this.suePwmOutput4 = suePwmOutput4;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 5 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 5"
        )
        public final Builder suePwmOutput5(int suePwmOutput5) {
            this.suePwmOutput5 = suePwmOutput5;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 6 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 6"
        )
        public final Builder suePwmOutput6(int suePwmOutput6) {
            this.suePwmOutput6 = suePwmOutput6;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 7 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 7"
        )
        public final Builder suePwmOutput7(int suePwmOutput7) {
            this.suePwmOutput7 = suePwmOutput7;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 8 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 8"
        )
        public final Builder suePwmOutput8(int suePwmOutput8) {
            this.suePwmOutput8 = suePwmOutput8;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 9 
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 9"
        )
        public final Builder suePwmOutput9(int suePwmOutput9) {
            this.suePwmOutput9 = suePwmOutput9;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 10 
         */
        @MavlinkFieldInfo(
                position = 23,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 10"
        )
        public final Builder suePwmOutput10(int suePwmOutput10) {
            this.suePwmOutput10 = suePwmOutput10;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 11 
         */
        @MavlinkFieldInfo(
                position = 24,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 11"
        )
        public final Builder suePwmOutput11(int suePwmOutput11) {
            this.suePwmOutput11 = suePwmOutput11;
            return this;
        }

        /**
         * Serial UDB Extra PWM Output Channel 12 
         */
        @MavlinkFieldInfo(
                position = 25,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra PWM Output Channel 12"
        )
        public final Builder suePwmOutput12(int suePwmOutput12) {
            this.suePwmOutput12 = suePwmOutput12;
            return this;
        }

        /**
         * Serial UDB Extra IMU Location X 
         */
        @MavlinkFieldInfo(
                position = 26,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra IMU Location X"
        )
        public final Builder sueImuLocationX(int sueImuLocationX) {
            this.sueImuLocationX = sueImuLocationX;
            return this;
        }

        /**
         * Serial UDB Extra IMU Location Y 
         */
        @MavlinkFieldInfo(
                position = 27,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra IMU Location Y"
        )
        public final Builder sueImuLocationY(int sueImuLocationY) {
            this.sueImuLocationY = sueImuLocationY;
            return this;
        }

        /**
         * Serial UDB Extra IMU Location Z 
         */
        @MavlinkFieldInfo(
                position = 28,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra IMU Location Z"
        )
        public final Builder sueImuLocationZ(int sueImuLocationZ) {
            this.sueImuLocationZ = sueImuLocationZ;
            return this;
        }

        /**
         * Serial UDB Location Error Earth X 
         */
        @MavlinkFieldInfo(
                position = 29,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Location Error Earth X"
        )
        public final Builder sueLocationErrorEarthX(int sueLocationErrorEarthX) {
            this.sueLocationErrorEarthX = sueLocationErrorEarthX;
            return this;
        }

        /**
         * Serial UDB Location Error Earth Y 
         */
        @MavlinkFieldInfo(
                position = 30,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Location Error Earth Y"
        )
        public final Builder sueLocationErrorEarthY(int sueLocationErrorEarthY) {
            this.sueLocationErrorEarthY = sueLocationErrorEarthY;
            return this;
        }

        /**
         * Serial UDB Location Error Earth Z 
         */
        @MavlinkFieldInfo(
                position = 31,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Location Error Earth Z"
        )
        public final Builder sueLocationErrorEarthZ(int sueLocationErrorEarthZ) {
            this.sueLocationErrorEarthZ = sueLocationErrorEarthZ;
            return this;
        }

        /**
         * Serial UDB Extra Status Flags 
         */
        @MavlinkFieldInfo(
                position = 32,
                unitSize = 4,
                description = "Serial UDB Extra Status Flags"
        )
        public final Builder sueFlags(long sueFlags) {
            this.sueFlags = sueFlags;
            return this;
        }

        /**
         * Serial UDB Extra Oscillator Failure Count 
         */
        @MavlinkFieldInfo(
                position = 33,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Oscillator Failure Count"
        )
        public final Builder sueOscFails(int sueOscFails) {
            this.sueOscFails = sueOscFails;
            return this;
        }

        /**
         * Serial UDB Extra IMU Velocity X 
         */
        @MavlinkFieldInfo(
                position = 34,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra IMU Velocity X"
        )
        public final Builder sueImuVelocityX(int sueImuVelocityX) {
            this.sueImuVelocityX = sueImuVelocityX;
            return this;
        }

        /**
         * Serial UDB Extra IMU Velocity Y 
         */
        @MavlinkFieldInfo(
                position = 35,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra IMU Velocity Y"
        )
        public final Builder sueImuVelocityY(int sueImuVelocityY) {
            this.sueImuVelocityY = sueImuVelocityY;
            return this;
        }

        /**
         * Serial UDB Extra IMU Velocity Z 
         */
        @MavlinkFieldInfo(
                position = 36,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra IMU Velocity Z"
        )
        public final Builder sueImuVelocityZ(int sueImuVelocityZ) {
            this.sueImuVelocityZ = sueImuVelocityZ;
            return this;
        }

        /**
         * Serial UDB Extra Current Waypoint Goal X 
         */
        @MavlinkFieldInfo(
                position = 37,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Current Waypoint Goal X"
        )
        public final Builder sueWaypointGoalX(int sueWaypointGoalX) {
            this.sueWaypointGoalX = sueWaypointGoalX;
            return this;
        }

        /**
         * Serial UDB Extra Current Waypoint Goal Y 
         */
        @MavlinkFieldInfo(
                position = 38,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Current Waypoint Goal Y"
        )
        public final Builder sueWaypointGoalY(int sueWaypointGoalY) {
            this.sueWaypointGoalY = sueWaypointGoalY;
            return this;
        }

        /**
         * Serial UDB Extra Current Waypoint Goal Z 
         */
        @MavlinkFieldInfo(
                position = 39,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Current Waypoint Goal Z"
        )
        public final Builder sueWaypointGoalZ(int sueWaypointGoalZ) {
            this.sueWaypointGoalZ = sueWaypointGoalZ;
            return this;
        }

        /**
         * Aeroforce in UDB X Axis 
         */
        @MavlinkFieldInfo(
                position = 40,
                unitSize = 2,
                signed = true,
                description = "Aeroforce in UDB X Axis"
        )
        public final Builder sueAeroX(int sueAeroX) {
            this.sueAeroX = sueAeroX;
            return this;
        }

        /**
         * Aeroforce in UDB Y Axis 
         */
        @MavlinkFieldInfo(
                position = 41,
                unitSize = 2,
                signed = true,
                description = "Aeroforce in UDB Y Axis"
        )
        public final Builder sueAeroY(int sueAeroY) {
            this.sueAeroY = sueAeroY;
            return this;
        }

        /**
         * Aeroforce in UDB Z axis 
         */
        @MavlinkFieldInfo(
                position = 42,
                unitSize = 2,
                signed = true,
                description = "Aeroforce in UDB Z axis"
        )
        public final Builder sueAeroZ(int sueAeroZ) {
            this.sueAeroZ = sueAeroZ;
            return this;
        }

        /**
         * SUE barometer temperature 
         */
        @MavlinkFieldInfo(
                position = 43,
                unitSize = 2,
                signed = true,
                description = "SUE barometer temperature"
        )
        public final Builder sueBaromTemp(int sueBaromTemp) {
            this.sueBaromTemp = sueBaromTemp;
            return this;
        }

        /**
         * SUE barometer pressure 
         */
        @MavlinkFieldInfo(
                position = 44,
                unitSize = 4,
                signed = true,
                description = "SUE barometer pressure"
        )
        public final Builder sueBaromPress(int sueBaromPress) {
            this.sueBaromPress = sueBaromPress;
            return this;
        }

        /**
         * SUE barometer altitude 
         */
        @MavlinkFieldInfo(
                position = 45,
                unitSize = 4,
                signed = true,
                description = "SUE barometer altitude"
        )
        public final Builder sueBaromAlt(int sueBaromAlt) {
            this.sueBaromAlt = sueBaromAlt;
            return this;
        }

        /**
         * SUE battery voltage 
         */
        @MavlinkFieldInfo(
                position = 46,
                unitSize = 2,
                signed = true,
                description = "SUE battery voltage"
        )
        public final Builder sueBatVolt(int sueBatVolt) {
            this.sueBatVolt = sueBatVolt;
            return this;
        }

        /**
         * SUE battery current 
         */
        @MavlinkFieldInfo(
                position = 47,
                unitSize = 2,
                signed = true,
                description = "SUE battery current"
        )
        public final Builder sueBatAmp(int sueBatAmp) {
            this.sueBatAmp = sueBatAmp;
            return this;
        }

        /**
         * SUE battery milli amp hours used 
         */
        @MavlinkFieldInfo(
                position = 48,
                unitSize = 2,
                signed = true,
                description = "SUE battery milli amp hours used"
        )
        public final Builder sueBatAmpHours(int sueBatAmpHours) {
            this.sueBatAmpHours = sueBatAmpHours;
            return this;
        }

        /**
         * Sue autopilot desired height 
         */
        @MavlinkFieldInfo(
                position = 49,
                unitSize = 2,
                signed = true,
                description = "Sue autopilot desired height"
        )
        public final Builder sueDesiredHeight(int sueDesiredHeight) {
            this.sueDesiredHeight = sueDesiredHeight;
            return this;
        }

        /**
         * Serial UDB Extra Stack Memory Free 
         */
        @MavlinkFieldInfo(
                position = 50,
                unitSize = 2,
                signed = true,
                description = "Serial UDB Extra Stack Memory Free"
        )
        public final Builder sueMemoryStackFree(int sueMemoryStackFree) {
            this.sueMemoryStackFree = sueMemoryStackFree;
            return this;
        }

        public final SerialUdbExtraF2B build() {
            return new SerialUdbExtraF2B(sueTime, suePwmInput1, suePwmInput2, suePwmInput3, suePwmInput4, suePwmInput5, suePwmInput6, suePwmInput7, suePwmInput8, suePwmInput9, suePwmInput10, suePwmInput11, suePwmInput12, suePwmOutput1, suePwmOutput2, suePwmOutput3, suePwmOutput4, suePwmOutput5, suePwmOutput6, suePwmOutput7, suePwmOutput8, suePwmOutput9, suePwmOutput10, suePwmOutput11, suePwmOutput12, sueImuLocationX, sueImuLocationY, sueImuLocationZ, sueLocationErrorEarthX, sueLocationErrorEarthY, sueLocationErrorEarthZ, sueFlags, sueOscFails, sueImuVelocityX, sueImuVelocityY, sueImuVelocityZ, sueWaypointGoalX, sueWaypointGoalY, sueWaypointGoalZ, sueAeroX, sueAeroY, sueAeroZ, sueBaromTemp, sueBaromPress, sueBaromAlt, sueBatVolt, sueBatAmp, sueBatAmpHours, sueDesiredHeight, sueMemoryStackFree);
        }
    }
}
