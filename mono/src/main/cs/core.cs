using System;
using System.Threading;

namespace poisondog.core {
	public interface Mission<T> {
		Object execute(T input);
	}
	public class NoMission<T> : Mission<T> {
		public Object execute(T input) {
			return input;
		}
	}
	public class AsyncMission<T> : Mission<T> {
		private Mission<T> mMission;
		public AsyncMission(Mission<T> mission) {
			mMission = mission;
		}
		public Object execute(T input) {
			Thread threadClient = new Thread(new ParameterizedThreadStart(handle));
			threadClient.Start(input);
			return null;
		}
		private void handle(object input) {
			mMission.execute((T) input);
		}
	}
}
