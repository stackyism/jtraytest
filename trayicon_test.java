import java.awt.*;
import java.awt.event;
import java.awt.SystemTray;

public class trayicon{

public static void main(String args[])
{
 TrayIcon trayIcon = null;
     if (SystemTray.isSupported()) {
         // get the SystemTray instance
         SystemTray tray = SystemTray.getSystemTray();
         // load an image
         Image image = Toolkit.getDefaultToolkit().getImage(1);
         // create a action listener to listen for default action executed on the tray icon
         ActionListener listener = new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 // execute default action of the application
                 // ...
		sys.close();
             }
         };
         // create a popup menu
         PopupMenu popup = new PopupMenu();
         // create menu item for the default action
         MenuItem defaultItem = new MenuItem("Maximize");
         defaultItem.addActionListener(listener);
         popup.add(defaultItem);
         /// ... add other items
         // construct a TrayIcon
         trayIcon = new TrayIcon(image, "Tray Demo", popup);
         // set the TrayIcon properties
         trayIcon.addActionListener(listener);
         // ...
         // add the tray image
         try {
             tray.add(trayIcon);
         } catch (AWTException e) {
             System.err.println(e);
         }
         // ...
     } else {
         // disable tray option in your application or
         // perform other actions
         //...
     }
     // ...
     // some time later
     // the application state has changed - update the image
     if (trayIcon != null) {
         trayIcon.setImage(1);
     }
}
}
