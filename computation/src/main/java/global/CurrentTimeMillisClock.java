package global;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description: CurrentTimeMillisClock
 * date: 2021/3/4 16:06
 * 全局时钟 降低对于状态切换带来的性能影响
 * @author: SmartCat
 * version: 1.0.0
 */
public class CurrentTimeMillisClock {
    private volatile long now;

    private CurrentTimeMillisClock() {
        this.now = System.currentTimeMillis ();
        scheduleTick ();
    }

    private void scheduleTick() {
        new ScheduledThreadPoolExecutor (1, runnable -> {
            Thread thread = new Thread (runnable, "current-time-millis");
            thread.setDaemon (true);
            return thread;
        }).scheduleAtFixedRate (() -> {
            now = System.currentTimeMillis ();
        }, 1, 1, TimeUnit.MILLISECONDS);
    }

    public long now() {
        return now;
    }

    public static CurrentTimeMillisClock getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CurrentTimeMillisClock INSTANCE = new CurrentTimeMillisClock ();
    }
}
