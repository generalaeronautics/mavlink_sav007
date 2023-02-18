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
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Objects;

/**
 * The IMU readings in SI units in NED body frame 
 */
@MavlinkMessageInfo(
        id = 107,
        crc = 108,
        description = "The IMU readings in SI units in NED body frame"
)
public final class HilSensor {
    private final BigInteger timeUsec;

    private final float xacc;

    private final float yacc;

    private final float zacc;

    private final float xgyro;

    private final float ygyro;

    private final float zgyro;

    private final float xmag;

    private final float ymag;

    private final float zmag;

    private final float absPressure;

    private final float diffPressure;

    private final float pressureAlt;

    private final float temperature;

    private final EnumValue<HilSensorUpdatedFlags> fieldsUpdated;

    private final int id;

    private HilSensor(BigInteger timeUsec, float xacc, float yacc, float zacc, float xgyro,
            float ygyro, float zgyro, float xmag, float ymag, float zmag, float absPressure,
            float diffPressure, float pressureAlt, float temperature,
            EnumValue<HilSensorUpdatedFlags> fieldsUpdated, int id) {
        this.timeUsec = timeUsec;
        this.xacc = xacc;
        this.yacc = yacc;
        this.zacc = zacc;
        this.xgyro = xgyro;
        this.ygyro = ygyro;
        this.zgyro = zgyro;
        this.xmag = xmag;
        this.ymag = ymag;
        this.zmag = zmag;
        this.absPressure = absPressure;
        this.diffPressure = diffPressure;
        this.pressureAlt = pressureAlt;
        this.temperature = temperature;
        this.fieldsUpdated = fieldsUpdated;
        this.id = id;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * X acceleration 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "X acceleration"
    )
    public final float xacc() {
        return this.xacc;
    }

