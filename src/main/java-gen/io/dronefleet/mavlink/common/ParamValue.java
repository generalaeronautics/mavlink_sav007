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
 * Emit the value of a onboard parameter. The inclusion of param_count and param_index in the 
 * message allows the recipient to keep track of received parameters and allows him to re-request 
 * missing parameters after a loss or timeout. The parameter microservice is documented at 
 * https://mavlink.io/en/services/parameter.html 
 */
@MavlinkMessageInfo(
        id = 22,
        crc = 220,
        description = "Emit the value of a onboard parameter. The inclusion of param_count and param_index in the message allows the recipient to keep track of received parameters and allows him to re-request missing parameters after a loss or timeout. The parameter microservice is documented at https://mavlink.io/en/services/parameter.html"
)
public final class ParamValue {
    private final String paramId;

    private final float paramValue;

    private final EnumValue<MavParamType> paramType;

    private final int paramCount;

    private final int paramIndex;

    private ParamValue(String paramId, float paramValue, EnumValue<MavParamType> paramType,
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
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 16,
            description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
    )
    public final String paramId() {
        return this.paramId;
    }

    /**
     * Onboard parameter value 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Onboard parameter value"
    )
    public final float paramValue() {
        return this.paramValue;
    }

    /**
     * Onboard parameter type. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavParamType.class,
            description = "Onboard parameter type."
    )
    public final EnumValue<MavParamType> paramType() {
        return this.paramType;
    }

    /**
     * Total number of onboard parameters 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Total number of onboard parameters"
    )
    public final int paramCount() {
        return this.paramCount;
    }

    /**
     * Index of this onboard parameter 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Index of this onboard parameter"
    )
    public final int paramIndex() {
        return this.paramIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamValue other = (ParamValue)o;
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
        return "ParamValue{paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType
                 + ", paramCount=" + paramCount
                 + ", paramIndex=" + paramIndex + "}";
    }

    public static ParamValue deserialize(ByteBuffer input) {
        float paramValue = PayloadFieldDecoder.decodeFloat(input);
        int paramCount = PayloadFieldDecoder.decodeUint16(input);
        int paramIndex = PayloadFieldDecoder.decodeUint16(input);
        String paramId = PayloadFieldDecoder.decodeString(input, 16);
        EnumValue<MavParamType> paramType = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.MavParamType.class, input, 1);
        return new ParamValue(paramId, paramValue, paramType, paramCount, paramIndex);
    }

    public static final class Builder {
        private String paramId;

        private float paramValue;

        private EnumValue<MavParamType> paramType;

        private int paramCount;

        private int paramIndex;

        /**
         * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
         * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
         * provide 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 16,
                description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
        )
        public final Builder paramId(String paramId) {
            this.paramId = paramId;
            return this;
        }

        /**
         * Onboard parameter value 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Onboard parameter value"
        )
        public final Builder paramValue(float paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Onboard parameter type. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavParamType.class,
                description = "Onboard parameter type."
        )
        public final Builder paramType(EnumValue<MavParamType> paramType) {
            this.paramType = paramType;
            return this;
        }

        /**
         * Onboard parameter type. 
         */
        public final Builder paramType(MavParamType entry) {
            return paramType(EnumValue.of(entry));
        }

        /**
         * Onboard parameter type. 
         */
        public final Builder paramType(Enum... flags) {
            return paramType(EnumValue.create(flags));
        }

        /**
         * Onboard parameter type. 
         */
        public final Builder paramType(Collection<Enum> flags) {
            return paramType(EnumValue.create(flags));
        }

        /**
         * Total number of onboard parameters 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Total number of onboard parameters"
        )
        public final Builder paramCount(int paramCount) {
            this.paramCount = paramCount;
            return this;
        }

        /**
         * Index of this onboard parameter 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Index of this onboard parameter"
        )
        public final Builder paramIndex(int paramIndex) {
            this.paramIndex = paramIndex;
            return this;
        }

        public final ParamValue build() {
            return new ParamValue(paramId, paramValue, paramType, paramCount, paramIndex);
        }
    }
}
