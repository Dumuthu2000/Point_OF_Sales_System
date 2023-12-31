
package point_of_sales_system;
import view.VLogin;
public class Main {
    public static void main(String [] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VLogin loginFrame = new VLogin();
                loginFrame.setVisible(true);
            }
        });
    }
    
}
