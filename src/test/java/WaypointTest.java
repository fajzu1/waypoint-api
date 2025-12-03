import io.github.fajzu.Waypoint;
import io.github.fajzu.WaypointBuilder;
import io.github.fajzu.WaypointProvider;
import io.github.fajzu.WaypointStyle;
import org.bukkit.Color;
import org.bukkit.Location;

void main() {
    final WaypointProvider waypointProvider = WaypointProvider.init(null);

    final Waypoint waypoint = WaypointBuilder
            .builder()
            .name("Test")
            .location(new Location(
                    null,
                    0,
                    100,
                    0
            ))
            .style(WaypointStyle.DEFAULT)
            .color(Color.BLACK)
            .build();

    waypointProvider.createWaypoint(null, waypoint);

    final Waypoint customWaypoint = WaypointBuilder
            .builder()
            .name("Test1")
            .location(new Location(
                    null,
                    0,
                    1001,
                    0
            ))
            .style(WaypointStyle.of("test", "test"))
            .color(Color.RED)
            .build();

    waypointProvider.createWaypoint(null, waypoint);
}
