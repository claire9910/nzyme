/*
 * This file is part of nzyme.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Server Side Public License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program. If not, see
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */

package horse.wtf.nzyme.periodicals.alerting.beaconrate;

import app.nzyme.plugin.Database;
import horse.wtf.nzyme.NzymeLeader;
import horse.wtf.nzyme.periodicals.Periodical;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeaconRateCleaner extends Periodical {

    private static final Logger LOG = LogManager.getLogger(BeaconRateCleaner.class);

    private final Database database;

    public BeaconRateCleaner(NzymeLeader nzyme) {
        this.database = nzyme.getDatabase();
    }

    @Override
    protected void execute() {
        try {
            LOG.debug("Retention cleaning beacon rate values.");

            database.useHandle(handle -> {
                handle.execute("DELETE FROM beacon_rate_history WHERE created_at < (current_timestamp at time zone 'UTC' - interval '1 day')");
            });
        } catch(Exception e) {
            LOG.error("Could not retention clean beacon rate information.", e);
        }
    }

    @Override
    public String getName() {
        return "BeaconRateCleaner";
    }

}
