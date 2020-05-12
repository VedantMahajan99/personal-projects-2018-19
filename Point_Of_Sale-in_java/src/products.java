
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vedantmahajan
 */
public class products extends javax.swing.JFrame {

    /**
     * Creates new form products
     */
    ArrayList<productinfo> productList = new ArrayList<>();

    producttablemodel producttablemodel_obj;

    public products() {
        initComponents();

        setSize(700, 700);

        jComboBox1.removeAllItems();

        jComboBox1.addItem("Select");

        jComboBox2.removeAllItems();

        jComboBox2.addItem("Select");

        getCategories();

        lb_product_photo_path.setVisible(false);

        producttablemodel_obj = new producttablemodel();

        jTable1.setModel(producttablemodel_obj);

        //getproduct();
    }

    public void getCategories() {

        try {

            ResultSet resultset_obj = DBLoader.executeQuery("select * from category");

            while (resultset_obj.next()) {

                jComboBox1.addItem(resultset_obj.getString("category_name"));

                jComboBox2.addItem(resultset_obj.getString("category_name"));

            }

        } catch (Exception e) {
        }

    }

    public void getproduct(String category_selected) {
        productList.clear();

        ResultSet resultset_obj = DBLoader.executeQuery("select * from product where Category='" + category_selected + "'");

        System.out.println(category_selected);

        try {
            while (resultset_obj.next()) {
                String pid = resultset_obj.getString("PID");
                String name = resultset_obj.getString("Name");
                String desc = resultset_obj.getString("Description");
                String barcode = resultset_obj.getString("Barcode");
                String price = resultset_obj.getString("Price");

                String photo = resultset_obj.getString("Photo");
                String category = resultset_obj.getString("Category");

                System.out.println(pid + "--" + name + "--" + desc + "--" + barcode + "--" + price + "--" + photo + "--" + category);

                System.out.println(resultset_obj.getString("Category"));

                productList.add(new productinfo(Integer.parseInt(pid), name, desc, barcode, price, photo, category));

                jTable1.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());

                jTable1.setRowHeight(100);

                producttablemodel_obj.fireTableDataChanged();

            }
        } catch (SQLException ex) {
            Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        tf_product_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_product_desc = new javax.swing.JTextArea();
        tf_barcode = new javax.swing.JTextField();
        tf_price = new javax.swing.JTextField();
        lb_product_photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lb_product_photo_path = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("CATEGORY :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 30, 90, 16);

        jLabel2.setText("PRODUCT NAME :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 170, 120, 16);

        jLabel3.setText("PRODUCT DESCRIPTION :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 260, 160, 16);

        jLabel4.setText("BARCODE:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 410, 120, 16);

        jLabel5.setText("PRICE :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 460, 43, 16);

        jLabel6.setText("PHOTO :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 540, 80, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(240, 20, 260, 27);

        tf_product_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_product_nameActionPerformed(evt);
            }
        });
        getContentPane().add(tf_product_name);
        tf_product_name.setBounds(240, 160, 270, 26);

        ta_product_desc.setColumns(20);
        ta_product_desc.setRows(5);
        jScrollPane1.setViewportView(ta_product_desc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 220, 270, 130);
        getContentPane().add(tf_barcode);
        tf_barcode.setBounds(240, 400, 280, 26);
        getContentPane().add(tf_price);
        tf_price.setBounds(240, 450, 280, 26);

        lb_product_photo.setText(".");
        getContentPane().add(lb_product_photo);
        lb_product_photo.setBounds(250, 540, 150, 110);

        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 570, 94, 29);

        lb_product_photo_path.setText(".");
        getContentPane().add(lb_product_photo_path);
        lb_product_photo_path.setBounds(240, 670, 620, 16);

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 720, 75, 29);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(650, 180, 500, 404);

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(840, 600, 97, 29);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(650, 20, 250, 27);

        jButton4.setText("SHOW");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(940, 20, 82, 29);

        jButton5.setText("EDIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(840, 640, 75, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_product_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_product_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_product_nameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if ((tf_product_name.getText() == null) || (ta_product_desc.getText() == null)) {
            JOptionPane.showMessageDialog(rootPane, "ALL FIELDS ARE NECESSARY !");
        } else {
            String newfilename = new Date().getTime() + ".jpg";

            File file_obj1 = new File(lb_product_photo_path.getText());  //doubt 1

            new savefileinfolder(file_obj1, newfilename);

            try {
                ResultSet resultset_obj = DBLoader.executeQuery("select * from product where Name='" + tf_product_name.getText() + "'");

                if (resultset_obj.next()) {

                    JOptionPane.showMessageDialog(rootPane, "Category already exists");

                } else {

                    resultset_obj.moveToInsertRow();

                    resultset_obj.updateString("Name", tf_product_name.getText());

                    resultset_obj.updateString("Description", ta_product_desc.getText());

                    resultset_obj.updateString("Barcode", tf_barcode.getText());

                    resultset_obj.updateString("Price", tf_price.getText());

                    resultset_obj.updateString("Photo", "src/pics/" + newfilename);

                    resultset_obj.updateString("Category", jComboBox1.getSelectedItem().toString());

                    resultset_obj.insertRow();

                    JOptionPane.showMessageDialog(rootPane, "DATA ENTRY SUCCESSFUL !");

                }

                // getproduct();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser jfc = new JFileChooser();

        int ans = jfc.showOpenDialog(this);

        if (ans == JFileChooser.APPROVE_OPTION) {
            File file_obj = jfc.getSelectedFile();

            lb_product_photo.setIcon(new ImageIcon(file_obj.getPath()));

            lb_product_photo_path.setText(file_obj.getPath());

            lb_product_photo_path.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "you need to select a file to move further");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int rowselected = jTable1.getSelectedRow();

        if (rowselected < 0) {
            JOptionPane.showMessageDialog(rootPane, "No Row Selected !");
        } else {
            String pid = productList.get(rowselected).PID + "";

            ResultSet resultset_obj = DBLoader.executeQuery("select * from product where PID='" + pid + "'");

            try {
                if (resultset_obj.next()) {
//                resultset_obj.next();

                    resultset_obj.deleteRow();
                    getproduct(jComboBox2.getSelectedItem().toString());
                }
            } catch (SQLException ex) {
                Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
            }

            //  getproduct();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String category_selected = jComboBox2.getSelectedItem().toString();
        System.out.println("Selected: " + category_selected);
        getproduct(category_selected);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int rowselected = jTable1.getSelectedRow();

        if (rowselected < 0) {
            JOptionPane.showMessageDialog(rootPane, "No Row Selected !");
        } else {

            String pid = productList.get(rowselected).PID + "";

            String name = productList.get(rowselected).product_name + "";

            String desc = productList.get(rowselected).product_desc + "";

            String bar = productList.get(rowselected).barcode + "";

            String photo = productList.get(rowselected).Photo + "";

            String price = productList.get(rowselected).Price + "";

            updateproduct updateproduct_obj = new updateproduct(pid, name, desc, bar, photo, price);

            updateproduct_obj.setVisible(true);

            updateproduct_obj.setSize(1000, 1000);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    class producttablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return productList.size();
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public Object getValueAt(int i, int j) {
            productinfo productinfo_object = productList.get(i);

            if (j == 0) {
                return productinfo_object.PID;
            } else if (j == 1) {
                return productinfo_object.product_name;
            } else if (j == 2) {
                return productinfo_object.product_desc;
            } else if (j == 3) {
                return productinfo_object.barcode;
            } else if (j == 4) {
                return productinfo_object.Price;
            } else if (j == 5) {
                System.out.println(productinfo_object.category);
                return productinfo_object.category;
            } else {
                return productinfo_object.Photo;

            }

        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"PID", "Name", "Description", "Barcode", "Price", "category", "Photo"};

            return col[j];
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        ImageIcon icon = new ImageIcon("");

        BufferedImage bufferedImage, newimage;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        
//            
            icon = new ImageIcon(productList.get(row).Photo); //doubt

            Image image_object = icon.getImage();

            Image newimg = image_object.getScaledInstance(80, 70, Image.SCALE_SMOOTH);

            lbl.setIcon(new ImageIcon(newimg));

            return lbl;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_product_photo;
    private javax.swing.JLabel lb_product_photo_path;
    private javax.swing.JTextArea ta_product_desc;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_product_name;
    // End of variables declaration//GEN-END:variables
}
