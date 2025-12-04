package io.github.fajzu;

import io.papermc.paper.math.Position;
import org.bukkit.Color;
import org.bukkit.Location;

import java.util.UUID;

public class WaypointBuilder {

    private UUID uuid = UUID.randomUUID();

    private Position position;
    private Color color = Color.WHITE;

    private WaypointStyle style = WaypointStyle.DEFAULT;

    private WaypointBuilder() {
    }

    private WaypointBuilder(final Waypoint waypoint) {
        this.uuid = waypoint.uuid();
        this.position = waypoint.position();
        this.color = waypoint.color();
        this.style = waypoint.style();
    }

    public static WaypointBuilder builder() {
        return new WaypointBuilder();
    }

    public static WaypointBuilder builder(final Waypoint waypoint) {
        return new WaypointBuilder(waypoint);
    }

    public WaypointBuilder uuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public WaypointBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public WaypointBuilder position(Position position) {
        this.position = position;
        return this;
    }

    public WaypointBuilder style(WaypointStyle style) {
        this.style = style;
        return this;
    }

    public Waypoint build() {
        return new Waypoint(
                this.uuid,
                this.position,
                this.color,
                this.style
        );
    }
}
