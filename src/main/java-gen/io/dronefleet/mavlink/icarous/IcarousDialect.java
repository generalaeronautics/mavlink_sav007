package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Object;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class IcarousDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Collections.emptyList();

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(42000, IcarousHeartbeat.class)
            .put(42001, IcarousKinematicBands.class)
            .build();

    private static final Map<Class, Function<ByteBuffer, Object>> deserializers = new UnmodifiableMapBuilder<Class, Function<ByteBuffer, Object>>()
            .put(IcarousHeartbeat.class, IcarousHeartbeat::deserialize)
            .put(IcarousKinematicBands.class, IcarousKinematicBands::deserialize)
            .build();

    public IcarousDialect() {
        super("icarous", dependencies, messages, deserializers);
    }
}
