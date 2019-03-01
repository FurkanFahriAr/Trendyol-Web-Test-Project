package pageElement;

public class Label extends PageElementModel {

    public Label(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public String getLabelText() {
        return getWebElement().getText();
    }
}
