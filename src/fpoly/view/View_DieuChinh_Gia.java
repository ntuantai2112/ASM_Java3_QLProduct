/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fpoly.view;

import fpoly.model.Category;
import fpoly.model.Product;
import fpoly.model.InvetoryLog;
import fpoly.service.InventoryLog_Service;
import fpoly.service.Category_Service;
import fpoly.service.Product_Service;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO T560
 */
public class View_DieuChinh_Gia extends javax.swing.JFrame {

    private Product_Service serviceProduct = new Product_Service();
    private Category_Service serviceCategory = new Category_Service();
    private ArrayList<Product> listProduct = serviceProduct.getAllProduct();
    private ArrayList<Category> listCategory = serviceCategory.getAllCategorys();
    private InventoryLog_Service inventoryLog_Service = new InventoryLog_Service();

    public View_DieuChinh_Gia() {
        initComponents();
        //fillTable(listProduct);
        setDataCombobox();
        setLocationRelativeTo(null);
    }

    private void fillTable(ArrayList<Product> listProduct) {
        DefaultTableModel model = (DefaultTableModel) tbl_DieuChinh_Gia.getModel();
        model.setRowCount(0);
        for (Product pd : listProduct) {
            model.addRow(new Object[]{pd.getMaSP(), pd.getTenSP(), pd.getGia(), pd.getSoLuong()});
        }

    }

    private void showDetail() {
        int id = tbl_DieuChinh_Gia.getSelectedRow();
        if (id == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trong table để điều chỉnh giá");
            return;
        }

        txtGia_DieuChinh.setText(tbl_DieuChinh_Gia.getValueAt(id, 2).toString());
    }

    private void setDataCombobox() {
        cboCategory.addItem("Tất cả");
        for (Category category : listCategory) {
            String item = category.getCategoryName();
            cboCategory.addItem(item);
        }
        cboCategory.setSelectedIndex(0);
    }

    // Hàm lọc dữ liệu bằng comboBox
    private void filteDataByCategory() {
        int categoryId = 0;
        switch (cboCategory.getSelectedItem().toString()) {
            case "Thiết bị điện tử":
                categoryId = 1;
                break;
            case "Thời trang":
                categoryId = 2;
                break;
            case "Thực Phẩm":
                categoryId = 3;
                break;
            default:
                categoryId = 0;
        }
        if (categoryId == 0) {
            listProduct = serviceProduct.getAllProduct();
        } else {
            listProduct = serviceProduct.getAllProductByCategoryId(categoryId);

        }
        fillTable(listProduct);
    }

    // Hàm Update Price Product, chức năng điều chỉnh giá
    private void updatePriceProduct() {
        int id = tbl_DieuChinh_Gia.getSelectedRow();
        if (id == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trong table để điều chỉnh giá");
            return;
        }
       if(txtGia_DieuChinh.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng điền vào giá muốn cập nhật");
            return;
       }
        
        
        int maSp = Integer.parseInt(tbl_DieuChinh_Gia.getValueAt(id, 0).toString());
        System.out.println(maSp);
        String priceString = txtGia_DieuChinh.getText().trim();
        Double price = Double.parseDouble(priceString);

        if (priceString.equals("") || priceString == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền vào giá muốn cập nhật");
            return;
        }

        System.out.println(price);
        InvetoryLog invetoryLog = new InvetoryLog();
        invetoryLog.setProductId(maSp);
        invetoryLog.setPrice(price);

        serviceProduct.updatePriceProduct(maSp, price);
        inventoryLog_Service.insertPrice(invetoryLog);
        JOptionPane.showMessageDialog(this, "Điều chỉnh giá thành công");
        listProduct = serviceProduct.getAllProduct();
        fillTable(listProduct);

    }
    
    // 
    private Product getdata(int maSP) {
        int id = tbl_DieuChinh_Gia.getSelectedRow();
        txtGia_DieuChinh.setText(tbl_DieuChinh_Gia.getValueAt(id, 2).toString());
        String valueCbo = String.valueOf(cboCategory.getSelectedItem());
        int CategoryId;
        switch (valueCbo) {
            case "Thiết bị điện tử":
                CategoryId = 1;
                break;
            case "Thời trang":
                CategoryId = 2;
                break;
            case "Thực phẩm":
                CategoryId = 3;
                break;
            default:

                break;
        }

        maSP = Integer.parseInt(tbl_DieuChinh_Gia.getValueAt(id, 0).toString());
        Double price = Double.parseDouble(txtGia_DieuChinh.getText().trim());
        Product product = new Product();
        return product;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DieuChinh_Gia = new javax.swing.JTable();
        btnDieuChinh = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtGia_DieuChinh = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Điều Chỉnh Giá");

        jLabel2.setText("Danh Mục :");

        cboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryActionPerformed(evt);
            }
        });

        tbl_DieuChinh_Gia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá hiện hành", "Số lượng sản phẩm"
            }
        ));
        tbl_DieuChinh_Gia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DieuChinh_GiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DieuChinh_Gia);

        btnDieuChinh.setText("Điều Chỉnh");
        btnDieuChinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDieuChinhActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel4.setText("Giá điều chỉnh :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDieuChinh)
                .addGap(38, 38, 38)
                .addComponent(btnExit)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGia_DieuChinh))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 417, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGia_DieuChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit)
                    .addComponent(btnDieuChinh))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_DieuChinh_GiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DieuChinh_GiaMouseClicked
        // TODO add your handling code here:
        //showDetail();
        //updatePriceProduct();


    }//GEN-LAST:event_tbl_DieuChinh_GiaMouseClicked

    // Chức năng lọc dữ liệu theo danh mục
    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed
        // TODO add your handling code here:
        filteDataByCategory();
    }//GEN-LAST:event_cboCategoryActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDieuChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDieuChinhActionPerformed
        // TODO add your handling code here:
        //getdata();
        updatePriceProduct();
    }//GEN-LAST:event_btnDieuChinhActionPerformed

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
            java.util.logging.Logger.getLogger(View_DieuChinh_Gia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_DieuChinh_Gia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_DieuChinh_Gia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_DieuChinh_Gia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_DieuChinh_Gia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDieuChinh;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_DieuChinh_Gia;
    private javax.swing.JTextField txtGia_DieuChinh;
    // End of variables declaration//GEN-END:variables
}
