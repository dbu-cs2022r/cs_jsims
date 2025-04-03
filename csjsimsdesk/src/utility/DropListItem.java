/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author ChalewT
 */
public class DropListItem {

    private final int codeValue;
    private final String displayText;

    public DropListItem(int code, String text) {
        this.codeValue = code;
        this.displayText = text;

    }

    /**
     * @return the codeValue
     */
    public int getCodeValue() {
        return codeValue;
    }

    /**
     * @return the displayText
     */
    public String getDisplayText() {
        return displayText;
    }

    //Override the toString methods of Combo Box control
    //Give the required value to display
    @Override
    public String toString() {
        return this.displayText;
    }
}
