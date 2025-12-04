package io.github.fajzu;

import org.bukkit.Color;
import org.bukkit.Location;

import java.util.UUID;

public class Waypoint {

    private final UUID uuid;
    private final String name;

    private Location location;

    private Color color;

    private WaypointStyle style;

    public Waypoint(
            final UUID uuid,
            final String name,
            final Location location) {
        this.uuid = uuid;
        this.name = name;
        this.location = location;
    }

    public Waypoint(
            final UUID uuid,
            final String name,
            final Location location,
            final Color color,
            final WaypointStyle style) {
        this(uuid, name, location);

        this.color = color;
        this.style = style;
    }

    public void location(final Location location) {
        this.location = location;
    }

    public void color(final Color color) {
        this.color = color;
    }

    public void style(final WaypointStyle style) {
        this.style = style;
    }

    public UUID uuid() {
        return this.uuid;
    }

    public String name() {
        return this.name;
    }

    public Location location() {
        return this.location;
    }

    public Color color() {
        return this.color;
    }

    public WaypointStyle style() {
        return this.style;
    }
}
