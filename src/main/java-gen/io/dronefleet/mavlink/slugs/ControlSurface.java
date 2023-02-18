package io.dronefleet.mavlink.slugs;

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
 * Control for surface; pending and order to origin. 
 */
@MavlinkMessageInfo(
        id = 185,
        crc = 113,
        description = "Control for surface; pending and order to origin."
)
public final class ControlSurface {
    private final int target;

    private final int idsurface;

    private final float mcontrol;

    private final float bcontrol;

    private ControlSurface(int target, int idsurface, float mcontrol, float bcontrol) {
        this.target = target;
        this.idsurface = idsurface;
        this.mcontrol = mcontrol;
        this.bcontrol = bcontrol;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system setting the commands 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "The system setting the commands"
    )
    public final int target() {
        return this.target;
    }

    /**
     * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder"
    )
    public final int idsurface() {
        return this.idsurface;
    }

    /**
     * Pending 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Pending"
    )
    public final float mcontrol() {
        return this.mcontrol;
    }

    /**
     * Order to origin 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Order to origin"
    )
    public final float bcontrol() {
        return this.bcontrol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ControlSurface other = (ControlSurface)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(idsurface, other.idsurface)) return false;
        if (!Objects.deepEquals(mcontrol, other.mcontrol)) return false;
        if (!Objects.deepEquals(bcontrol, other.bcontrol)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(idsurface);
        result = 31 * result + Objects.hashCode(mcontrol);
        result = 31 * result + Objects.hashCode(bcontrol);
        return result;
    }

    @Override
    public String toString() {
        return "ControlSurface{target=" + target
                 + ", idsurface=" + idsurface
                 + ", mcontrol=" + mcontrol
                 + ", bcontrol=" + bcontrol + "}";
    }

    public static ControlSurface deserialize(ByteBuffer input) {
        float mcontrol = PayloadFieldDecoder.decodeFloat(input);
        float bcontrol = PayloadFieldDecoder.decodeFloat(input);
        int target = PayloadFieldDecoder.decodeUint8(input);
        int idsurface = PayloadFieldDecoder.decodeUint8(input);
        return new ControlSurface(target, idsurface, mcontrol, bcontrol);
    }

    public static final class Builder {
        private int target;

        private int idsurface;

        private float mcontrol;

        private float bcontrol;

        /**
         * The system setting the commands 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "The system setting the commands"
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder"
        )
        public final Builder idsurface(int idsurface) {
            this.idsurface = idsurface;
            return this;
        }

        /**
         * Pending 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Pending"
        )
        public final Builder mcontrol(float mcontrol) {
            this.mcontrol = mcontrol;
            return this;
        }

        /**
         * Order to origin 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Order to origin"
        )
        public final Builder bcontrol(float bcontrol) {
            this.bcontrol = bcontrol;
            return this;
        }

        public final ControlSurface build() {
            return new ControlSurface(target, idsurface, mcontrol, bcontrol);
        }
    }
}
