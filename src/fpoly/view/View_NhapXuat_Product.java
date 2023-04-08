/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fpoly.view;

import fpoly.interfaces.I_InvetoryLog_Service;
import fpoly.model.Category;
import fpoly.model.InvetoryLog;
import fpoly.model.Product;
import fpoly.service.Category_Service;
import fpoly.service.InventoryLog_Service;
import fpoly.service.Product_Service;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO T560
 */
public class View_NhapXuat_Product extends javax.swing.JFrame {

    private Product_Service serviceProduct = new Product_Service();
    private Category_Service serviceCategory = new Category_Service();
    private ArrayList<Product> listProduct = serviceProduct.getAllProduct();
    private ArrayList<Category> listCategory = serviceCategory.getAllCategorys();
    private InventoryLog_Service inventoryLogService = new InventoryLog_Service();

    public View_NhapXuat_Product() {
        initComponents();
        setDataCombobox();
        //filteDataByCategory();
        setLocationRelativeTo(null);
    }

    private void setDataCombobox() {
        cboCategory.addItem("Tất cả");
        for (Category category : listCategory) {
            String item = category.getCategoryName();
            cboCategory.addItem(item);
        }
        cboCategory.setSelectedIndex(0);
    }

    private void fillTable(ArrayList<Product> listProduct) {

        DefaultTableModel model = (DefaultTableModel) tblNhapXuatProduct.getModel();
        model.setRowCount(0);
        for (Product pd : listProduct) {
            model.addRow(new Object[]{pd.getMaSP(), pd.getTenSP(), pd.getSoLuong()});
        }

    }

    private void showDetail() {
        int row = tblNhapXuatProduct.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table");
            return;
        }
        // txtSoLuong_NhapXuat.setText(tblNhapXuatProduct.getValueAt(row, 2).toString());
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

    private void importProduct() {

        int row = tblNhapXuatProduct.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên Table");
            return;
        }

        String inputString = JOptionPane.showInputDialog(this, "Số lượng", "Số lượng nhập sản phẩm", JOptionPane.DEFAULT_OPTION);
        
         if (inputString == null || inputString.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn điều số lượng cần xuất sản phẩm");
            return;
        }
        
        // Số lượng hiện tại khi nhập 
        Integer inputQuantity = Integer.parseInt(inputString);
        int maSP = Integer.parseInt(tblNhapXuatProduct.getValueAt(row, 0).toString());
        Product product = serviceProduct.getProductId(maSP);
        // Số lượng sản phẩm hiện tại
        int currentQuantity = Integer.parseInt(tblNhapXuatProduct.getValueAt(row, 2).toString());
        // Kết quả tổng số lượng hiện tại
        int total = inputQuantity + currentQuantity;
        serviceProduct.updateQuantityProduct(maSP, total);
        Double price = product.getGia();
        //Insert vào InvenLog
        InvetoryLog invetoryLog = new InvetoryLog();
        invetoryLog.setProductId(maSP);
        invetoryLog.setQuality(inputQuantity);
        invetoryLog.setPrice(price);
        invetoryLog.setIoE(1);

        inventoryLogService.insert(invetoryLog);
        JOptionPane.showMessageDialog(this, "Nhập số lượng sản phẩm thành công");
        listProduct = serviceProduct.getAllProduct();
        fillTable(listProduct);
    }

    private void exportProduct() {
        int row = tblNhapXuatProduct.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên Table");
            return;
        }
        String inputString = JOptionPane.showInputDialog(this, "Số lượng", "Số lượng xuất sản phẩm", JOptionPane.DEFAULT_OPTION);

        //Validate Input Quantity
        if (inputString == null || inputString.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn điều số lượng cần xuất sản phẩm");
            return;
        }

        // Số lượng hiện tại khi nhập 
        Integer inputQuantity = Integer.parseInt(inputString);
        int maSP = Integer.parseInt(tblNhapXuatProduct.getValueAt(row, 0).toString());
        Product product = serviceProduct.getProductId(maSP);
        // Số lượng sản phẩm hiện tại
        int currentQuantity = Integer.parseInt(tblNhapXuatProduct.getValueAt(row, 2).toString());
        // Kết quả tổng số lượng hiện tại
        int total = currentQuantity - inputQuantity;
        serviceProduct.updateQuantityProduct(maSP, total);
        // Láy gia sp
        Double price = product.getGia();
        //Insert vào InvenLog
        InvetoryLog invetoryLog = new InvetoryLog();
        invetoryLog.setProductId(maSP);
        invetoryLog.setQuality(inputQuantity);
        invetoryLog.setPrice(price);
        invetoryLog.setIoE(0);

        inventoryLogService.insert(invetoryLog);

        //Product product = serviceProduct.getProductId(maSP);
        JOptionPane.showMessageDialog(this, "Xuất số lượng sản phẩm thành công");
        listProduct = serviceProduct.getAllProduct();
        fillTable(listProduct);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhapXuatProduct = new javax.swing.JTable();
        btn_Nhap_SanPham = new javax.swing.JButton();
        btn_Xuat_SanPham = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryActionPerformed(evt);
            }
        });

        jLabel1.setText("Danh Mục :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Nhập Xuất Product");

        tblNhapXuatProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số lượng"
            }
        ));
        tblNhapXuatProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhapXuatProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhapXuatProduct);

        btn_Nhap_SanPham.setText("Nhập Sản Phẩm");
        btn_Nhap_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Nhap_SanPhamActionPerformed(evt);
            }
        });

        btn_Xuat_SanPham.setText("Xuất Sản Phẩm");
        btn_Xuat_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Xuat_SanPhamActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(btn_Nhap_SanPham)
                            .addGap(18, 18, 18)
                            .addComponent(btn_Xuat_SanPham)
                            .addGap(18, 18, 18)
                            .addComponent(btnThoat))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Nhap_SanPham)
                    .addComponent(btn_Xuat_SanPham)
                    .addComponent(btnThoat))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhapXuatProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhapXuatProductMouseClicked
        // TODO add your handling code here:
        showDetail();
    }//GEN-LAST:event_tblNhapXuatProductMouseClicked

    private void btn_Nhap_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Nhap_SanPhamActionPerformed
        // TODO add your handling code here:
        importProduct();
    }//GEN-LAST:event_btn_Nhap_SanPhamActionPerformed

    private void btn_Xuat_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Xuat_SanPhamActionPerformed
        // TODO add your handling code here:
        exportProduct();
    }//GEN-LAST:event_btn_Xuat_SanPhamActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    // Chức năng lọc dữ liệu trong sự kiệm combobox
    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed
        // TODO add your handling code here:
        filteDataByCategory();
    }//GEN-LAST:event_cboCategoryActionPerformed

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
            java.util.logging.Logger.getLogger(View_NhapXuat_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_NhapXuat_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_NhapXuat_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_NhapXuat_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_NhapXuat_Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btn_Nhap_SanPham;
    private javax.swing.JButton btn_Xuat_SanPham;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNhapXuatProduct;
    // End of variables declaration//GEN-END:variables
}
