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
 * Message to control a camera mount, directional antenna, etc. 
 */
@MavlinkMessageInfo(
        id = 157,
        crc = 21,
        description = "Message to control a camera mount, directional antenna, etc."
)
public final class MountControl {
    private final int targetSystem;

    private final int targetComponent;

    private final int inputA;

    private final int inputB;

    private final int inputC;

    private final int savePosition;

    private MountControl(int targetSystem, int targetComponent, int inputA, int inputB, int inputC,
            int savePosition) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.inputA = inputA;
        this.inputB = inputB;
        this.inputC = inputC;
        this.savePosition = savePosition;
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
     * Pitch (centi-degrees) or lat (degE7), depending on mount mode. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Pitch (centi-degrees) or lat (degE7), depending on mount mode."
    )
    public final int inputA() {
        return this.inputA;
    }

    /**
     * Roll (centi-degrees) or lon (degE7) depending on mount mode. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Roll (centi-degrees) or lon (degE7) depending on mount mode."
    )
    public final int inputB() {
        return this.inputB;
    }

    /**
     * Yaw (centi-degrees) or alt (cm) depending on mount mode. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Yaw (centi-degrees) or alt (cm) depending on mount mode."
    )
    public final int inputC() {
        return this.inputC;
    }

    /**
     * If "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "If \"1\" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING)."
    )
    public final int savePosition() {
        return this.savePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MountControl other = (MountControl)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(inputA, other.inputA)) return false;
        if (!Objects.deepEquals(inputB, other.inputB)) return false;
        if (!Objects.deepEquals(inputC, other.inputC)) return false;
        if (!Objects.deepEquals(savePosition, other.savePosition)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(inputA);
        result = 31 * result + Objects.hashCode(inputB);
        result = 31 * result + Objects.hashCode(inputC);
        result = 31 * result + Objects.hashCode(savePosition);
        return result;
    }

    @Override
    public String toString() {
        return "MountControl{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", inputA=" + inputA
                 + ", inputB=" + inputB
                 + ", inputC=" + inputC
                 + ", savePosition=" + savePosition + "}";
    }

    public static MountControl deserialize(ByteBuffer input) {
        int inputA = PayloadFieldDecoder.decodeInt32(input);
        int inputB = PayloadFieldDecoder.decodeInt32(input);
        int inputC = PayloadFieldDecoder.decodeInt32(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        int savePosition = PayloadFieldDecoder.decodeUint8(input);
        return new MountControl(targetSystem, targetComponent, inputA, inputB, inputC, savePosition);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int inputA;

        private int inputB;

        private int inputC;

        private int savePosition;

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
         * Pitch (centi-degrees) or lat (degE7), depending on mount mode. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Pitch (centi-degrees) or lat (degE7), depending on mount mode."
        )
        public final Builder inputA(int inputA) {
            this.inputA = inputA;
            return this;
        }

        /**
         * Roll (centi-degrees) or lon (degE7) depending on mount mode. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Roll (centi-degrees) or lon (degE7) depending on mount mode."
        )
        public final Builder inputB(int inputB) {
            this.inputB = inputB;
            return this;
        }

        /**
         * Yaw (centi-degrees) or alt (cm) depending on mount mode. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Yaw (centi-degrees) or alt (cm) depending on mount mode."
        )
        public final Builder inputC(int inputC) {
            this.inputC = inputC;
            return this;
        }

        /**
         * If "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "If \"1\" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING)."
        )
        public final Builder savePosition(int savePosition) {
            this.savePosition = savePosition;
            return this;
        }

        public final MountControl build() {
            return new MountControl(targetSystem, targetComponent, inputA, inputB, inputC, savePosition);
        }
    }
}
