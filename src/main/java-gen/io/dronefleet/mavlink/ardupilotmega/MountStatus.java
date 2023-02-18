package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.MavMountMode;
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
 * Message with some status from autopilot to GCS about camera or antenna mount. 
 */
@MavlinkMessageInfo(
        id = 158,
        crc = 134,
        description = "Message with some status from autopilot to GCS about camera or antenna mount."
)
public final class MountStatus {
    private final int targetSystem;

    private final int targetComponent;

    private final int pointingA;

    private final int pointingB;

    private final int pointingC;

    private final EnumValue<MavMountMode> mountMode;

    private MountStatus(int targetSystem, int targetComponent, int pointingA, int pointingB,
            int pointingC, EnumValue<MavMountMode> mountMode) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.pointingA = pointingA;
        this.pointingB = pointingB;
        this.pointingC = pointingC;
        this.mountMode = mountMode;
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
     * Pitch. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Pitch."
    )
    public final int pointingA() {
        return this.pointingA;
    }

    /**
     * Roll. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Roll."
    )
    public final int pointingB() {
        return this.pointingB;
    }

    /**
     * Yaw. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Yaw."
    )
    public final int pointingC() {
        return this.pointingC;
    }

    /**
     * Mount operating mode. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            enumType = MavMountMode.class,
            extension = true,
            description = "Mount operating mode."
    )
    public final EnumValue<MavMountMode> mountMode() {
        return this.mountMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MountStatus other = (MountStatus)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(pointingA, other.pointingA)) return false;
        if (!Objects.deepEquals(pointingB, other.pointingB)) return false;
        if (!Objects.deepEquals(pointingC, other.pointingC)) return false;
        if (!Objects.deepEquals(mountMode, other.mountMode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(pointingA);
        result = 31 * result + Objects.hashCode(pointingB);
        result = 31 * result + Objects.hashCode(pointingC);
        result = 31 * result + Objects.hashCode(mountMode);
        return result;
    }

    @Override
    public String toString() {
        return "MountStatus{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", pointingA=" + pointingA
                 + ", pointingB=" + pointingB
                 + ", pointingC=" + pointingC
                 + ", mountMode=" + mountMode + "}";
    }

    public static MountStatus deserialize(ByteBuffer input) {
        int pointingA = PayloadFieldDecoder.decodeInt32(input);
        int pointingB = PayloadFieldDecoder.decodeInt32(input);
        int pointingC = PayloadFieldDecoder.decodeInt32(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        EnumValue<MavMountMode> mountMode = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.MavMountMode.class, input, 1);
        return new MountStatus(targetSystem, targetComponent, pointingA, pointingB, pointingC, mountMode);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int pointingA;

        private int pointingB;

        private int pointingC;

        private EnumValue<MavMountMode> mountMode;

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
         * Pitch. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Pitch."
        )
        public final Builder pointingA(int pointingA) {
            this.pointingA = pointingA;
            return this;
        }

        /**
         * Roll. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Roll."
        )
        public final Builder pointingB(int pointingB) {
            this.pointingB = pointingB;
            return this;
        }

        /**
         * Yaw. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Yaw."
        )
        public final Builder pointingC(int pointingC) {
            this.pointingC = pointingC;
            return this;
        }

        /**
         * Mount operating mode. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                enumType = MavMountMode.class,
                extension = true,
                description = "Mount operating mode."
        )
        public final Builder mountMode(EnumValue<MavMountMode> mountMode) {
            this.mountMode = mountMode;
            return this;
        }

        /**
         * Mount operating mode. 
         */
        public final Builder mountMode(MavMountMode entry) {
            return mountMode(EnumValue.of(entry));
        }

        /**
         * Mount operating mode. 
         */
        public final Builder mountMode(Enum... flags) {
            return mountMode(EnumValue.create(flags));
        }

        /**
         * Mount operating mode. 
         */
        public final Builder mountMode(Collection<Enum> flags) {
            return mountMode(EnumValue.create(flags));
        }

        public final MountStatus build() {
            return new MountStatus(targetSystem, targetComponent, pointingA, pointingB, pointingC, mountMode);
        }
    }
}
