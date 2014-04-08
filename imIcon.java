import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import javax.swing.ImageIcon;
 
public class imIcon {
 
    public static void main(String[] args) {
 
        if (SystemTray.isSupported()) {
            // Yes My System Support System Tray
            System.out.println("System Try Supported");
 
            // Create SystemTray and TrayIcon (TrayIcon : It is icon that
            // display in SystemTray)
            final SystemTray systemTray = SystemTray.getSystemTray();
            final TrayIcon trayIcon = new TrayIcon(getImage("jitsi.gif"),
                    "omt is running");
            trayIcon.setImageAutoSize(true);// Autosize icon base on space
                                            // available on
                                            // tray
 
            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("omt click");
                    // This will display small popup message from System Tray
                    trayIcon.displayMessage("Omt TrayIcon Demo",
                            "This is an info message from TrayIcon omt demo",
                            TrayIcon.MessageType.INFO);
                }
            };
 
            trayIcon.addMouseListener(mouseAdapter);
 
            try {
                systemTray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        }
 
    }
 
    public static Image getImage(String path) {
        ImageIcon icon = new ImageIcon(path, "omt");
        return icon.getImage();
    }
 
}
