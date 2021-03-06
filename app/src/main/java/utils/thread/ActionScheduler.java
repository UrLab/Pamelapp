package utils.thread;

import android.app.Activity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by julianschembri on 6/02/16.
 */
public abstract class ActionScheduler extends Timer {
    protected boolean isTimerRunning;

    public void schedule(int rate) {
        isTimerRunning = true;
        this.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                handler();
            }
        }, 0, rate);
    };

    public void schedule(int rate, int delay) {
        isTimerRunning = true;
        this.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                handler();
            }
        }, delay, rate);
    };

    public void scheduleUI(final Activity act, int rate) {
        isTimerRunning = true;
        this.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    act.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            handler();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, rate);
    };

    public void scheduleUI(final Activity act, int rate, int delay) {
        isTimerRunning = true;
        this.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    act.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            handler();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, delay, rate);
    };

    abstract protected void handler();
}
