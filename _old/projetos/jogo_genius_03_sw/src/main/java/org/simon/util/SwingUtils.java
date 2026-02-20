package org.simon.util;

import javax.swing.*;

public final class SwingUtils {
    private SwingUtils() {}

    public static void runOnEDT(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) r.run();
        else SwingUtilities.invokeLater(r);
    }
}
