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
 * Message to configure a camera mount, directional antenna, etc. 
 */
@MavlinkMessageInfo(
        id = 156,
        crc = 19,
        description = "Message to configure a camera mount, directional antenna, etc."
)
public final class MountConfigure {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<MavMountMode> mountMode;

    private final int stabRoll;

    private final int stabPitch;

    private final int stabYaw;

    private MountConfigure(int targetSystem, int targetComponent, EnumValue<MavMountMode> mountMode,
            int stabRoll, int stabPitch, int stabYaw) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.mountMode = mountMode;
        this.stabRoll = stabRoll;
        this.stabPitch = stabPitch;
        this.stabYaw = stabYaw;
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
     * Mount operating mode. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavMountMode.class,
            description = "Mount operating mode."
    )
    public final EnumValue<MavMountMode> mountMode() {
        return this.mountMode;
    }

    /**
     * (1 = yes, 0 = no). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "(1 = yes, 0 = no)."
    )
    public final int stabRoll() {
        return this.stabRoll;
    }

    /**
     * (1 = yes, 0 = no). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "(1 = yes, 0 = no)."
    )
    public final int stabPitch() {
        return this.stabPitch;
    }

    /**
     * (1 = yes, 0 = no). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "(1 = yes, 0 = no)."
    )
    public final int stabYaw() {
        return this.stabYaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MountConfigure other = (MountConfigure)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(mountMode, other.mountMode)) return false;
        if (!Objects.deepEquals(stabRoll, other.stabRoll)) return false;
        if (!Objects.deepEquals(stabPitch, other.stabPitch)) return false;
        if (!Objects.deepEquals(stabYaw, other.stabYaw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(mountMode);
        result = 31 * result + Objects.hashCode(stabRoll);
        result = 31 * result + Objects.hashCode(stabPitch);
        result = 31 * result + Objects.hashCode(stabYaw);
        return result;
    }

    @Override
    public String toString() {
        return "MountConfigure{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", mountMode=" + mountMode
                 + ", stabRoll=" + stabRoll
                 + ", stabPitch=" + stabPitch
                 + ", stabYaw=" + stabYaw + "}";
    }

    public static MountConfigure deserialize(ByteBuffer input) {
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        EnumValue<MavMountMode> mountMode = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.MavMountMode.class, input, 1);
        int stabRoll = PayloadFieldDecoder.decodeUint8(input);
        int stabPitch = PayloadFieldDecoder.decodeUint8(input);
        int stabYaw = PayloadFieldDecoder.decodeUint8(input);
        return new MountConfigure(targetSystem, targetComponent, mountMode, stabRoll, stabPitch, stabYaw);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<MavMountMode> mountMode;

        private int stabRoll;

        private int stabPitch;

        private int stabYaw;

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
         * Mount operating mode. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavMountMode.class,
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

        /**
         * (1 = yes, 0 = no). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "(1 = yes, 0 = no)."
        )
        public final Builder stabRoll(int stabRoll) {
            this.stabRoll = stabRoll;
            return this;
        }

        /**
         * (1 = yes, 0 = no). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "(1 = yes, 0 = no)."
        )
        public final Builder stabPitch(int stabPitch) {
            this.stabPitch = stabPitch;
            return this;
        }

        /**
         * (1 = yes, 0 = no). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "(1 = yes, 0 = no)."
        )
        public final Builder stabYaw(int stabYaw) {
            this.stabYaw = stabYaw;
            return this;
        }

        public final MountConfigure build() {
            return new MountConfigure(targetSystem, targetComponent, mountMode, stabRoll, stabPitch, stabYaw);
        }
    }
}
