package io.dronefleet.mavlink.common;

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
 * Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been 
 * kept simple, so transmitting the key requires an encrypted channel for true safety. 
 */
@MavlinkMessageInfo(
        id = 7,
        crc = 119,
        description = "Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been kept simple, so transmitting the key requires an encrypted channel for true safety."
)
public final class AuthKey {
    private final String key;

    private AuthKey(String key) {
        this.key = key;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * key 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 32,
            description = "key"
    )
    public final String key() {
        return this.key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AuthKey other = (AuthKey)o;
        if (!Objects.deepEquals(key, other.key)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(key);
        return result;
    }

    @Override
    public String toString() {
        return "AuthKey{key=" + key + "}";
    }

    public static AuthKey deserialize(ByteBuffer input) {
        String key = PayloadFieldDecoder.decodeString(input, 32);
        return new AuthKey(key);
    }

    public static final class Builder {
        private String key;

        /**
         * key 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 32,
                description = "key"
        )
        public final Builder key(String key) {
            this.key = key;
            return this;
        }

        public final AuthKey build() {
            return new AuthKey(key);
        }
    }
}
