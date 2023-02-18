package io.dronefleet.mavlink.asluav;

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
 * Off-board controls/commands for ASLUAVs 
 */
@MavlinkMessageInfo(
        id = 8008,
        crc = 234,
        description = "Off-board controls/commands for ASLUAVs"
)
public final class AslObctrl {
    private final BigInteger timestamp;

    private final float uelev;

    private final float uthrot;

    private final float uthrot2;

    private final float uaill;

    private final float uailr;

    private final float urud;

    private final int obctrlStatus;

    private AslObctrl(BigInteger timestamp, float uelev, float uthrot, float uthrot2, float uaill,
            float uailr, float urud, int obctrlStatus) {
        this.timestamp = timestamp;
        this.uelev = uelev;
        this.uthrot = uthrot;
        this.uthrot2 = uthrot2;
        this.uaill = uaill;
        this.uailr = uailr;
        this.urud = urud;
        this.obctrlStatus = obctrlStatus;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time since system start 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Time since system start"
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * Elevator command [~] 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Elevator command [~]"
    )
    public final float uelev() {
        return this.uelev;
    }

    /**
     * Throttle command [~] 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Throttle command [~]"
    )
    public final float uthrot() {
        return this.uthrot;
    }

    /**
     * Throttle 2 command [~] 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Throttle 2 command [~]"
    )
    public final float uthrot2() {
        return this.uthrot2;
    }

    /**
     * Left aileron command [~] 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Left aileron command [~]"
    )
    public final float uaill() {
        return this.uaill;
    }

    /**
     * Right aileron command [~] 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Right aileron command [~]"
    )
    public final float uailr() {
        return this.uailr;
    }

    /**
     * Rudder command [~] 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Rudder command [~]"
    )
    public final float urud() {
        return this.urud;
    }

    /**
     * Off-board computer status 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "Off-board computer status"
    )
    public final int obctrlStatus() {
        return this.obctrlStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AslObctrl other = (AslObctrl)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(uelev, other.uelev)) return false;
        if (!Objects.deepEquals(uthrot, other.uthrot)) return false;
        if (!Objects.deepEquals(uthrot2, other.uthrot2)) return false;
        if (!Objects.deepEquals(uaill, other.uaill)) return false;
        if (!Objects.deepEquals(uailr, other.uailr)) return false;
        if (!Objects.deepEquals(urud, other.urud)) return false;
        if (!Objects.deepEquals(obctrlStatus, other.obctrlStatus)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(uelev);
        result = 31 * result + Objects.hashCode(uthrot);
        result = 31 * result + Objects.hashCode(uthrot2);
        result = 31 * result + Objects.hashCode(uaill);
        result = 31 * result + Objects.hashCode(uailr);
        result = 31 * result + Objects.hashCode(urud);
        result = 31 * result + Objects.hashCode(obctrlStatus);
        return result;
    }

    @Override
    public String toString() {
        return "AslObctrl{timestamp=" + timestamp
                 + ", uelev=" + uelev
                 + ", uthrot=" + uthrot
                 + ", uthrot2=" + uthrot2
                 + ", uaill=" + uaill
                 + ", uailr=" + uailr
                 + ", urud=" + urud
                 + ", obctrlStatus=" + obctrlStatus + "}";
    }

    public static AslObctrl deserialize(ByteBuffer input) {
        BigInteger timestamp = PayloadFieldDecoder.decodeUint64(input);
        float uelev = PayloadFieldDecoder.decodeFloat(input);
        float uthrot = PayloadFieldDecoder.decodeFloat(input);
        float uthrot2 = PayloadFieldDecoder.decodeFloat(input);
        float uaill = PayloadFieldDecoder.decodeFloat(input);
        float uailr = PayloadFieldDecoder.decodeFloat(input);
        float urud = PayloadFieldDecoder.decodeFloat(input);
        int obctrlStatus = PayloadFieldDecoder.decodeUint8(input);
        return new AslObctrl(timestamp, uelev, uthrot, uthrot2, uaill, uailr, urud, obctrlStatus);
    }

    public static final class Builder {
        private BigInteger timestamp;

        private float uelev;

        private float uthrot;

        private float uthrot2;

        private float uaill;

        private float uailr;

        private float urud;

        private int obctrlStatus;

        /**
         * Time since system start 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Time since system start"
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Elevator command [~] 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Elevator command [~]"
        )
        public final Builder uelev(float uelev) {
            this.uelev = uelev;
            return this;
        }

        /**
         * Throttle command [~] 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Throttle command [~]"
        )
        public final Builder uthrot(float uthrot) {
            this.uthrot = uthrot;
            return this;
        }

        /**
         * Throttle 2 command [~] 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Throttle 2 command [~]"
        )
        public final Builder uthrot2(float uthrot2) {
            this.uthrot2 = uthrot2;
            return this;
        }

        /**
         * Left aileron command [~] 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Left aileron command [~]"
        )
        public final Builder uaill(float uaill) {
            this.uaill = uaill;
            return this;
        }

        /**
         * Right aileron command [~] 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Right aileron command [~]"
        )
        public final Builder uailr(float uailr) {
            this.uailr = uailr;
            return this;
        }

        /**
         * Rudder command [~] 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Rudder command [~]"
        )
        public final Builder urud(float urud) {
            this.urud = urud;
            return this;
        }

        /**
         * Off-board computer status 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                description = "Off-board computer status"
        )
        public final Builder obctrlStatus(int obctrlStatus) {
            this.obctrlStatus = obctrlStatus;
            return this;
        }

        public final AslObctrl build() {
            return new AslObctrl(timestamp, uelev, uthrot, uthrot2, uaill, uailr, urud, obctrlStatus);
        }
    }
}
