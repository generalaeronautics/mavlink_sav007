package io.dronefleet.mavlink.ardupilotmega;

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
 * Control on-board Camera Control System to take shots. 
 */
@MavlinkMessageInfo(
        id = 155,
        crc = 22,
        description = "Control on-board Camera Control System to take shots."
)
public final class DigicamControl {
    private final int targetSystem;

    private final int targetComponent;

    private final int session;

    private final int zoomPos;

    private final int zoomStep;

    private final int focusLock;

    private final int shot;

    private final int commandId;

    private final int extraParam;

    private final float extraValue;

    private DigicamControl(int targetSystem, int targetComponent, int session, int zoomPos,
            int zoomStep, int focusLock, int shot, int commandId, int extraParam,
            float extraValue) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.session = session;
        this.zoomPos = zoomPos;
        this.zoomStep = zoomStep;
        this.focusLock = focusLock;
        this.shot = shot;
        this.commandId = commandId;
        this.extraParam = extraParam;
        this.extraValue = extraValue;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "0: stop, 1: start or keep it up //Session control e.g. show/hide lens."
    )
    public final int session() {
        return this.session;
    }

    /**
     * 1 to N //Zoom's absolute position (0 means ignore). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "1 to N //Zoom's absolute position (0 means ignore)."
    )
    public final int zoomPos() {
        return this.zoomPos;
    }

    /**
     * -100 to 100 //Zooming step value to offset zoom from the current position. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            signed = true,
            description = "-100 to 100 //Zooming step value to offset zoom from the current position."
    )
    public final int zoomStep() {
        return this.zoomStep;
    }

    /**
     * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus."
    )
    public final int focusLock() {
        return this.focusLock;
    }

    /**
     * 0: ignore, 1: shot or start filming. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "0: ignore, 1: shot or start filming."
    )
    public final int shot() {
        return this.shot;
    }

    /**
     * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
     * or pooled just once. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed or pooled just once."
    )
    public final int commandId() {
        return this.commandId;
    }

    /**
     * Extra parameters enumeration (0 means ignore). 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            description = "Extra parameters enumeration (0 means ignore)."
    )
    public final int extraParam() {
        return this.extraParam;
    }

    /**
     * Correspondent value to given extra_param. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Correspondent value to given extra_param."
    )
    public final float extraValue() {
        return this.extraValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DigicamControl other = (DigicamControl)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(session, other.session)) return false;
        if (!Objects.deepEquals(zoomPos, other.zoomPos)) return false;
        if (!Objects.deepEquals(zoomStep, other.zoomStep)) return false;
        if (!Objects.deepEquals(focusLock, other.focusLock)) return false;
        if (!Objects.deepEquals(shot, other.shot)) return false;
        if (!Objects.deepEquals(commandId, other.commandId)) return false;
        if (!Objects.deepEquals(extraParam, other.extraParam)) return false;
        if (!Objects.deepEquals(extraValue, other.extraValue)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(session);
        result = 31 * result + Objects.hashCode(zoomPos);
        result = 31 * result + Objects.hashCode(zoomStep);
        result = 31 * result + Objects.hashCode(focusLock);
        result = 31 * result + Objects.hashCode(shot);
        result = 31 * result + Objects.hashCode(commandId);
        result = 31 * result + Objects.hashCode(extraParam);
        result = 31 * result + Objects.hashCode(extraValue);
        return result;
    }

    @Override
    public String toString() {
        return "DigicamControl{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", session=" + session
                 + ", zoomPos=" + zoomPos
                 + ", zoomStep=" + zoomStep
                 + ", focusLock=" + focusLock
                 + ", shot=" + shot
                 + ", commandId=" + commandId
                 + ", extraParam=" + extraParam
                 + ", extraValue=" + extraValue + "}";
    }

    public static DigicamControl deserialize(ByteBuffer input) {
        float extraValue = PayloadFieldDecoder.decodeFloat(input);
        int targetSystem = PayloadFieldDecoder.decodeUint8(input);
        int targetComponent = PayloadFieldDecoder.decodeUint8(input);
        int session = PayloadFieldDecoder.decodeUint8(input);
        int zoomPos = PayloadFieldDecoder.decodeUint8(input);
        int zoomStep = PayloadFieldDecoder.decodeInt8(input);
        int focusLock = PayloadFieldDecoder.decodeUint8(input);
        int shot = PayloadFieldDecoder.decodeUint8(input);
        int commandId = PayloadFieldDecoder.decodeUint8(input);
        int extraParam = PayloadFieldDecoder.decodeUint8(input);
        return new DigicamControl(targetSystem, targetComponent, session, zoomPos, zoomStep, focusLock, shot, commandId, extraParam, extraValue);
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int session;

        private int zoomPos;

        private int zoomStep;

        private int focusLock;

        private int shot;

        private int commandId;

        private int extraParam;

        private float extraValue;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "0: stop, 1: start or keep it up //Session control e.g. show/hide lens."
        )
        public final Builder session(int session) {
            this.session = session;
            return this;
        }

        /**
         * 1 to N //Zoom's absolute position (0 means ignore). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "1 to N //Zoom's absolute position (0 means ignore)."
        )
        public final Builder zoomPos(int zoomPos) {
            this.zoomPos = zoomPos;
            return this;
        }

        /**
         * -100 to 100 //Zooming step value to offset zoom from the current position. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                signed = true,
                description = "-100 to 100 //Zooming step value to offset zoom from the current position."
        )
        public final Builder zoomStep(int zoomStep) {
            this.zoomStep = zoomStep;
            return this;
        }

        /**
         * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus."
        )
        public final Builder focusLock(int focusLock) {
            this.focusLock = focusLock;
            return this;
        }

        /**
         * 0: ignore, 1: shot or start filming. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "0: ignore, 1: shot or start filming."
        )
        public final Builder shot(int shot) {
            this.shot = shot;
            return this;
        }

        /**
         * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
         * or pooled just once. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                description = "Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed or pooled just once."
        )
        public final Builder commandId(int commandId) {
            this.commandId = commandId;
            return this;
        }

        /**
         * Extra parameters enumeration (0 means ignore). 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                description = "Extra parameters enumeration (0 means ignore)."
        )
        public final Builder extraParam(int extraParam) {
            this.extraParam = extraParam;
            return this;
        }

        /**
         * Correspondent value to given extra_param. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Correspondent value to given extra_param."
        )
        public final Builder extraValue(float extraValue) {
            this.extraValue = extraValue;
            return this;
        }

        public final DigicamControl build() {
            return new DigicamControl(targetSystem, targetComponent, session, zoomPos, zoomStep, focusLock, shot, commandId, extraParam, extraValue);
        }
    }
}
