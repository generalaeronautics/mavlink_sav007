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
 * This message is emitted as response to {@link io.dronefleet.mavlink.common.MissionRequestList MISSION_REQUEST_LIST} by the MAV and to initiate a write 
 * transaction. The GCS can then request the individual mission item based on the knowledge of the 
 * total number of waypoints. 
 */
@MavlinkMessageInfo(
        id = 44,
        crc = 221,
        description = "This message is emitted as response to MISSION_REQUEST_LIST by the MAV and to initiate a write transaction. The GCS can then request the individual mission item based on the knowledge of the total number of waypoints."
)
public final class MissionCount {
    private final int targetSystem;

    private final int targetComponent;

    private final int count;

    private final EnumValue<MavMissionType> missionType;

    private MissionCount(int targetSystem, int targetComponent, int count,
            EnumValue<MavMissionType> missionType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.count = count;
        this.missionType = missionType;
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
     * Number of mission items in the sequence 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Number of mission items in the sequence"
    )
    public final int count() {
        return this.count;
    }

    /**
     * Mission type. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavMissionType.class,
            extension = true,
            description = "Mission type."
    )
    public final EnumValue<MavMissionType> missionType() {
        return this.missionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionCount other = (MissionCount)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(missionType, other.missionType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(missionType);
        return result;
    }

    @Override
    public String toString() {
        return "MissionCount{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", count=" + count
                 + ", missionType=" + missionType + "}";
    }

    public static MissionCount deserialize(ByteBuffer input) {
        int count = PayloadFieldDecoder.decodeUint16(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        EnumValue<MavMissionType> missionType = PayloadFieldDecoder.decodeEnum(io.dronefleet.mavlink.common.MavMissionType.class, input, 1);
        return new MissionCount(targetSystem, targetComponent, count, missionType);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int count;

        private EnumValue<MavMissionType> missionType;

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
         * Number of mission items in the sequence 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Number of mission items in the sequence"
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Mission type. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavMissionType.class,
                extension = true,
                description = "Mission type."
        )
        public final Builder missionType(EnumValue<MavMissionType> missionType) {
            this.missionType = missionType;
            return this;
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(MavMissionType entry) {
            return missionType(EnumValue.of(entry));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Enum... flags) {
            return missionType(EnumValue.create(flags));
        }

        /**
         * Mission type. 
         */
        public final Builder missionType(Collection<Enum> flags) {
            return missionType(EnumValue.create(flags));
        }

        public final MissionCount build() {
            return new MissionCount(targetSystem, targetComponent, count, missionType);
        }
    }
}
