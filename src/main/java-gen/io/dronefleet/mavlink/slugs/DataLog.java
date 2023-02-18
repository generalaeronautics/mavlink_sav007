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
 * Configurable data log probes to be used inside Simulink 
 */
@MavlinkMessageInfo(
        id = 177,
        crc = 167,
        description = "Configurable data log probes to be used inside Simulink"
)
public final class DataLog {
    private final float fl1;

    private final float fl2;

    private final float fl3;

    private final float fl4;

    private final float fl5;

    private final float fl6;

    private DataLog(float fl1, float fl2, float fl3, float fl4, float fl5, float fl6) {
        this.fl1 = fl1;
        this.fl2 = fl2;
        this.fl3 = fl3;
        this.fl4 = fl4;
        this.fl5 = fl5;
        this.fl6 = fl6;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Log value 1 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Log value 1"
    )
    public final float fl1() {
        return this.fl1;
    }

    /**
     * Log value 2 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Log value 2"
    )
    public final float fl2() {
        return this.fl2;
    }

    /**
     * Log value 3 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Log value 3"
    )
    public final float fl3() {
        return this.fl3;
    }

    /**
     * Log value 4 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Log value 4"
    )
    public final float fl4() {
        return this.fl4;
    }

    /**
     * Log value 5 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Log value 5"
    )
    public final float fl5() {
        return this.fl5;
    }

    /**
     * Log value 6 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Log value 6"
    )
    public final float fl6() {
        return this.fl6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DataLog other = (DataLog)o;
        if (!Objects.deepEquals(fl1, other.fl1)) return false;
        if (!Objects.deepEquals(fl2, other.fl2)) return false;
        if (!Objects.deepEquals(fl3, other.fl3)) return false;
        if (!Objects.deepEquals(fl4, other.fl4)) return false;
        if (!Objects.deepEquals(fl5, other.fl5)) return false;
        if (!Objects.deepEquals(fl6, other.fl6)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(fl1);
        result = 31 * result + Objects.hashCode(fl2);
        result = 31 * result + Objects.hashCode(fl3);
        result = 31 * result + Objects.hashCode(fl4);
        result = 31 * result + Objects.hashCode(fl5);
        result = 31 * result + Objects.hashCode(fl6);
        return result;
    }

    @Override
    public String toString() {
        return "DataLog{fl1=" + fl1
                 + ", fl2=" + fl2
                 + ", fl3=" + fl3
                 + ", fl4=" + fl4
                 + ", fl5=" + fl5
                 + ", fl6=" + fl6 + "}";
    }

    public static DataLog deserialize(ByteBuffer input) {
        float fl1 = PayloadFieldDecoder.decodeFloat(input);
        float fl2 = PayloadFieldDecoder.decodeFloat(input);
        float fl3 = PayloadFieldDecoder.decodeFloat(input);
        float fl4 = PayloadFieldDecoder.decodeFloat(input);
        float fl5 = PayloadFieldDecoder.decodeFloat(input);
        float fl6 = PayloadFieldDecoder.decodeFloat(input);
        return new DataLog(fl1, fl2, fl3, fl4, fl5, fl6);
    }

    public static final class Builder {
        private float fl1;

        private float fl2;

        private float fl3;

        private float fl4;

        private float fl5;

        private float fl6;

        /**
         * Log value 1 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Log value 1"
        )
        public final Builder fl1(float fl1) {
            this.fl1 = fl1;
            return this;
        }

        /**
         * Log value 2 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Log value 2"
        )
        public final Builder fl2(float fl2) {
            this.fl2 = fl2;
            return this;
        }

        /**
         * Log value 3 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Log value 3"
        )
        public final Builder fl3(float fl3) {
            this.fl3 = fl3;
            return this;
        }

        /**
         * Log value 4 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Log value 4"
        )
        public final Builder fl4(float fl4) {
            this.fl4 = fl4;
            return this;
        }

        /**
         * Log value 5 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Log value 5"
        )
        public final Builder fl5(float fl5) {
            this.fl5 = fl5;
            return this;
        }

        /**
         * Log value 6 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Log value 6"
        )
        public final Builder fl6(float fl6) {
            this.fl6 = fl6;
            return this;
        }

        public final DataLog build() {
            return new DataLog(fl1, fl2, fl3, fl4, fl5, fl6);
        }
    }
}
