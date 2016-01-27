package com.first.lastproject.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.GoodsDto;

public class FoodDao implements InterfaceFoodDao {
	DataSource dataSource;
	
	private static FoodDao instance;
	
	public static FoodDao getInstance() {
		if (instance == null) {
			instance = new FoodDao();
		}
		return instance;
	}
	
	private FoodDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<GoodsDto> goods() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsDto> goodslist = null;
		
		try {
			con = dataSource.getConnection(); //컨넥션풀에서 connection객체 가져온다.
			String sql = "select * from p_food";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(goodslist == null) {
					goodslist = new ArrayList<GoodsDto>();
				}
				GoodsDto goods = new GoodsDto(); 
			goods.setFood_code(rs.getInt(1));
			goods.setFood_name(rs.getString(2));
			goods.setPrice(rs.getInt(3));
			goods.setFood_num(rs.getInt(4));
			goodslist.add(goods);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return goodslist;
	}

		

}