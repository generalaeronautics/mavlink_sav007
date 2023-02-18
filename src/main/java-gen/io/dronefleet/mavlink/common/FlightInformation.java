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
 * Information about flight since last arming. This can be requested using 
 * MAV_CMD_REQUEST_MESSAGE. 
 */
@MavlinkMessageInfo(
        id = 264,
        crc = 49,
        description = "Information about flight since last arming.\n"
                        + "        This can be requested using MAV_CMD_REQUEST_MESSAGE."
)
public final class FlightInformation {
    private final long timeBootMs;

    private final BigInteger armingTimeUtc;

    private final BigInteger takeoffTimeUtc;

    private final BigInteger flightUuid;

    private FlightInformation(long timeBootMs, BigInteger armingTimeUtc, BigInteger takeoffTimeUtc,
            BigInteger flightUuid) {
        this.timeBootMs = timeBootMs;
        this.armingTimeUtc = armingTimeUtc;
        this.takeoffTimeUtc = takeoffTimeUtc;
        this.flightUuid = flightUuid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            description = "Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown"
    )
    public final BigInteger armingTimeUtc() {
        return this.armingTimeUtc;
    }

    /**
     * Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 8,
            description = "Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown"
    )
    public final BigInteger takeoffTimeUtc() {
        return this.takeoffTimeUtc;
    }

    /**
     * Universally unique identifier (UUID) of flight, should correspond to name of log files 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8,
            description = "Universally unique identifier (UUID) of flight, should correspond to name of log files"
    )
    public final BigInteger flightUuid() {
        return this.flightUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FlightInformation other = (FlightInformation)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(armingTimeUtc, other.armingTimeUtc)) return false;
        if (!Objects.deepEquals(takeoffTimeUtc, other.takeoffTimeUtc)) return false;
        if (!Objects.deepEquals(flightUuid, other.flightUuid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(armingTimeUtc);
        result = 31 * result + Objects.hashCode(takeoffTimeUtc);
        result = 31 * result + Objects.hashCode(flightUuid);
        return result;
    }

    @Override
    public String toString() {
        return "FlightInformation{timeBootMs=" + timeBootMs
                 + ", armingTimeUtc=" + armingTimeUtc
                 + ", takeoffTimeUtc=" + takeoffTimeUtc
                 + ", flightUuid=" + flightUuid + "}";
    }

    public static FlightInformation deserialize(ByteBuffer input) {
        BigInteger armingTimeUtc = PayloadFieldDecoder.decodeUint64(input);
        BigInteger takeoffTimeUtc = PayloadFieldDecoder.decodeUint64(input);
        BigInteger flightUuid = PayloadFieldDecoder.decodeUint64(input);
        long timeBootMs = PayloadFieldDecoder.decodeUint32(input);
        return new FlightInformation(timeBootMs, armingTimeUtc, takeoffTimeUtc, flightUuid);
    }

    public static final class Builder {
        private long timeBootMs;

        private BigInteger armingTimeUtc;

        private BigInteger takeoffTimeUtc;

        private BigInteger flightUuid;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown"
        )
        public final Builder armingTimeUtc(BigInteger armingTimeUtc) {
            this.armingTimeUtc = armingTimeUtc;
            return this;
        }

        /**
         * Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 8,
                description = "Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown"
        )
        public final Builder takeoffTimeUtc(BigInteger takeoffTimeUtc) {
            this.takeoffTimeUtc = takeoffTimeUtc;
            return this;
        }

        /**
         * Universally unique identifier (UUID) of flight, should correspond to name of log files 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 8,
                description = "Universally unique identifier (UUID) of flight, should correspond to name of log files"
        )
        public final Builder flightUuid(BigInteger flightUuid) {
            this.flightUuid = flightUuid;
            return this;
        }

        public final FlightInformation build() {
            return new FlightInformation(timeBootMs, armingTimeUtc, takeoffTimeUtc, flightUuid);
        }
    }
}
