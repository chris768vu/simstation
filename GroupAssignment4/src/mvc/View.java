package mvc; 
import javax.swing.*;
import java.awt.*;

public class View extends JPanel implements Subscriber {

    protected Model model;

    
    public View(Model model) {
    	this.model = model;
    	model.subscribe(this);
    }

    // Subscriber update method
    
    public void update() {}
    
    public void setModel(Model newModel) {
        if (this.model != null) {
            this.model.unsubscribe(this);
        }
        
        this.model = newModel;
        if (this.model != null) {
            this.model.subscribe(this);
            update(); 
        }
    }
}