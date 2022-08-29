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

package horse.wtf.nzyme.ethernet.dns.db;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DNSPairSummary {

    public abstract String server();
    public abstract Long requestCount();

    public abstract Long clientCount();

    public static DNSPairSummary create(String server, Long requestCount, Long clientCount) {
        return builder()
                .server(server)
                .requestCount(requestCount)
                .clientCount(clientCount)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_DNSPairSummary.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder server(String server);

        public abstract Builder requestCount(Long requestCount);

        public abstract Builder clientCount(Long clientCount);

        public abstract DNSPairSummary build();
    }

}
