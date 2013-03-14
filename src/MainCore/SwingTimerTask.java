package MainCore;

import java.awt.EventQueue;

/**
 * Allows for handling of TimerTask operations inside of the SwingEventThread.
 */
public abstract class SwingTimerTask extends java.util.TimerTask {
    public abstract void doRun();

    public void run() {
        if (!EventQueue.isDispatchThread()) {
            EventQueue.invokeLater(this);
        }
        else {
            doRun();
        }
    }
}
