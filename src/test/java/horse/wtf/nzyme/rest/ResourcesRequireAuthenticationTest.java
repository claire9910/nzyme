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

package horse.wtf.nzyme.rest;

import com.google.common.collect.ImmutableList;
import horse.wtf.nzyme.bandits.trackers.hid.webhid.rest.resources.TrackerWebHIDAssetsResource;
import horse.wtf.nzyme.bandits.trackers.hid.webhid.rest.resources.TrackerWebHIDResource;
import horse.wtf.nzyme.rest.authentication.Secured;
import horse.wtf.nzyme.rest.resources.PingResource;
import horse.wtf.nzyme.rest.resources.assets.WebInterfaceAssetsResource;
import horse.wtf.nzyme.rest.resources.authentication.AuthenticationResource;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.annotations.Test;

import javax.ws.rs.Path;

import java.util.List;

import static org.testng.Assert.fail;

public class ResourcesRequireAuthenticationTest {

    private final List<Class<?>> WHITELIST = ImmutableList.of(
            WebInterfaceAssetsResource.class,
            PingResource.class,
            AuthenticationResource.class,
            TrackerWebHIDAssetsResource.class,
            TrackerWebHIDResource.class
    );

    @Test
    public void testAllResources() {
        Reflections r = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("horse.wtf.nzyme.rest.resources"))
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner())
        );

        for (Class<?> resource : r.getTypesAnnotatedWith(Path.class)) {
            if (WHITELIST.contains(resource)) {
                continue;
            }

            if (!resource.isAnnotationPresent(Secured.class)) {
                fail("REST resource " + resource.getCanonicalName() + " is not annotated with @Secured.");
            }
        }
    }

}
