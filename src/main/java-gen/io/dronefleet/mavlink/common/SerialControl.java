package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
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
 * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a 
 * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via 
 * MAVLink messages or change the devices settings. A message with zero bytes can be used to change 
 * just the baudrate. 
 */
@MavlinkMessageInfo(
        id = 126,
        crc = 220,
        description = "Control a serial port. This can be used for raw access to an onboard serial peripheral such as a GPS or telemetry radio. It is designed to make it possible to update the devices firmware via MAVLink messages or change the devices settings. A message with zero bytes can be used to change just the baudrate."
)
public final class SerialControl {
    private final EnumValue<SerialControlDev> device;

    private final EnumValue<SerialControlFlag> flags;

    private final int timeout;

    private final long baudrate;

    private final int count;

    private final byte[] data;

    private final int targetSystem;

    private final int targetComponent;

    private SerialControl(EnumValue<SerialControlDev> device, EnumValue<SerialControlFlag> flags,
            int timeout, long baudrate, int count, byte[] data, int targetSystem,
            int targetComponent) {
        this.device = device;
        this.flags = flags;
        this.timeout = timeout;
        this.baudrate = baudrate;
        this.count = count;
        this.data = data;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial control device type. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = SerialControlDev.class,
            description = "Serial control device type."
    )
    public final EnumValue<SerialControlDev> device() {
        return this.device;
    }

    /**
     * Bitmap of serial control flags. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = SerialControlFlag.class,
            description = "Bitmap of serial control flags."
    )
    public final EnumValue<SerialControlFlag> flags() {
        return this.flags;
    }

    /**
     * Timeout for reply data 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Timeout for reply data"
    )
    public final int timeout() {
        return this.timeout;
    }

    /**
     * Baudrate of transfer. Zero means no change. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Baudrate of transfer. Zero means no change."
    )
    public final long baudrate() {
        return this.baudrate;
    }

    /**
     * how many bytes in this transfer 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "how many bytes in this transfer"
    )
    public final int count() {
        return this.count;
    }

    /**
     * serial data 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 70,
            description = "serial data"
    )
    public final byte[] data() {
        return this.data;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            extension = true,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            extension = true,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialControl other = (SerialControl)o;
        if (!Objects.deepEquals(device, other.device)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(timeout, other.timeout)) return false;
        if (!Objects.deepEquals(baudrate, other.baudrate)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(device);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(timeout);
        result = 31 * result + Objects.hashCode(baudrate);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(data);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        return result;
    }

    @Override
    public String toString() {
        return "SerialControl{device=" + device
                 + ", flags=" + flags
                 + ", timeout=" + timeout
                 + ", baudrate=" + baudrate
                 + ", count=" + count
                 + ", data=" + data
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent + "}";
    }

    public static SerialControl deserialize(ByteBuffer input) {
        long baudrate = PayloadFieldDecoder.decodeUint32(input);
        int timeout = PayloadFieldDecoder.decodeUint16(input);
        EnumValue<SerialControlDev> device = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.SerialControlDev.class, input, 1);
        EnumValue<SerialControlFlag> flags = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.SerialControlFlag.class, input, 1);
        int count = PayloadFieldDecoder.decodeUint8(input);
        byte[] data = PayloadFieldDecoder.decodeUint8Array(input, 70);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        return new SerialControl(device, flags, timeout, baudrate, count, data, targetSystem, targetComponent);
    }

    public static final class Builder {
        private EnumValue<SerialControlDev> device;

        private EnumValue<SerialControlFlag> flags;

        private int timeout;

        private long baudrate;

        private int count;

        private byte[] data;

        private int targetSystem;

        private int targetComponent;

        /**
         * Serial control device type. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = SerialControlDev.class,
                description = "Serial control device type."
        )
        public final Builder device(EnumValue<SerialControlDev> device) {
            this.device = device;
            return this;
        }

        /**
         * Serial control device type. 
         */
        public final Builder device(SerialControlDev entry) {
            return device(EnumValue.of(entry));
        }

        /**
         * Serial control device type. 
         */
        public final Builder device(Enum... flags) {
            return device(EnumValue.create(flags));
        }

        /**
         * Serial control device type. 
         */
        public final Builder device(Collection<Enum> flags) {
            return device(EnumValue.create(flags));
        }

        /**
         * Bitmap of serial control flags. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = SerialControlFlag.class,
                description = "Bitmap of serial control flags."
        )
        public final Builder flags(EnumValue<SerialControlFlag> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Bitmap of serial control flags. 
         */
        public final Builder flags(SerialControlFlag entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Bitmap of serial control flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Bitmap of serial control flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Timeout for reply data 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Timeout for reply data"
        )
        public final Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Baudrate of transfer. Zero means no change. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Baudrate of transfer. Zero means no change."
        )
        public final Builder baudrate(long baudrate) {
            this.baudrate = baudrate;
            return this;
        }

        /**
         * how many bytes in this transfer 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "how many bytes in this transfer"
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * serial data 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 70,
                description = "serial data"
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                extension = true,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                extension = true,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        public final SerialControl build() {
            return new SerialControl(device, flags, timeout, baudrate, count, data, targetSystem, targetComponent);
        }
    }
}
