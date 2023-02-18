package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.serialization.payload.PayloadFieldDecoder;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp 
 * will disable signing 
 */
@MavlinkMessageInfo(
        id = 256,
        crc = 71,
        description = "Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp will disable signing"
)
public final class SetupSigning {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] secretKey;

    private final BigInteger initialTimestamp;

    private SetupSigning(int targetSystem, int targetComponent, byte[] secretKey,
            BigInteger initialTimestamp) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.secretKey = secretKey;
        this.initialTimestamp = initialTimestamp;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * system id of the target 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "system id of the target"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "component ID of the target"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * signing key 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 32,
            description = "signing key"
    )
    public final byte[] secretKey() {
        return this.secretKey;
    }

    /**
     * initial timestamp 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8,
            description = "initial timestamp"
    )
    public final BigInteger initialTimestamp() {
        return this.initialTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SetupSigning other = (SetupSigning)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(secretKey, other.secretKey)) return false;
        if (!Objects.deepEquals(initialTimestamp, other.initialTimestamp)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(secretKey);
        result = 31 * result + Objects.hashCode(initialTimestamp);
        return result;
    }

    @Override
    public String toString() {
        return "SetupSigning{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", secretKey=" + secretKey
                 + ", initialTimestamp=" + initialTimestamp + "}";
    }

    public static SetupSigning deserialize(ByteBuffer input) {
        BigInteger initialTimestamp = PayloadFieldDecoder.decodeUint64(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        byte[] secretKey = PayloadFieldDecoder.decodeUint8Array(input, 32);
        return new SetupSigning(targetSystem, targetComponent, secretKey, initialTimestamp);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private byte[] secretKey;

        private BigInteger initialTimestamp;

        /**
         * system id of the target 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "system id of the target"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * component ID of the target 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "component ID of the target"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * signing key 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 32,
                description = "signing key"
        )
        public final Builder secretKey(byte[] secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        /**
         * initial timestamp 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 8,
                description = "initial timestamp"
        )
        public final Builder initialTimestamp(BigInteger initialTimestamp) {
            this.initialTimestamp = initialTimestamp;
            return this;
        }

        public final SetupSigning build() {
            return new SetupSigning(targetSystem, targetComponent, secretKey, initialTimestamp);
        }
    }
}
