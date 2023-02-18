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
 * 100 Hz gimbal torque command telemetry. 
 */
@MavlinkMessageInfo(
        id = 214,
        crc = 69,
        description = "100 Hz gimbal torque command telemetry."
)
public final class GimbalTorqueCmdReport {
    private final int targetSystem;

    private final int targetComponent;

    private final int rlTorqueCmd;

    private final int elTorqueCmd;

    private final int azTorqueCmd;

    private GimbalTorqueCmdReport(int targetSystem, int targetComponent, int rlTorqueCmd,
            int elTorqueCmd, int azTorqueCmd) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.rlTorqueCmd = rlTorqueCmd;
        this.elTorqueCmd = elTorqueCmd;
        this.azTorqueCmd = azTorqueCmd;
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
     * Roll Torque Command. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Roll Torque Command."
    )
    public final int rlTorqueCmd() {
        return this.rlTorqueCmd;
    }

    /**
     * Elevation Torque Command. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Elevation Torque Command."
    )
    public final int elTorqueCmd() {
        return this.elTorqueCmd;
    }

    /**
     * Azimuth Torque Command. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "Azimuth Torque Command."
    )
    public final int azTorqueCmd() {
        return this.azTorqueCmd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalTorqueCmdReport other = (GimbalTorqueCmdReport)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(rlTorqueCmd, other.rlTorqueCmd)) return false;
        if (!Objects.deepEquals(elTorqueCmd, other.elTorqueCmd)) return false;
        if (!Objects.deepEquals(azTorqueCmd, other.azTorqueCmd)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(rlTorqueCmd);
        result = 31 * result + Objects.hashCode(elTorqueCmd);
        result = 31 * result + Objects.hashCode(azTorqueCmd);
        return result;
    }

    @Override
    public String toString() {
        return "GimbalTorqueCmdReport{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", rlTorqueCmd=" + rlTorqueCmd
                 + ", elTorqueCmd=" + elTorqueCmd
                 + ", azTorqueCmd=" + azTorqueCmd + "}";
    }

    public static GimbalTorqueCmdReport deserialize(ByteBuffer input) {
        int rlTorqueCmd = PayloadFieldDecoder.decodeInt16(input);
        int elTorqueCmd = PayloadFieldDecoder.decodeInt16(input);
        int azTorqueCmd = PayloadFieldDecoder.decodeInt16(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        return new GimbalTorqueCmdReport(targetSystem, targetComponent, rlTorqueCmd, elTorqueCmd, azTorqueCmd);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int rlTorqueCmd;

        private int elTorqueCmd;

        private int azTorqueCmd;

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
         * Roll Torque Command. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Roll Torque Command."
        )
        public final Builder rlTorqueCmd(int rlTorqueCmd) {
            this.rlTorqueCmd = rlTorqueCmd;
            return this;
        }

        /**
         * Elevation Torque Command. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Elevation Torque Command."
        )
        public final Builder elTorqueCmd(int elTorqueCmd) {
            this.elTorqueCmd = elTorqueCmd;
            return this;
        }

        /**
         * Azimuth Torque Command. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "Azimuth Torque Command."
        )
        public final Builder azTorqueCmd(int azTorqueCmd) {
            this.azTorqueCmd = azTorqueCmd;
            return this;
        }

        public final GimbalTorqueCmdReport build() {
            return new GimbalTorqueCmdReport(targetSystem, targetComponent, rlTorqueCmd, elTorqueCmd, azTorqueCmd);
        }
    }
}
