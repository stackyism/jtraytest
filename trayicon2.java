import java.lang.*;
import java.io.IOException;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
public class trayicon2{
public void main(){
if (SystemTray.isSupported()) {

    // Get the SystemTray instance
    SystemTray tray = SystemTray.getSystemTray();

    // Load icon
    java.awt.Image image = null;
    try {
        image = ImageIO.read(getClass().getResource("icon.png"));

    } catch (IOException exc) {
        exc.printStackTrace();
    }

    /**
     * A few listeners to popup menu items click.
     */

   // Create a popup menu and its items
   PopupMenu popup = new PopupMenu();
   MenuItem openItem = new MenuItem("Open");
   openItem.addActionListener(openListener);
   popup.add(openItem);

   popup.addSeparator();

   MenuItem closeItem = new MenuItem("Close");
   closeItem.addActionListener(closeListener);
   popup.add(closeItem);

   trayIcon = new TrayIcon(image, "app test", popup);

   try {
       tray.add(trayIcon);
   } catch (AWTException exc) {
       exc.printStaceTrack();  
   }
}   
}}
