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
 * Control for camara. 
 */
@MavlinkMessageInfo(
        id = 188,
        crc = 5,
        description = "Control for camara."
)
public final class SlugsConfigurationCamera {
    private final int target;

    private final int idorder;

    private final int order;

    private SlugsConfigurationCamera(int target, int idorder, int order) {
        this.target = target;
        this.idorder = idorder;
        this.order = order;
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
     * ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight"
    )
    public final int idorder() {
        return this.idorder;
    }

    /**
     * 1: up/on 2: down/off 3: auto/reset/no action 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "1: up/on 2: down/off 3: auto/reset/no action"
    )
    public final int order() {
        return this.order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SlugsConfigurationCamera other = (SlugsConfigurationCamera)o;
        if (!Objects.deepEquals(target, other.target)) return false;
        if (!Objects.deepEquals(idorder, other.idorder)) return false;
        if (!Objects.deepEquals(order, other.order)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(target);
        result = 31 * result + Objects.hashCode(idorder);
        result = 31 * result + Objects.hashCode(order);
        return result;
    }

    @Override
    public String toString() {
        return "SlugsConfigurationCamera{target=" + target
                 + ", idorder=" + idorder
                 + ", order=" + order + "}";
    }

    public static SlugsConfigurationCamera deserialize(ByteBuffer input) {
        int target = PayloadFieldDecoder.decodeUint8(input);
        int idorder = PayloadFieldDecoder.decodeUint8(input);
        int order = PayloadFieldDecoder.decodeUint8(input);
        return new SlugsConfigurationCamera(target, idorder, order);
    }

    public static final class Builder {
        private int target;

        private int idorder;

        private int order;

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
         * ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight"
        )
        public final Builder idorder(int idorder) {
            this.idorder = idorder;
            return this;
        }

        /**
         * 1: up/on 2: down/off 3: auto/reset/no action 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "1: up/on 2: down/off 3: auto/reset/no action"
        )
        public final Builder order(int order) {
            this.order = order;
            return this;
        }

        public final SlugsConfigurationCamera build() {
            return new SlugsConfigurationCamera(target, idorder, order);
        }
    }
}
