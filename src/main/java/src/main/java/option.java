/**
 * @author : AlexV
 * @since : 05.01.2022, ср
 **/

package src.main.java;

public class option {
    private String Option;
    private String Text;
    private String Action;

    public void setOption(String option) {
        Option = option;
    }

    public void setText(String text) {
        Text = text;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getOption() {
        return Option;
    }

    public String getText() {
        return Text;
    }

    public String getAction() {
        return Action;
    }
}