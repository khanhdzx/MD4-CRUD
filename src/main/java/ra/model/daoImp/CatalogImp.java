package ra.model.daoImp;

import org.springframework.stereotype.Repository;
import ra.model.dao.CatalogDao;
import ra.model.entity.Catalog;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CatalogImp implements CatalogDao {

    @Override
    public List<Catalog> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getAllCatalog()}");
            ResultSet rs = callSt.executeQuery();
            listCatalog = new ArrayList<>();
            while (rs.next()) {
                Catalog ct = new Catalog();
                ct.setCatalogId(rs.getInt("CatalogId"));
                ct.setCatalogName(rs.getString("CatalogName"));
                ct.setAge(rs.getInt("Age"));
                ct.setSex(rs.getBoolean("Sex"));
                ct.setBirthDate(rs.getDate("BrithDate"));
                ct.setAddress(rs.getString("Address"));
                ct.setCatalogStatus(rs.getBoolean("CatalogStatus"));
                listCatalog.add(ct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCatalog;
    }

    @Override
    public Catalog findById(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Catalog ct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getCatalogById(?)}");
            callSt.setInt(1, catalogId);
            ResultSet rs = callSt.executeQuery();
            ct = new Catalog();
            if (rs.next()) {
                ct.setCatalogId(rs.getInt("CatalogId"));
                ct.setCatalogName(rs.getString("CatalogName"));
                ct.setAge(rs.getInt("Age"));
                ct.setSex(rs.getBoolean("Sex"));
                ct.setBirthDate(rs.getDate("BrithDate"));
                ct.setAddress(rs.getString("Address"));
                ct.setCatalogStatus(rs.getBoolean("CatalogStatus"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return ct;
    }

    @Override
    public boolean save(Catalog ct) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call insertCatalog(?,?,?,?,?,?)}");
            callSt.setString(1, ct.getCatalogName());
            callSt.setInt(2, ct.getAge());
            callSt.setBoolean(3, ct.isSex());
            callSt.setString(4, ct.getAddress());
            callSt.setDate(5, new Date(ct.getBirthDate().getTime()));
            callSt.setBoolean(6, ct.isCatalogStatus());
            callSt.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Catalog ct) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call updateCatalog(?,?,?,?,?,?,?)}");
            callSt.setInt(1, ct.getCatalogId());
            callSt.setString(2, ct.getCatalogName());
            callSt.setInt(3, ct.getAge());
            callSt.setBoolean(4, ct.isSex());
            callSt.setString(5, ct.getAddress());
            callSt.setDate(6, new Date(ct.getBirthDate().getTime()));
            callSt.setBoolean(7, ct.isCatalogStatus());
            callSt.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteCatalog(?)}");
            callSt.setInt(1, catalogId);
            callSt.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public List<Catalog> search(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_seachCatalog(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            listCatalog = new ArrayList<>();
            while (rs.next()) {
                Catalog ct = new Catalog();
                ct.setCatalogId(rs.getInt("CatalogId"));
                ct.setCatalogName(rs.getString("CatalogName"));
                ct.setAge(rs.getInt("Age"));
                ct.setSex(rs.getBoolean("Sex"));
                ct.setBirthDate(rs.getDate("BrithDate"));
                ct.setAddress(rs.getString("Address"));
                ct.setCatalogStatus(rs.getBoolean("CatalogStatus"));
                listCatalog.add(ct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCatalog;
    }
}
