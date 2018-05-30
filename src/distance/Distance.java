
package distance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.io.*;
import javax.swing.border.EtchedBorder;
import java.math.BigDecimal;


public class Distance extends JFrame
{
    public Distance()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Distance calculation");
        this.setBounds(800, 200, 600, 600);
        this.setDefaultCloseOperation(3);
        this.add(menu);
        this.setJMenuBar(menu);
        menu.add(about);
        about.add(info);
        
        
        this.getContentPane().add(b);
        b.add(panel1);
        b.add(panel2);
        b.add(panel3);
        b.add(panel4);
        
        panel1.add(img);
        img.setIcon(new ImageIcon("picture.gif"));
        
        panel2.add(point1);
        panel2.add(x1Coord);
        panel2.add(x1coordField);
        panel2.add(m1);
        panel2.add(y1Coord);
        panel2.add(y1coordField);
        panel2.add(m2);
        panel2.add(z1Coord);
        panel2.add(z1coordField);
        panel2.add(m6);
        x1coordField.setPreferredSize(new Dimension(100, 20));
        y1coordField.setPreferredSize(new Dimension(100, 20));
        z1coordField.setPreferredSize(new Dimension(100, 20));
        x1coordField.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        y1coordField.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        z1coordField.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        z1coordField.setText("0.00");
                
        panel3.add(point2);
        panel3.add(x2Coord);
        panel3.add(x2coordField);
        panel3.add(m3);
        panel3.add(y2Coord);
        panel3.add(y2coordField);
        panel3.add(m4);
        panel3.add(z2Coord);
        panel3.add(z2coordField);
        panel3.add(m7);
        x2coordField.setPreferredSize(new Dimension(100, 20));
        y2coordField.setPreferredSize(new Dimension(100, 20));
        z2coordField.setPreferredSize(new Dimension(100, 20));
        x2coordField.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        y2coordField.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        z2coordField.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        z2coordField.setText("0.00");
        
        panel4.add(report);
        panel4.add(calc);
        panel4.add(calcField);
        panel4.add(m5);
        calcField.setPreferredSize(new Dimension(140,20));
        calcField.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        calcField.setBackground(Color.yellow);
        
        msgPanel.add(msgLabel);
       
        
        calc.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               
                           
               if (x1coordField.getText().equals(null) || y1coordField.getText().equals(null) || x2coordField.getText().equals(null) || y2coordField.getText().equals(null))
               {
                   JOptionPane.showMessageDialog(rootPane, "WARNING! Fill in coordinates.");
               }
               
               else
                {
                                    if (report.isSelected())
                                        {
                                            try
                                                 {
                                                 double distance = Math.sqrt(Math.pow(Double.parseDouble(x2coordField.getText())-Double.parseDouble(x1coordField.getText()),2)+Math.pow(Double.parseDouble(y2coordField.getText())-Double.parseDouble(y1coordField.getText()),2)+Math.pow(Double.parseDouble(z2coordField.getText())-Double.parseDouble(z1coordField.getText()),2));

                                                 java.text.DecimalFormat df = new java.text.DecimalFormat();
                                                 df.setMaximumFractionDigits(2);
                                                 df.setMinimumFractionDigits(2);

                                                 String distanceString = df.format(distance);

                                                 calcField.setText(distanceString);

                                                 BufferedWriter writer = new BufferedWriter(new FileWriter("Report.txt", true));
                                                 writer.newLine();
                                                 writer.write("Point no. 1: (X = " + x1coordField.getText() + ", Y = " + y1coordField.getText() + ", Z = " + z1coordField.getText() + ") m");
                                                 writer.newLine();
                                                 writer.write("Point no. 2: (X = " + x2coordField.getText() + ", Y = " + y2coordField.getText() + ", Z = " + z2coordField.getText() + ") m");
                                                 writer.newLine();
                                                 writer.write("Distance: " + calcField.getText() + " m");
                                                 writer.newLine();
                                                 writer.close();
                                                 }
                                            catch (IOException e)
                                                 {
                                                 e.getMessage();
                                                 }
                                        }
                                    else
                                    {
                                            double distance = Math.sqrt(Math.pow(Double.parseDouble(x2coordField.getText())-Double.parseDouble(x1coordField.getText()),2)+Math.pow(Double.parseDouble(y2coordField.getText())-Double.parseDouble(y1coordField.getText()),2)+Math.pow(Double.parseDouble(z2coordField.getText())-Double.parseDouble(z1coordField.getText()),2));

                                            java.text.DecimalFormat df = new java.text.DecimalFormat();
                                            df.setMaximumFractionDigits(2);
                                            df.setMinimumFractionDigits(2);

                                            String distanceString = df.format(distance);

                                            calcField.setText(distanceString);
                        
                                    }
                }
            }
        });
        
        info.addActionListener(new ActionListener()
        { 
            @Override
            public void actionPerformed(ActionEvent ae)
            {
//               JOptionPane.showMessageDialog(rootPane, "This program calculates distance between two points in 3D (X,Y,Z) or 2D (X,Y). Z coordinates have 0 values by default. Change these values, if you want calculate distance in 3D. You can also save calculation to file by checking " + "'" + "Save a report" + "'" + " check box.");
               JOptionPane.showMessageDialog(rootPane, msgPanel);

            }
        });
        
    }  
                
    public static void main(String[] args)
    {
      new Distance().setVisible(true);
    }
        
    Box b = Box.createVerticalBox();
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel msgPanel = new JPanel();
    
    JLabel point1 = new JLabel("Point no. 1   ");
    JLabel point2 = new JLabel("Point no. 2   ");
    JLabel x1Coord = new JLabel("X: ");
    JLabel y1Coord = new JLabel("Y: ");
    JLabel z1Coord = new JLabel("Z: ");
    JLabel x2Coord = new JLabel("X: ");
    JLabel y2Coord = new JLabel("Y: ");
    JLabel z2Coord = new JLabel("Z: ");
    JLabel m1 = new JLabel("m    ");
    JLabel m2 = new JLabel("m    ");
    JLabel m3 = new JLabel("m    ");
    JLabel m4 = new JLabel("m    ");
    JLabel m5 = new JLabel("m");
    JLabel m6 = new JLabel("m");
    JLabel m7 = new JLabel("m");
    JLabel img = new JLabel();
    JLabel msgLabel = new JLabel("This program calculates distance between two points in 3D (X,Y,Z) or 2D (X,Y). Z coordinates have 0 values by default. Change these values, if you want calculate distance in 3D. You can also save calculation to file by checking " + "'" + "Save a report" + "'" + " check box.");
    
    
    JButton calc = new JButton("Calculate");
    
    JTextField calcField = new JTextField();
    JTextField x1coordField = new JTextField();
    JTextField y1coordField = new JTextField();
    JTextField z1coordField = new JTextField();
    JTextField x2coordField = new JTextField();
    JTextField y2coordField = new JTextField();
    JTextField z2coordField = new JTextField();
    
    JMenuBar menu = new JMenuBar();
    JMenu about= new JMenu("About");
    JMenuItem info = new JMenuItem("Info");
    JCheckBox report = new JCheckBox("Save a report");

    
}
