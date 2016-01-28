package com.first.lastproject.dao.ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.IngredientDto;

public class IngredientDao implements InterfaceIngredientDao {
	DataSource dataSource;

	private static IngredientDao instance;

	public static IngredientDao getInstance() {
		if (instance == null) {
			instance = new IngredientDao();
		}
		return instance;
	}

	private IngredientDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getIngredient() {
		return 0;
	}

	@Override
	public List<IngredientDto> listIngredient() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<IngredientDto> ingredientList = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT ingredient_code, ingredient, ingre_num FROM p_ingredient";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (ingredientList == null) {
					ingredientList = new ArrayList<IngredientDto>();
				}
				IngredientDto dto = new IngredientDto();
				dto.setIngredient_code(rs.getInt("ingredient_code"));
				dto.setIngredient(rs.getString("ingredient"));
				dto.setIngre_num(rs.getInt("ingre_num"));
				ingredientList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return ingredientList;
	}

	@Override
	public int modifyingredient(int ingredient_code, int ingre_num) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_ingredient SET ingre_num=? WHERE ingredient_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ingre_num);
			pstmt.setInt(2, ingredient_code);

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return count;
	}
}
