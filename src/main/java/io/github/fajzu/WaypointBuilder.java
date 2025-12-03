package io.github.fajzu;

import com.github.retrooper.packetevents.resources.ResourceLocation;
import org.bukkit.Color;
import org.bukkit.Location;

import java.util.UUID;

public class WaypointBuilder {

    private UUID uuid = UUID.randomUUID();
    private String name = "";

    private Location location;
    private Color color = Color.WHITE;

    private WaypointStyle style = WaypointStyle.DEFAULT;

    private WaypointBuilder() {
    }

    public static WaypointBuilder builder() {
        return new WaypointBuilder();
    }

    public WaypointBuilder uuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public WaypointBuilder name(String name) {
        this.name = name;
        return this;
    }

    public WaypointBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public WaypointBuilder location(Location location) {
        this.location = location;
        return this;
    }

    public WaypointBuilder style(WaypointStyle style) {
        this.style = style;
        return this;
    }

    public Waypoint build() {
        return new Waypoint(
                this.uuid,
                this.name,
                this.location,
                this.color,
                this.style
        );
    }
}
