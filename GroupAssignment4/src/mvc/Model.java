package mvc;
import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
	private boolean unsavedChanges = false;
	private String fileName = null;
	
	// sets the flag to true and notifies subscribers
	public void changed() {
		unsavedChanges = true;
		this.notifySubs();
	}
	
	public boolean getUnsavedChanges() {
		return unsavedChanges;
	}
	public void setUnsavedChanges(boolean hasChanges) {
		unsavedChanges = hasChanges;
	}
	
	public void setFileName(String fName) {
		fileName = fName;
	}
	public String getFileName() {
		return fileName;
	}
}