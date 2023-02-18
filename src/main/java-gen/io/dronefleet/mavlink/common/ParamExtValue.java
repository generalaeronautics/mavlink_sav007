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
 * Emit the value of a parameter. The inclusion of param_count and param_index in the message 
 * allows the recipient to keep track of received parameters and allows them to re-request 
 * missing parameters after a loss or timeout. 
 */
@MavlinkMessageInfo(
        id = 322,
        crc = 243,
        description = "Emit the value of a parameter. The inclusion of param_count and param_index in the message allows the recipient to keep track of received parameters and allows them to re-request missing parameters after a loss or timeout."
)
public final class ParamExtValue {
    private final String paramId;

    private final String paramValue;

    private final EnumValue<MavParamExtType> paramType;

    private final int paramCount;

    private final int paramIndex;

    private ParamExtValue(String paramId, String paramValue, EnumValue<MavParamExtType> paramType,
            int paramCount, int paramIndex) {
        this.paramId = paramId;
        this.paramValue = paramValue;
        this.paramType = paramType;
        this.paramCount = paramCount;
        this.paramIndex = paramIndex;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 16,
            description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
    )
    public final String paramId() {
        return this.paramId;
    }

    /**
     * Parameter value 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 128,
            description = "Parameter value"
    )
    public final String paramValue() {
        return this.paramValue;
    }

    /**
     * Parameter type. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavParamExtType.class,
            description = "Parameter type."
    )
    public final EnumValue<MavParamExtType> paramType() {
        return this.paramType;
    }

    /**
     * Total number of parameters 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Total number of parameters"
    )
    public final int paramCount() {
        return this.paramCount;
    }

    /**
     * Index of this parameter 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Index of this parameter"
    )
    public final int paramIndex() {
        return this.paramIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamExtValue other = (ParamExtValue)o;
        if (!Objects.deepEquals(paramId, other.paramId)) return false;
        if (!Objects.deepEquals(paramValue, other.paramValue)) return false;
        if (!Objects.deepEquals(paramType, other.paramType)) return false;
        if (!Objects.deepEquals(paramCount, other.paramCount)) return false;
        if (!Objects.deepEquals(paramIndex, other.paramIndex)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(paramId);
        result = 31 * result + Objects.hashCode(paramValue);
        result = 31 * result + Objects.hashCode(paramType);
        result = 31 * result + Objects.hashCode(paramCount);
        result = 31 * result + Objects.hashCode(paramIndex);
        return result;
    }

    @Override
    public String toString() {
        return "ParamExtValue{paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType
                 + ", paramCount=" + paramCount
                 + ", paramIndex=" + paramIndex + "}";
    }

    public static ParamExtValue deserialize(ByteBuffer input) {
        int paramCount = PayloadFieldDecoder.decodeUint16(input);
        int paramIndex = PayloadFieldDecoder.decodeUint16(input);
        String paramId = PayloadFieldDecoder.decodeString(input, 16);
        String paramValue = PayloadFieldDecoder.decodeString(input, 128);
        EnumValue<MavParamExtType> paramType = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.MavParamExtType.class, input, 1);
        return new ParamExtValue(paramId, paramValue, paramType, paramCount, paramIndex);
    }

    public static final class Builder {
        private String paramId;

        private String paramValue;

        private EnumValue<MavParamExtType> paramType;

        private int paramCount;

        private int paramIndex;

        /**
         * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
         * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
         * 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 16,
                description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
        )
        public final Builder paramId(String paramId) {
            this.paramId = paramId;
            return this;
        }

        /**
         * Parameter value 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 128,
                description = "Parameter value"
        )
        public final Builder paramValue(String paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Parameter type. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavParamExtType.class,
                description = "Parameter type."
        )
        public final Builder paramType(EnumValue<MavParamExtType> paramType) {
            this.paramType = paramType;
            return this;
        }

        /**
         * Parameter type. 
         */
        public final Builder paramType(MavParamExtType entry) {
            return paramType(EnumValue.of(entry));
        }

        /**
         * Parameter type. 
         */
        public final Builder paramType(Enum... flags) {
            return paramType(EnumValue.create(flags));
        }

        /**
         * Parameter type. 
         */
        public final Builder paramType(Collection<Enum> flags) {
            return paramType(EnumValue.create(flags));
        }

        /**
         * Total number of parameters 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Total number of parameters"
        )
        public final Builder paramCount(int paramCount) {
            this.paramCount = paramCount;
            return this;
        }

        /**
         * Index of this parameter 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Index of this parameter"
        )
        public final Builder paramIndex(int paramIndex) {
            this.paramIndex = paramIndex;
            return this;
        }

        public final ParamExtValue build() {
            return new ParamExtValue(paramId, paramValue, paramType, paramCount, paramIndex);
        }
    }
}
