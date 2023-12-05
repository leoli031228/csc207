package interface_adapter.switch_view;
import interface_adapter.ViewManagerModel;

public class SwitchViewController {
    private ViewManagerModel viewManagerModel;

    public SwitchViewController(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }
    public void execute(String viewToSwitch){
        viewManagerModel.setActiveView(viewToSwitch);
        viewManagerModel.firePropertyChanged();
    }
}
