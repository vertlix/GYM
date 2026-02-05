package database;

import model.member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {

    public void insert(member m) {
        String sql = "INSERT INTO member (member_id, name, visit_count) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getID());
            ps.setString(2, m.getName());
            ps.setInt(3, m.getVisitcount());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<member> getAll() {
        List<member> members = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                members.add(
                        new member(
                                rs.getInt("member_id"),
                                rs.getString("name"),
                                rs.getInt("visit_count")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public member getById(int id) {
        String sql = "SELECT * FROM member WHERE member_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getInt("visit_count")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(member m) {
        String sql = "UPDATE member SET name = ?, visit_count = ? WHERE member_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getName());
            ps.setInt(2, m.getVisitcount());
            ps.setInt(3, m.getID());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM member WHERE member_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<member> searchByName(String name) {
        List<member> result = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(
                        new member(
                                rs.getInt("member_id"),
                                rs.getString("name"),
                                rs.getInt("visit_count")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<member> searchByVisits(int minVisits) {
        List<member> result = new ArrayList<>();
        String sql = "SELECT * FROM member WHERE visit_count >= ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, minVisits);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(
                        new member(
                                rs.getInt("member_id"),
                                rs.getString("name"),
                                rs.getInt("visit_count")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
