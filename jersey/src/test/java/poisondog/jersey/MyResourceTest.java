/*
 * Copyright (C) 2015 Adam Huang <poisondog@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package poisondog.jersey;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class MyResourceTest {
	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		final ResourceConfig rc = new ResourceConfig().packages(Main.WEB_APP_NAME);
		server = GrizzlyHttpServerFactory.createHttpServer(URI.create(Main.BASIS_URL), rc);

		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASIS_URL);
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void testGetIt() {
		String responseMsg = target.path("myresource").request().get(String.class);
		Assert.assertEquals("Got it!", responseMsg);
	}
}
