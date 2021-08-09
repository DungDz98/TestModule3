package model;

public class Product {
    private int idsp;
    private String tensp;
    private int gia;
    private int soluong;
    private String mausac;
    private String mota;
    private String danhmuc;

    public Product() {

    }

    public Product(int idsp, String tensp, int gia, int soluong, String mausac, String mota, String danhmuc) {
        this.idsp = idsp;
        this.tensp = tensp;
        this.gia = gia;
        this.soluong = soluong;
        this.mausac = mausac;
        this.mota = mota;
        this.danhmuc = danhmuc;
    }

    public Product(String tensp, int gia, int soluong, String mausac, String mota, String danhmuc) {
        this.tensp = tensp;
        this.gia = gia;
        this.soluong = soluong;
        this.mausac = mausac;
        this.mota = mota;
        this.danhmuc = danhmuc;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }
}
