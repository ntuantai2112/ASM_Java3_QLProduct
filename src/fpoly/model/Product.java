/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.model;

/**
 *
 * @author LENOVO T560
 */
public class Product extends Category {

    private int maSP;
    private String tenSP;
    private Double gia;
    private String danhMuc;
    private int soLuong;
    private int categoryId;
    private String topic1;
    private String topic2;


    public Product() {
    }

    public Product(int maSP, int categoryId, String tenSP, Double gia, int soLuong, String topic1, String topic2) {
        this.maSP = maSP;
        this.categoryId = categoryId;
        this.tenSP = tenSP;
        this.gia = gia;
        this.soLuong = soLuong;
        this.topic1 = topic1;
        this.topic2 = topic2;

    }

    public Product(int maSP, int categoryId, String tenSP, Double gia, int soLuong) {
        this.maSP = maSP;
        this.categoryId = categoryId;
        this.tenSP = tenSP;
        this.gia = gia;
        this.soLuong = soLuong;

    }

    public Product(int categoryId, String tenSP, Double gia, int soLuong, String topic1, String topic2) {
        this.categoryId = categoryId;
        this.tenSP = tenSP;
        this.gia = gia;
        this.soLuong = soLuong;
        this.topic1 = topic1;
        this.topic2 = topic2;

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTopic1() {
        return topic1;
    }

    public void setTopic1(String topic1) {
        this.topic1 = topic1;
    }

    public String getTopic2() {
        return topic2;
    }

    public void setTopic2(String topic2) {
        this.topic2 = topic2;
    }

}
