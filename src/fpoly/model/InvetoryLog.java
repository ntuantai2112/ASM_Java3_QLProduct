/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.model;

import java.util.Date;

/**
 *
 * @author LENOVO T560
 */
public class InvetoryLog extends Product{

    private int productId;
    private Date ieDate;
    private Integer ioE;
    private Integer quality;
    private double price;
    private Double revenie;
    

    public Double getRevenie() {
        return revenie;
    }

    public void setRevenie(Double revenie) {
        this.revenie = revenie;
    }

    public InvetoryLog() {
    }

    public InvetoryLog(int productId, Date ieDate, Integer ioE, Integer quality, double price) {
        this.productId = productId;
        this.ieDate = ieDate;
        this.ioE = ioE;
        this.quality = quality;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getIeDate() {
        return ieDate;
    }

    public void setIeDate(Date ieDate) {
        this.ieDate = ieDate;
    }

    public Integer getIoE() {
        return ioE;
    }

    public void setIoE(Integer ioE) {
        this.ioE = ioE;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
