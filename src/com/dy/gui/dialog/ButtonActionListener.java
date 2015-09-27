package com.dy.gui.dialog;

import com.dy.data.SqliteQuery;
import com.dy.displayer.VedioShower;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by dongy on 2015/9/24.
 */
public class ButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        try {
            String webSite = SqliteQuery.selectWebSiteFromDb(button.getText());
            if(webSite == null || webSite == ""){
                JOptionPane.showMessageDialog(null, "No Record!", "DB error", JOptionPane.ERROR_MESSAGE);
            }
            VedioShower.show(webSite);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "IO Exception", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Class Not Found", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "DB errror", JOptionPane.ERROR_MESSAGE);
        }
    }
}
