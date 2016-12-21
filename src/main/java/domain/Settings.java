package domain;

public class Settings {

	private boolean clearCacheStartup;
	private boolean splashStartup;

	public boolean isClearCacheStartup() {
		return clearCacheStartup;
	}

	public void setClearCacheStartup(boolean clearCacheStartup) {
		this.clearCacheStartup = clearCacheStartup;
	}

	public boolean isSplashStartup() {
		return splashStartup;
	}

	public void setSplashStartup(boolean splashStartup) {
		this.splashStartup = splashStartup;
	}
}