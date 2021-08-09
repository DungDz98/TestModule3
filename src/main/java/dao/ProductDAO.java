package dao;

import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private ConnDAO connDAO;

    public ProductDAO() {
        connDAO = new ConnDAO();
    }

    private static final String INSERT_PRODUCT = "insert into Product(tensp, gia, soluong, mausac, mota, danhmuc) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PRODUCT = "select * from Product";
    private static final String SELECT_PRODUCT = "select * from Product where idsp = ?";
    private static final String DELETE_PRODUCT = "delete from Product where idsp = ?";
    private static final String UPDATE_PRODUCT = "update Product set tensp = ?, gia = ?, soluong = ?, mausac = ?, mota = ?, danhmuc = ? where idsp = ?";

    public void insertProduct(Product product) {
        try {
            PreparedStatement pS = connDAO.getConnection().prepareStatement(INSERT_PRODUCT);
            pS.setString(1, product.getTensp());
            pS.setInt(2, product.getGia());
            pS.setInt(3, product.getSoluong());
            pS.setString(4, product.getMausac());
            pS.setString(5, product.getMota());
            pS.setString(6, product.getDanhmuc());
            pS.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Product selectProduct(int idsp) {
        Product product = null;
        try {
            PreparedStatement pS = connDAO.getConnection().prepareStatement(SELECT_PRODUCT);
            pS.setInt(1, idsp);
            ResultSet rs = pS.executeQuery();
            while (rs.next()) {
                String tennv = rs.getString("tensp");
                int ngaysinh = rs.getInt("gia");
                int diachi = rs.getInt("soluong");
                String sdt = rs.getString("mausac");
                String email = rs.getString("mota");
                String phongban = rs.getString("danhmuc");
                product = new Product(idsp, tennv, ngaysinh, diachi, sdt, email, phongban);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement pS = connDAO.getConnection().prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = pS.executeQuery();
            while (rs.next()) {
                int idsp = rs.getInt("idsp");
                String tennv = rs.getString("tensp");
                int ngaysinh = rs.getInt("gia");
                int diachi = rs.getInt("soluong");
                String sdt = rs.getString("mausac");
                String email = rs.getString("mota");
                String phongban = rs.getString("danhmuc");
                products.add(new Product(idsp, tennv, ngaysinh, diachi, sdt, email, phongban));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public void deleteProduct(int idsp) {
        try {
            PreparedStatement pS = connDAO.getConnection().prepareStatement(DELETE_PRODUCT);
            pS.setInt(1, idsp);
            pS.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            PreparedStatement pS = connDAO.getConnection().prepareStatement(UPDATE_PRODUCT);
            pS.setString(1, product.getTensp());
            pS.setInt(2, product.getGia());
            pS.setInt(3, product.getSoluong());
            pS.setString(4, product.getMausac());
            pS.setString(5, product.getMota());
            pS.setString(6, product.getDanhmuc());
            pS.setInt(7, product.getIdsp());
            pS.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> findProductByName(String fName) {
        List<Product> products = new ArrayList<>();
        String FIND_PRODUCT_BY_NAME = "select * from product where tensp like '%" + fName + "%'";
        try {
            PreparedStatement pS = connDAO.getConnection().prepareStatement(FIND_PRODUCT_BY_NAME);
            ResultSet rs = pS.executeQuery();
            while (rs.next()) {
                int idsp = rs.getInt("idsp");
                String tennv = rs.getString("tensp");
                int ngaysinh = rs.getInt("gia");
                int diachi = rs.getInt("soluong");
                String sdt = rs.getString("mausac");
                String email = rs.getString("mota");
                String phongban = rs.getString("danhmuc");
                products.add(new Product(idsp, tennv, ngaysinh, diachi, sdt, email, phongban));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}

