package io.github.fajzu;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.world.waypoint.TrackedWaypoint;
import com.github.retrooper.packetevents.util.PEVersion;
import com.google.common.base.Stopwatch;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class WaypointProvider {

    private final WaypointService waypointService;
    private final WaypointFactory waypointFactory;

    private final TrackedWaypointFactory trackedWaypointFactory;

    private WaypointProvider(final Plugin plugin) {
        final Stopwatch stopWatch = Stopwatch.createStarted();
        final WaypointStyleResolver styleResolver = new WaypointStyleResolver();

        this.trackedWaypointFactory = new TrackedWaypointFactory(styleResolver);

        this.waypointService = new WaypointService();
        this.waypointFactory = new WaypointFactory(this.trackedWaypointFactory);

        if (!plugin.getServer().getPluginManager().isPluginEnabled("PacketEvents")) {
            WaypointConstants.DEPENDENCY_NOT_FOUND.forEach(string -> {
                plugin.getLogger().log(Level.SEVERE, string);
            });

            plugin.getServer().shutdown();
            return;
        }

        if (PacketEvents.getAPI().getVersion().isOlderThan(PEVersion.fromString("1.21.5"))) {
            WaypointConstants.OLD_VERSION.forEach(string -> {
                plugin.getLogger().log(Level.SEVERE, string);
            });

            plugin.getServer().shutdown();
            return;
        }

        plugin.getLogger().log(Level.INFO, "Successfully Injected WaypointProvider in " + stopWatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static WaypointProvider init(final @NotNull Plugin plugin) {
        return new WaypointProvider(plugin);
    }

    public void createWaypoint(final @NotNull Player player,
                               final @NotNull Waypoint waypoint) {
        this.waypointService.create(player.getUniqueId(), waypoint);

        this.waypointFactory.track(player, waypoint);
    }

    public void removeWaypoint(final @NotNull Player player,
                               final @NotNull Waypoint waypoint) {
        this.waypointService.remove(player.getUniqueId(), waypoint);

        this.waypointFactory.hide(player, waypoint);
    }

    public Map<UUID, Waypoint> findAll(final @NotNull UUID uuid) {
        return this.waypointService.findAll(uuid);
    }

    public void track(final @NotNull Player player,
                      final @NotNull Waypoint waypoint) {
        this.waypointFactory.track(player, waypoint);
    }

    public void hide(final @NotNull Player player,
                     final @NotNull Waypoint waypoint) {
        this.waypointFactory.hide(player, waypoint);
    }

    public void update(final @NotNull Player player,
                       final @NotNull Waypoint waypoint) {
        this.waypointFactory.update(player, waypoint);
    }

    public TrackedWaypoint toTracked(final @NotNull Waypoint waypoint) {
        return trackedWaypointFactory.create(waypoint);
    }

    public WaypointFactory waypointFactory() {
        return this.waypointFactory;
    }

    public WaypointService waypointService() {
        return this.waypointService;
    }

    public TrackedWaypointFactory trackedWaypointFactory() {
        return this.trackedWaypointFactory;
    }
}
