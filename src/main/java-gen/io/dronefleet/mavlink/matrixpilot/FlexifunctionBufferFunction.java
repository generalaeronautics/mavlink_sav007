package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

/**
 * Flexifunction type and parameters for component at function index from buffer 
 */
@MavlinkMessageInfo(
        id = 152,
        crc = 101,
        description = "Flexifunction type and parameters for component at function index from buffer"
)
public final class FlexifunctionBufferFunction {
    private final int targetSystem;

    private final int targetComponent;

    private final int funcIndex;

    private final int funcCount;

    private final int dataAddress;

    private final int dataSize;

    private final List<Integer> data;

    private FlexifunctionBufferFunction(int targetSystem, int targetComponent, int funcIndex,
            int funcCount, int dataAddress, int dataSize, List<Integer> data) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.funcIndex = funcIndex;
        this.funcCount = funcCount;
        this.dataAddress = dataAddress;
        this.dataSize = dataSize;
        this.data = data;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Function index 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Function index"
    )
    public final int funcIndex() {
        return this.funcIndex;
    }

    /**
     * Total count of functions 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Total count of functions"
    )
    public final int funcCount() {
        return this.funcCount;
    }

    /**
     * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Address in the flexifunction data, Set to 0xFFFF to use address in target memory"
    )
    public final int dataAddress() {
        return this.dataAddress;
    }

    /**
     * Size of the 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Size of the"
    )
    public final int dataSize() {
        return this.dataSize;
    }

    /**
     * Settings data 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 48,
            signed = true,
            description = "Settings data"
    )
    public final List<Integer> data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FlexifunctionBufferFunction other = (FlexifunctionBufferFunction)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(funcIndex, other.funcIndex)) return false;
        if (!Objects.deepEquals(funcCount, other.funcCount)) return false;
        if (!Objects.deepEquals(dataAddress, other.dataAddress)) return false;
        if (!Objects.deepEquals(dataSize, other.dataSize)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(funcIndex);
        result = 31 * result + Objects.hashCode(funcCount);
        result = 31 * result + Objects.hashCode(dataAddress);
        result = 31 * result + Objects.hashCode(dataSize);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "FlexifunctionBufferFunction{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", funcIndex=" + funcIndex
                 + ", funcCount=" + funcCount
                 + ", dataAddress=" + dataAddress
                 + ", dataSize=" + dataSize
                 + ", data=" + data + "}";
    }

    public static FlexifunctionBufferFunction deserialize(ByteBuffer input) {
        int funcIndex = PayloadFieldDecoder.decodeUint16(input);
        int funcCount = PayloadFieldDecoder.decodeUint16(input);
        int dataAddress = PayloadFieldDecoder.decodeUint16(input);
        int dataSize = PayloadFieldDecoder.decodeUint16(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        List<Integer> data = PayloadFieldDecoder.decodeInt8Array(input, 48);
        return new FlexifunctionBufferFunction(targetSystem, targetComponent, funcIndex, funcCount, dataAddress, dataSize, data);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int funcIndex;

        private int funcCount;

        private int dataAddress;

        private int dataSize;

        private List<Integer> data;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
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
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Function index 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Function index"
        )
        public final Builder funcIndex(int funcIndex) {
            this.funcIndex = funcIndex;
            return this;
        }

        /**
         * Total count of functions 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Total count of functions"
        )
        public final Builder funcCount(int funcCount) {
            this.funcCount = funcCount;
            return this;
        }

        /**
         * Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Address in the flexifunction data, Set to 0xFFFF to use address in target memory"
        )
        public final Builder dataAddress(int dataAddress) {
            this.dataAddress = dataAddress;
            return this;
        }

        /**
         * Size of the 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Size of the"
        )
        public final Builder dataSize(int dataSize) {
            this.dataSize = dataSize;
            return this;
        }

        /**
         * Settings data 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 48,
                signed = true,
                description = "Settings data"
        )
        public final Builder data(List<Integer> data) {
            this.data = data;
            return this;
        }

        public final FlexifunctionBufferFunction build() {
            return new FlexifunctionBufferFunction(targetSystem, targetComponent, funcIndex, funcCount, dataAddress, dataSize, data);
        }
    }
}
