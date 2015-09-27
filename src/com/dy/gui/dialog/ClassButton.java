package com.dy.gui.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dongy on 2015/9/24.
 */
public class ClassButton extends JButton {
    public ClassButton(String text) {
        super(text);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        setFont(new java.awt.Font("»ªÎÄÐÐ¿¬", 1, 15));
        setBackground(Color.green);
        this.setVisible(true);
    }
}
