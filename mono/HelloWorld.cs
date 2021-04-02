using System;
using poisondog.net;

public class HelloWorld {
	public static void Main(string[] args) {
		SocketParameter parameter = new SocketParameter("localhost", 12312);
		ServerMission server = new ServerMission(new ReceiveString());
		server.execute(parameter);
		Console.WriteLine ("Hello Mono World");
	}
}

