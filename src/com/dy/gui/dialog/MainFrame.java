package com.dy.gui.dialog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongy on 2015/9/23.
 */
public class MainFrame extends JFrame {

    private static final int COLUMN_NUM = 7;
    private static final int ROW_NUM = 9;

    public MainFrame(List<String> classNames) {
        initMainPanel();
        List<JButton> buttons = createClassButtons(classNames);
        addToFrame(buttons);
        SwingUtilities.updateComponentTreeUI(this);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addToFrame(List<JButton> buttonsList) {
        for(JButton button : buttonsList){
            super.add(button);
        }
    }

    private List<JButton> createClassButtons(List<String> classNames) {
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        for (int row = 0; row < ROW_NUM; row++){
            for(int column = 0; column < COLUMN_NUM; column++){
                String className = getClassName(classNames, column, row);
                JButton button = createButton(className,row,column);
                buttonList.add(button);
            }
        }
        return buttonList;
    }

    private void initMainPanel() {
        this.setTitle("Insanity");
        Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(scrSize.width * 2 / 3, scrSize.height * 2 / 3);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
    }

    private String getClassName(List<String> classNames, int column, int row) {
        return classNames.get(row * COLUMN_NUM +column);
    }

    private JButton createButton(String className, int row, int column) {
        JButton button = new ClassButton(className);
        button.setSize((int) (getWidth() / COLUMN_NUM), (int) (getHeight() / ROW_NUM * 0.95));
        button.setLocation(button.getWidth() * column, button.getHeight() * row);
        button.addActionListener(new ButtonActionListener());
        return button;
    }


}
