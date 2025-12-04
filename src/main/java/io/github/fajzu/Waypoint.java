package io.github.fajzu;

import io.papermc.paper.math.Position;
import org.bukkit.Color;
import org.bukkit.Location;

import java.util.UUID;

public record Waypoint(UUID uuid,
                       Position position,
                       Color color,
                       WaypointStyle style) {

    public WaypointBuilder toBuilder() {
        return WaypointBuilder.builder(this);
    }
}
