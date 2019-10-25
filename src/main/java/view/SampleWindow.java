package view;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Component;

public class SampleWindow extends BasicWindow {
    private Component memComponent = null;

    public SampleWindow() { super(); }
    public SampleWindow(String title) { super(title); }

    @Override
    public void setComponent(Component component) {
        super.setComponent(component);

        if(component != null) {
            this.memComponent = component;
        }
    }

    SampleWindow show() {
        if (this.getComponent() == null) {
            super.setComponent(memComponent);
        }
        return this;
    }
}
