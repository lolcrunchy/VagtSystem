package dev.crnyy.vagtsystem.plugins.jailsystem;

public class JailData {

    private final String reason;
    private final long jailTime;

    public JailData(String reason, long jailTime) {
        this.reason = reason;
        this.jailTime = jailTime;
    }

    public String getReason() {
        return reason;
    }

    public long getJailTime() {
        return jailTime;
    }

}
