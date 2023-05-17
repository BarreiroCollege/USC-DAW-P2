package xyz.barreiro.usc.daw.models.repository;

import xyz.barreiro.usc.daw.models.CardType;
import xyz.barreiro.usc.daw.models.User;
import xyz.barreiro.usc.daw.utils.DbConnection;
import xyz.barreiro.usc.daw.utils.PasswordHash;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public final class UserRepository {
    private static User resultSetToUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                CardType.fromString(rs.getString("card_type")),
                rs.getString("card_number")
        );
    }

    public static Optional<User> getUserById(Integer id) {
        User user = null;

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM users WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = resultSetToUser(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Optional.ofNullable(user);
    }

    public static Optional<User> getUserByEmail(String email) {
        User user = null;

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM users WHERE email=?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = resultSetToUser(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Optional.ofNullable(user);
    }

    public static Optional<User> getUserByEmailAndPassword(String email, String password) {
        User user = null;

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM users WHERE email=?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String correctHash = rs.getString("password");
                if (PasswordHash.validatePassword(password, correctHash)) {
                    user = resultSetToUser(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Optional.ofNullable(user);
    }

    public static boolean createUser(String name, String email, String password, CardType cardType, String cardNumber) {
        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM users WHERE email=?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try (PreparedStatement ps = DbConnection.prepareStatement("INSERT INTO users (name, email, password, card_type, card_number) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, PasswordHash.createHash(password));
            ps.setString(4, cardType.toString());
            ps.setString(5, cardNumber);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
