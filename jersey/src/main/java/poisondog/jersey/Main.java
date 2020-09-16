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

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Adam Huang
 */
public class Main {
	public final static String WEB_APP_NAME = "poisondog.jersey";
	public final static String BASIS_URL = "http://localhost:8080/" + WEB_APP_NAME + "/";

	public static void main (String [] args) throws IOException {
		final ResourceConfig rc = new ResourceConfig().packages(WEB_APP_NAME);
		final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASIS_URL), rc);
		System.in.read();
		server.stop();
	}
}
