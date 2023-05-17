package xyz.barreiro.usc.daw.models.repository;

import xyz.barreiro.usc.daw.models.CD;
import xyz.barreiro.usc.daw.models.Order;
import xyz.barreiro.usc.daw.models.OrderCD;
import xyz.barreiro.usc.daw.models.User;
import xyz.barreiro.usc.daw.utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class OrderRepository {
    public static Optional<Order> getOrderById(Integer id) {
        Order order = null;

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM orders WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Optional<User> optionalUser = UserRepository.getUserById(rs.getInt("user_id"));
                assert optionalUser.isPresent();
                order = new Order(
                        rs.getInt("id"),
                        optionalUser.get(),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Optional.ofNullable(order);
    }

    public static Optional<Order> getLastOrderFromUser(User user) {
        Order order = null;

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM orders WHERE user_id=? ORDER BY id DESC LIMIT 1")) {
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order(
                        rs.getInt("id"),
                        user,
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Optional.ofNullable(order);
    }

    public static List<OrderCD> getOrderCdsByOrder(Order order) {
        List<OrderCD> cds = new ArrayList<>();

        try (PreparedStatement ps = DbConnection.prepareStatement("SELECT * FROM orders_cds WHERE order_id=?")) {
            ps.setInt(1, order.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Optional<CD> optionalCD = CDRepository.getCdById(rs.getInt("cd_id"));
                assert optionalCD.isPresent();
                cds.add(new OrderCD(
                        rs.getInt("id"),
                        order,
                        optionalCD.get(),
                        rs.getInt("amount")
                ));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return cds;
    }

    public static boolean createOrder(User user, Double price) {

        try (PreparedStatement ps = DbConnection.prepareStatement("INSERT INTO orders (user_id, price) VALUES (?, ?)")) {
            ps.setInt(1, user.getId());
            ps.setDouble(2, price);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public static boolean createOrderCd(Order order, CD cd, Integer amount) {

        try (PreparedStatement ps = DbConnection.prepareStatement("INSERT INTO orders_cds (order_id, cd_id, amount) VALUES (?, ?, ?)")) {
            ps.setInt(1, order.getId());
            ps.setInt(2, cd.getId());
            ps.setInt(3, amount);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
