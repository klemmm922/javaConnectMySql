package src;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrontPage extends JFrame {
    private JComboBox<String> dropDown;
    private JLabel imageLabel;

    private String imageFolderPath = "testImageApp/src/images/"; // Default image folder path
    //private String imageFolderPath = "images/"; // Default image folder path

    private String path = "";

    public FrontPage() {
        setTitle("Front Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        dropDown = new JComboBox<>();
        dropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedImage = (String) dropDown.getSelectedItem();
                getPath(selectedImage);
                String imagePath = imageFolderPath + path;
                displayImage(imagePath);
            }
        });
        add(dropDown);

        imageLabel = new JLabel();
        add(imageLabel);

        populateDropDown();
    }

    private void populateDropDown() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datas", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM images");

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                //String path = resultSet.getString("path");
                path = resultSet.getString("path");
                model.addElement(name);
                // Store the path in a variable
//                if (path != null && !path.isEmpty()) {
//                    imageFolderPath = path;
//                }
            }
            dropDown.setModel(model);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageLabel.setIcon(imageIcon);
    }

    private void getPath(String name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datas", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM images WHERE name= '" + name + "'");

            while (resultSet.next()) {
                //String path = resultSet.getString("path");
                path = resultSet.getString("path");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FrontPage frontPage = new FrontPage();
        frontPage.setVisible(true);
    }

}
