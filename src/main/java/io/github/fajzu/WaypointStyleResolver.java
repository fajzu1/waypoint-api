package io.github.fajzu;

import com.github.retrooper.packetevents.resources.ResourceLocation;

public class WaypointStyleResolver {

    public ResourceLocation resolve(Waypoint waypoint) {
        if (waypoint.style() != null) {
            return waypoint.style().resourceLocation();
        }

        return WaypointStyle.DEFAULT.resourceLocation();
    }
}