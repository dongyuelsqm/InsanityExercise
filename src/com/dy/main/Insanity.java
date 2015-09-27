package com.dy.main;

import com.dy.displayer.VedioShower;
import com.dy.data.SqliteQuery;
import com.dy.gui.dialog.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * Created by dongy on 2015/9/21.
 */
public class Insanity {
    public static void main(String[] arg) {
        try {
            List<String> classNames = SqliteQuery.queryPracticePlan();
            MainFrame mainFrame = new MainFrame(classNames);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
