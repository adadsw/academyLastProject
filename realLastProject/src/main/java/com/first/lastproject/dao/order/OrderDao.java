package com.first.lastproject.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.HostOrderListDto;
import com.first.lastproject.dto.OrderDto;

public class OrderDao implements InterfaceOrderDao {
	DataSource dataSource;

	private static OrderDao instance;

	public static OrderDao getInstance() {
		if (instance == null) {
			instance = new OrderDao();
		}
		return instance;
	}

	private OrderDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertOrder(String id, int seat_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO p_order VALUES (seq_order_code.nextval,?,?,sysdate,sysdate+3/24)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat_code);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int insertOrderMenu(String order_code, int food_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO p_order_menu VALUES (?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_code);
			pstmt.setInt(2, food_code);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public String getOrder_code(int seat_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String order_id = null;
		try {
			con = dataSource.getConnection(); // 컨넥션풀에서 connection객체 가져온다.
			String sql = "select * from p_order where seat_num=? order by order_time DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat_num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				order_id = rs.getString("order_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return order_id;
	}
	
	public ArrayList<HostOrderListDto> getOrderList() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HostOrderListDto> orderList = new ArrayList<HostOrderListDto>();
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from order_menu o join food f on(o.food_code=f.food_code)";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HostOrderListDto HOLdto = new HostOrderListDto();
				
				HOLdto.setFood_code(rs.getInt("food_code"));
				HOLdto.setSeat_num(rs.getInt("seat_num"));
				HOLdto.setFood_name(rs.getString("food_name"));
				
				}
			}catch (SQLException e) {
				e.getStackTrace();
			}finally{
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.getStackTrace();
				}
			}
			return orderList;
		}
	public ArrayList<OrderDto> getOrder_done() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderDto> order_done = new ArrayList<OrderDto>();
		
		try {
			con = dataSource.getConnection();
			String sql = "select*from p_order where order_done=0";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				OrderDto orderDto= new OrderDto();
				orderDto.setOrder_done(rs.getInt("order_done"));
				orderDto.setOrder_id(rs.getString("order_id"));
				orderDto.setSeat_num(rs.getInt("seat_num"));
				
				}
			}catch (SQLException e) {
				e.getStackTrace();
			}finally{
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.getStackTrace();
				}
			}
		
		
		
		
		return order_done;
	}
	
}