    /**
     * Y acceleration 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Y acceleration"
    )
    public final float yacc() {
        return this.yacc;
    }

    /**
     * Z acceleration 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Z acceleration"
    )
    public final float zacc() {
        return this.zacc;
    }

    /**
     * Angular speed around X axis in body frame 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Angular speed around X axis in body frame"
    )
    public final float xgyro() {
        return this.xgyro;
    }

    /**
     * Angular speed around Y axis in body frame 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Angular speed around Y axis in body frame"
    )
    public final float ygyro() {
        return this.ygyro;
    }

    /**
     * Angular speed around Z axis in body frame 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Angular speed around Z axis in body frame"
    )
    public final float zgyro() {
        return this.zgyro;
    }

    /**
     * X Magnetic field 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "X Magnetic field"
    )
    public final float xmag() {
        return this.xmag;
    }

    /**
     * Y Magnetic field 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Y Magnetic field"
    )
    public final float ymag() {
        return this.ymag;
    }

    /**
     * Z Magnetic field 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Z Magnetic field"
    )
    public final float zmag() {
        return this.zmag;
    }

    /**
     * Absolute pressure 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Absolute pressure"
    )
    public final float absPressure() {
        return this.absPressure;
    }

    /**
     * Differential pressure (airspeed) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Differential pressure (airspeed)"
    )
    public final float diffPressure() {
        return this.diffPressure;
    }

    /**
     * Altitude calculated from pressure 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Altitude calculated from pressure"
    )
    public final float pressureAlt() {
        return this.pressureAlt;
    }

    /**
     * Temperature 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Temperature"
    )
    public final float temperature() {
        return this.temperature;
    }

    /**
     * Bitmap for fields that have updated since last message 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            enumType = HilSensorUpdatedFlags.class,
            description = "Bitmap for fields that have updated since last message"
    )
    public final EnumValue<HilSensorUpdatedFlags> fieldsUpdated() {
        return this.fieldsUpdated;
    }

    /**
     * Sensor ID (zero indexed). Used for multiple sensor inputs 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            extension = true,
            description = "Sensor ID (zero indexed). Used for multiple sensor inputs"
    )
    public final int id() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HilSensor other = (HilSensor)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(xacc, other.xacc)) return false;
        if (!Objects.deepEquals(yacc, other.yacc)) return false;
        if (!Objects.deepEquals(zacc, other.zacc)) return false;
        if (!Objects.deepEquals(xgyro, other.xgyro)) return false;
        if (!Objects.deepEquals(ygyro, other.ygyro)) return false;
        if (!Objects.deepEquals(zgyro, other.zgyro)) return false;
        if (!Objects.deepEquals(xmag, other.xmag)) return false;
        if (!Objects.deepEquals(ymag, other.ymag)) return false;
        if (!Objects.deepEquals(zmag, other.zmag)) return false;
        if (!Objects.deepEquals(absPressure, other.absPressure)) return false;
        if (!Objects.deepEquals(diffPressure, other.diffPressure)) return false;
        if (!Objects.deepEquals(pressureAlt, other.pressureAlt)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(fieldsUpdated, other.fieldsUpdated)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(xacc);
        result = 31 * result + Objects.hashCode(yacc);
        result = 31 * result + Objects.hashCode(zacc);
        result = 31 * result + Objects.hashCode(xgyro);
        result = 31 * result + Objects.hashCode(ygyro);
        result = 31 * result + Objects.hashCode(zgyro);
        result = 31 * result + Objects.hashCode(xmag);
        result = 31 * result + Objects.hashCode(ymag);
        result = 31 * result + Objects.hashCode(zmag);
        result = 31 * result + Objects.hashCode(absPressure);
        result = 31 * result + Objects.hashCode(diffPressure);
        result = 31 * result + Objects.hashCode(pressureAlt);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(fieldsUpdated);
        result = 31 * result + Objects.hashCode(id);
        return result;
    }

    @Override
    public String toString() {
        return "HilSensor{timeUsec=" + timeUsec
                 + ", xacc=" + xacc
                 + ", yacc=" + yacc
                 + ", zacc=" + zacc
                 + ", xgyro=" + xgyro
                 + ", ygyro=" + ygyro
                 + ", zgyro=" + zgyro
                 + ", xmag=" + xmag
                 + ", ymag=" + ymag
                 + ", zmag=" + zmag
                 + ", absPressure=" + absPressure
                 + ", diffPressure=" + diffPressure
                 + ", pressureAlt=" + pressureAlt
                 + ", temperature=" + temperature
                 + ", fieldsUpdated=" + fieldsUpdated
                 + ", id=" + id + "}";
    }

    public static HilSensor deserialize(ByteBuffer input) {
        BigInteger timeUsec = PayloadFieldDecoder.decodeUint64(input);
        float xacc = PayloadFieldDecoder.decodeFloat(input);
        float yacc = PayloadFieldDecoder.decodeFloat(input);
        float zacc = PayloadFieldDecoder.decodeFloat(input);
        float xgyro = PayloadFieldDecoder.decodeFloat(input);
        float ygyro = PayloadFieldDecoder.decodeFloat(input);
        float zgyro = PayloadFieldDecoder.decodeFloat(input);
        float xmag = PayloadFieldDecoder.decodeFloat(input);
        float ymag = PayloadFieldDecoder.decodeFloat(input);
        float zmag = PayloadFieldDecoder.decodeFloat(input);
        float absPressure = PayloadFieldDecoder.decodeFloat(input);
        float diffPressure = PayloadFieldDecoder.decodeFloat(input);
        float pressureAlt = PayloadFieldDecoder.decodeFloat(input);
        float temperature = PayloadFieldDecoder.decodeFloat(input);
        EnumValue<HilSensorUpdatedFlags> fieldsUpdated = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.HilSensorUpdatedFlags.class, input, 4);
        int id = PayloadFieldDecoder.decodeUint8(input);
        return new HilSensor(timeUsec, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag, absPressure, diffPressure, pressureAlt, temperature, fieldsUpdated, id);
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float xacc;

        private float yacc;

        private float zacc;

        private float xgyro;

        private float ygyro;

        private float zgyro;

        private float xmag;

        private float ymag;

        private float zmag;

        private float absPressure;

        private float diffPressure;

        private float pressureAlt;

        private float temperature;

        private EnumValue<HilSensorUpdatedFlags> fieldsUpdated;

        private int id;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * X acceleration 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "X acceleration"
        )
        public final Builder xacc(float xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Y acceleration"
        )
        public final Builder yacc(float yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Z acceleration"
        )
        public final Builder zacc(float zacc) {
            this.zacc = zacc;
            return this;
        }

        /**
         * Angular speed around X axis in body frame 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Angular speed around X axis in body frame"
        )
        public final Builder xgyro(float xgyro) {
            this.xgyro = xgyro;
            return this;
        }

        /**
         * Angular speed around Y axis in body frame 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Angular speed around Y axis in body frame"
        )
        public final Builder ygyro(float ygyro) {
            this.ygyro = ygyro;
            return this;
        }

        /**
         * Angular speed around Z axis in body frame 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Angular speed around Z axis in body frame"
        )
        public final Builder zgyro(float zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * X Magnetic field 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "X Magnetic field"
        )
        public final Builder xmag(float xmag) {
            this.xmag = xmag;
            return this;
        }

        /**
         * Y Magnetic field 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Y Magnetic field"
        )
        public final Builder ymag(float ymag) {
            this.ymag = ymag;
            return this;
        }

        /**
         * Z Magnetic field 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Z Magnetic field"
        )
        public final Builder zmag(float zmag) {
            this.zmag = zmag;
            return this;
        }

        /**
         * Absolute pressure 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Absolute pressure"
        )
        public final Builder absPressure(float absPressure) {
            this.absPressure = absPressure;
            return this;
        }

        /**
         * Differential pressure (airspeed) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Differential pressure (airspeed)"
        )
        public final Builder diffPressure(float diffPressure) {
            this.diffPressure = diffPressure;
            return this;
        }

        /**
         * Altitude calculated from pressure 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Altitude calculated from pressure"
        )
        public final Builder pressureAlt(float pressureAlt) {
            this.pressureAlt = pressureAlt;
            return this;
        }

        /**
         * Temperature 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Temperature"
        )
        public final Builder temperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Bitmap for fields that have updated since last message 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                enumType = HilSensorUpdatedFlags.class,
                description = "Bitmap for fields that have updated since last message"
        )
        public final Builder fieldsUpdated(EnumValue<HilSensorUpdatedFlags> fieldsUpdated) {
            this.fieldsUpdated = fieldsUpdated;
            return this;
        }

        /**
         * Bitmap for fields that have updated since last message 
         */
        public final Builder fieldsUpdated(HilSensorUpdatedFlags entry) {
            return fieldsUpdated(EnumValue.of(entry));
        }

        /**
         * Bitmap for fields that have updated since last message 
         */
        public final Builder fieldsUpdated(Enum... flags) {
            return fieldsUpdated(EnumValue.create(flags));
        }

        /**
         * Bitmap for fields that have updated since last message 
         */
        public final Builder fieldsUpdated(Collection<Enum> flags) {
            return fieldsUpdated(EnumValue.create(flags));
        }

        /**
         * Sensor ID (zero indexed). Used for multiple sensor inputs 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                extension = true,
                description = "Sensor ID (zero indexed). Used for multiple sensor inputs"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        public final HilSensor build() {
            return new HilSensor(timeUsec, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag, absPressure, diffPressure, pressureAlt, temperature, fieldsUpdated, id);
        }
    }
}
