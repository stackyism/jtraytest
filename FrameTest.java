import javax.swing.*;
import javax.swing.JFrame;
import java.awt.SystemTray;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.TrayIcon;
//import javax.swing.TrayIcon;

public class FrameTest {
	private JFrame frame;
	private Image dogImage;
	private SystemTray sysTray;
	private PopupMenu menu;
	private MenuItem item1;
	private TrayIcon trayIcon;
	private JPopupMenu jpopup;
	private JMenuItem javaCupMI;
	private JMenuItem exitMI;
	//private MouseEvent e;

	//constructor
	public FrameTest() {
		initComponents();
		//basic stuff.
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	private void initComponents() {
		//create jframe
		frame = new JFrame("Frame Test");
	
		//check to see if system tray is supported on OS.
		if (SystemTray.isSupported()) {
			sysTray = SystemTray.getSystemTray();
			
			//create dog image
			dogImage  = Toolkit.getDefaultToolkit().getImage("jitsi.gif");

			//create popupmenu
			menu = new PopupMenu();

			//create item
			item1 = new MenuItem("Exit");

			//add item to menu
			menu.add(item1);

			//add action listener to the item in the popup menu
			item1.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   System.exit(0);
			   }
			});
			
			//create system tray icon.
			trayIcon = new TrayIcon(dogImage, "Dog App.", null);
			jpopup = new JPopupMenu();
			javaCupMI = new JMenuItem("Example", new ImageIcon("yodog.gif"));
			jpopup.add(javaCupMI);
			jpopup.addSeparator();
			exitMI = new JMenuItem("Exit");
			exitMI.addActionListener(new ActionListener() {
                           public void actionPerformed(ActionEvent e) {
                                   System.exit(0);
                           }
                        });
			jpopup.add(exitMI);

			trayIcon.addMouseListener(new MouseAdapter(){
				public void mouseReleased(MouseEvent e) {
					if(e.getButton() == MouseEvent.BUTTON3) {
						jpopup.setInvoker(jpopup);
						jpopup.setVisible(true);
						jpopup.setLocation(e.getX(), e.getY() -jpopup.getHeight());
}
}
}
);

			//add the tray icon to the system tray.
			try {
				sysTray.add(trayIcon);
				}
			catch(AWTException e) {
			   System.out.println("System Tray unsupported!");
			}
		}
	}//end FrameTest constructor

	//main
	public static void main(String[]args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new FrameTest();
			}
		});
	}//end main()

}//end FrameTest Class
