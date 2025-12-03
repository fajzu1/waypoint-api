package io.github.fajzu;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WaypointService {

    private final Map<UUID, Map<UUID, Waypoint>> waypointMap = new ConcurrentHashMap<>();

    public void create(UUID uuid, Waypoint waypoint) {
        this.waypointMap
                .computeIfAbsent(uuid, k -> new ConcurrentHashMap<>())
                .put(waypoint.uuid(), waypoint);
    }

    public void remove(UUID uuid, Waypoint waypoint) {
        this.waypointMap.computeIfAbsent(uuid, k -> new HashMap<>()).remove(waypoint.uuid());
    }

    public Waypoint find(UUID playerUUID, UUID uuid) {
        return this.waypointMap.computeIfAbsent(playerUUID, k -> new HashMap<>()).get(uuid);
    }

    public Map<UUID, Waypoint> findAll(UUID uuid) {
        return new ConcurrentHashMap<>(this.waypointMap.get(uuid));
    }

    public void removeAll(UUID uuid) {
        this.waypointMap.remove(uuid);
    }
}
