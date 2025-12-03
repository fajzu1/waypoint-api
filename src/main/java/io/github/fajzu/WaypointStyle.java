package io.github.fajzu;

import com.github.retrooper.packetevents.resources.ResourceLocation;

public record WaypointStyle(String namespace, String path) {
    public static WaypointStyle DEFAULT = new WaypointStyle(
            "minecraft",
            "default"
    );

    public static WaypointStyle of(
            final String namespace,
            final String path
    ) {
        return new WaypointStyle(namespace, path);
    }

    public ResourceLocation resourceLocation() {
        return new ResourceLocation(
                this.namespace,
                this.path
        );
    }
}