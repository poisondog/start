using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using poisondog.core;

namespace poisondog.net {
	public class SocketParameter {
		private String mHost;
		private int mPort;
		public SocketParameter(String host, int port) {
			mHost = host;
			mPort = port;
		}
		public String getHost() {
			return mHost;
		}
		public int getPort() {
			return mPort;
		}
	}

	public class ReceiveString : Mission<Socket> {
		public Object execute(Socket socket) {
			String data = null;
			while (true) {
				byte[] bytes = new byte[1024];
				int bytesRec = socket.Receive(bytes);
				data += Encoding.ASCII.GetString(bytes, 0, bytesRec);
				if (!String.IsNullOrEmpty(data)) {
					break;
				}
			}
			Console.WriteLine("Text received : {0}", data);
			return data;
		}
	}

	public class ServerMission : Mission<SocketParameter> {
		private Mission<Socket> mHandler;
		public ServerMission() :this(new NoMission<Socket>()) {
		}
		public ServerMission(Mission<Socket> handler) {
			mHandler = handler;
		}
		public Object execute(SocketParameter parameter) {
			// Establish the local endpoint for the socket.
			// Dns.GetHostName returns the name of the host running the application.
//			IPHostEntry ipHostInfo = Dns.GetHostEntry(parameter.getHost());
			IPHostEntry ipHostInfo = Dns.GetHostEntry(Dns.GetHostName());
			IPAddress ipAddress = ipHostInfo.AddressList[1];
			IPEndPoint localEndPoint = new IPEndPoint(ipAddress, parameter.getPort());

			// Create a TCP/IP socket.
			Socket listener = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

			// Bind the socket to the local endpoint and
			// listen for incoming connections.
			try {
				Console.WriteLine("localEndPoint: " + localEndPoint.ToString());
				listener.Bind(localEndPoint);
				listener.Listen(10);
				listener.IOControl(IOControlCode.KeepAliveValues, keepAlive(1, 1000, 1000), null);

				// Start listening for connections.
				while (true) {
					Console.WriteLine("Waiting for a connection...");
					// Program is suspended while waiting for an incoming connection.
					Socket handler = listener.Accept();

					Thread threadClient = new Thread(new ParameterizedThreadStart(handleClient));
					threadClient.Name = "Client Thread";
					threadClient.Start(handler);

				}

			} catch (Exception e) {
				Console.WriteLine(e.ToString());
			}

			Console.WriteLine("\nPress ENTER to continue...");
			Console.Read();

			return null;
		}

		private byte[] keepAlive(int onOff, int keepAliveTime, int keepAliveInterval) {
			byte[] buffer = new byte[12];
			BitConverter.GetBytes(onOff).CopyTo(buffer, 0);
			BitConverter.GetBytes(keepAliveTime).CopyTo(buffer, 4);
			BitConverter.GetBytes(keepAliveInterval).CopyTo(buffer, 8);
			return buffer;
		}

		private void handleClient(object obj) {
			Socket handler = (Socket)obj;
			mHandler.execute(handler);
		}

	}
}
