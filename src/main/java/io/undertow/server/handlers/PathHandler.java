package io.undertow.server.handlers;

import io.undertow.server.HttpServerExchange;

public class PathHandler {
	public static void handleRequest(HttpServerExchange ex) {
		System.out.println("Hello from Undertow");
	}

}
