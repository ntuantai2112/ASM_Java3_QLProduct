/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fpoly.view;

import fpoly.model.Category;
import fpoly.model.Product;
import fpoly.service.Category_Service;
import fpoly.service.Product_Service;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO T560
 */
public class View_Update_Product extends javax.swing.JFrame {

    private Product_Service serviceProduct = new Product_Service();
    private Category_Service serviceCategory = new Category_Service();
    private ArrayList<Product> listProduct = serviceProduct.getAllProduct();
    private ArrayList<Category> listCategory = serviceCategory.getAllCategorys();

    public View_Update_Product() {
        initComponents();
        setDataCombobox();
        setLocationRelativeTo(null);
    }

    public View_Update_Product(Product p) {
        Product product = p;
        initComponents();
        setDataCombobox();
        setData(p);

    }

    private void setData(Product p) {

        String maSP = String.valueOf(p.getMaSP());
        txtMaSP.setText(maSP);
        txtTenSP.setText(String.valueOf(p.getTenSP()));
        txtGia.setText(String.valueOf(p.getGia()));
        txtSoLuong.setText(String.valueOf(p.getSoLuong()));
        txtTopic1.setText(String.valueOf(p.getTopic1()));
        txtTopic2.setText(String.valueOf(p.getTopic2()));

        int categoryId = p.getCategoryId();
        System.out.println(categoryId);

        if (categoryId == 1) {
            cboCategory.setSelectedIndex(0);
        } else if (categoryId == 2) {
            cboCategory.setSelectedIndex(1);

        } else {
            cboCategory.setSelectedIndex(2);

        }

    }

    private void setDataCombobox() {
        for (Category category : listCategory) {
            String item = category.getCategoryName();
            cboCategory.addItem(item);
        }
    }

    public Product getData() {
        String valueCbo = String.valueOf(cboCategory.getSelectedItem());
        int CategoryId;
        if (valueCbo.equalsIgnoreCase("Gối nằm")) {
            CategoryId = 1;
        } else if (valueCbo.equalsIgnoreCase("Gối ôm")) {
            CategoryId = 2;
        } else {
            CategoryId = 3;
        }

        Product product = new Product(Integer.parseInt(txtMaSP.getText()),
                CategoryId, txtTenSP.getText(), Double.parseDouble(txtGia.getText()), Integer.parseInt(txtSoLuong.getText()), txtTopic1.getText(), txtTopic2.getText());
        return product;

    }

    private void updateProduct() {
        if (validateForm()) {
            Product product = getData();
            if (product == null) {
                return;
            }

            int id = Integer.parseInt(txtMaSP.getText());
            if (id == -1) {
                return;
            }

            serviceProduct.update(id, product);
            JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
        }

    }

    private boolean validateForm() {
        if (txtMaSP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng qua quản lí sản phẩm chọn 1 sản phẩm muốn cập nhật");
            new View_QuanLi_Product().setVisible(true);
            dispose();
            return false;
        }

        if (txtTenSP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm");
            return false;
        }
        if (txtGia.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá sản phẩm");
            return false;
        }

        try {
            Double price = Double.parseDouble(txtGia.getText().trim());
//            if (price < 1000) {
//                JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 10000");
//                return false;
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá phải là số");
            return false;

        }
        if (txtSoLuong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm");
            return false;
        }

        try {
            Integer quantity = Integer.parseInt(txtSoLuong.getText().trim());
            if (quantity < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
            return false;

        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnSua_Product = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTopic1 = new javax.swing.JTextField();
        txtTopic2 = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã sản phẩm :");

        btnSua_Product.setText("Sửa Sản Phẩm");
        btnSua_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_ProductActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên sản phẩm :");

        jLabel5.setText("Giá :");

        jLabel6.setText("Danh Mục :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Sửa Sản Phẩm Gối Ngủ");

        txtMaSP.setEditable(false);
        txtMaSP.setBackground(new java.awt.Color(204, 204, 204));
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        txtGia.setEditable(false);
        txtGia.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Số Lượng :");

        txtSoLuong.setEditable(false);
        txtSoLuong.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setText("Chất liệu");

        jLabel10.setText("Độ bền :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(25, 25, 25)
                                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                            .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                            .addComponent(txtTopic1))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnSua_Product)
                            .addGap(18, 18, 18)
                            .addComponent(btnThoat))
                        .addComponent(txtTopic2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTopic1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTopic2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua_Product)
                    .addComponent(btnThoat))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
        //new View_QuanLi_Product().setVisible(true);
        //dispose();
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoryActionPerformed

    private void btnSua_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_ProductActionPerformed
        // TODO add your handling code here:

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc muốn xóa sản phẩm gối ngủ này?", "Delete?", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            updateProduct();
            new View_QuanLi_Product().setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_btnSua_ProductActionPerformed

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
            java.util.logging.Logger.getLogger(View_Update_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Update_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Update_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Update_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Update_Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua_Product;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTopic1;
    private javax.swing.JTextField txtTopic2;
    // End of variables declaration//GEN-END:variables
}
