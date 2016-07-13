/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.manager.location;

import alfio.config.Initializer;
import alfio.manager.system.ConfigurationManager;
import alfio.model.system.Configuration;
import alfio.model.system.ConfigurationKeys;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Component
@AllArgsConstructor
@Profile(Initializer.PROFILE_LIVE)
public class DefaultLocationManager implements LocationManager {

    private final ConfigurationManager configurationManager;
    private final GoogleMapsLocationManager googleMapsLocationManager;
    private final MockLocationManager mockLocationManager;

    // TODO change this to be more robust and flexible (like the Mailer system) when there are more managers
    private LocationManager getLocationManager() {
        return configurationManager.getStringConfigValue(
            Configuration.getSystemConfiguration(ConfigurationKeys.MAPS_SERVER_API_KEY))
            .isPresent() ? googleMapsLocationManager : mockLocationManager;
    }

    @Override
    public Pair<String, String> geocode(String address) {
        return getLocationManager().geocode(address);
    }

    @Override
    public TimeZone getTimezone(Pair<String, String> location) {
        return getLocationManager().getTimezone(location);
    }

    @Override
    public TimeZone getTimezone(String latitude, String longitude) {
        return getLocationManager().getTimezone(latitude, longitude);
    }
}
