package xyz.barreiro.usc.daw.repository;

import xyz.barreiro.usc.daw.models.CD;
import xyz.barreiro.usc.daw.utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class CDRepository {
    public static List<CD> getAllCds() {
        List<CD> cds = new LinkedList<>();

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM cds")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cds.add(new CD(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("artist"),
                        rs.getString("country"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return cds;
    }

    public static Optional<CD> getCdById(Integer id) {
        CD cd = null;

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM cds WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cd = new CD(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("artist"),
                        rs.getString("country"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Optional.ofNullable(cd);
    }
}
