package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropDownCommonMethods {

    public Select clickOnSelectDropDown(WebElement dropDown) {
        Select select = new Select(dropDown);
        return select;
    }

    public void selectByIndex(WebElement dropDown, int index){
        clickOnSelectDropDown(dropDown).selectByIndex(index);
    }

    public void selectByValue(WebElement dropDown, String value){
        clickOnSelectDropDown(dropDown).selectByValue(value);
    }

    public void selectByVisibleText(WebElement dropDown, String visibleText){
        clickOnSelectDropDown(dropDown).selectByVisibleText (visibleText);
    }

    public String getFirstSelectedText(WebElement dropDown){
       return  clickOnSelectDropDown(dropDown).getFirstSelectedOption().getText();
    }

    public void deselectValueFromDropDown(WebElement dropDown){
        clickOnSelectDropDown(dropDown).deselectAll();
    }

    public int getAllOptionsCountDropDown(WebElement dropDown){
       return clickOnSelectDropDown(dropDown).getOptions().size();
    }
    public List<String> getSelectedOptionsDropDown(WebElement dropDown){
        ArrayList<String> selectedList = new ArrayList<>();
        List<WebElement> selectedOptions= clickOnSelectDropDown(dropDown).getAllSelectedOptions();
        for (WebElement option : selectedOptions){
            selectedList.add(option.getText());
        }
        return selectedList;
    }
}
