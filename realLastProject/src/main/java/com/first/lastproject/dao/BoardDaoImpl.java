package com.first.lastproject.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.first.lastproject.dto.BoardDto;


@Repository
public class BoardDaoImpl implements BoardDao {
	DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	//private static BoardDaoImpl instance;
	
	/*public static BoardDaoImpl getInstance() {
		if (instance == null) {
			instance = new BoardDaoImpl();
		}
		return instance;
	}
	
	private BoardDaoImpl() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public int getCount() {
		int count = 0;
		BoardDao dao = this.sqlSession.getMapper(BoardDao.class);
		count = dao.getCount();
		return count;
		
		
		/*
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from p_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return count; */
	}

	@Override
	public ArrayList<BoardDto> getArticles(Map<String, Integer> map) {
		ArrayList<BoardDto> dtos = null;
		BoardDao dao = this.sqlSession.getMapper(BoardDao.class);
		dtos = dao.getArticles(map);
		return dtos;
		
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from "
					+ "(select num, id, email, subject, passwd, reg_date, ref, re_step,"
					+ "re_level, content, ip, readcount, rownum rnum from "
					+ "(select * from p_board order by ref desc, re_step asc)) where rnum >= ? and rnum <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dtos = new ArrayList<BoardDto> (end - start + 1);
				
				do {
					BoardDto dto = new BoardDto();
					dto.setNum(rs.getInt("num"));
					dto.setId(rs.getString("id"));
					dto.setEmail(rs.getString("email"));
					dto.setSubject(rs.getString("subject"));
					dto.setPasswd(rs.getString("passwd"));
					dto.setReg_date(rs.getTimestamp("reg_date"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setRef(rs.getInt("ref"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					dto.setContent(rs.getString("content"));
					dto.setIp(rs.getString("ip"));
					dtos.add(dto);
				} while(rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;*/
	}

	@Override
	public int writeArticle(BoardDto dto) {
		int count = 0;
		int num = dto.getNum();
		int ref = dto.getRef();
		int re_level = dto.getRe_level();
		int re_step = dto.getRe_step();
		
		BoardDao boardDao = this.sqlSession.getMapper(BoardDao.class);
		//제목글인 경우
		if (num == 0) {
			count = getCount(); //글개수
			
			if (count > 0) {
				int maxNum = getMaxNum();
				ref = maxNum + 1; //그룹화 아이디 = 글번호 최대값 + 1;
			} else {
				//글이 없는 경우
				ref = 1;
			}
			dto.setRef(ref);
			re_step = 0;
			re_level = 0;
		//답변글인 경우
		} else {
			updateReply(dto);
			re_step++;
			re_level++;
		}
		
		dto.setRe_step(re_step);
		dto.setRe_level(re_level);
		
		count = boardDao.writeArticle(dto);
		return count;
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			int num = dto.getNum();
			int ref = dto.getRef();
			int re_step = dto.getRe_step();
			int re_level = dto.getRe_level();
			String sql = null;
			if (num == 0) {	//제목글인 경우
				sql = "select max(num) from p_board";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					// 글이 있는 경우
					ref = rs.getInt(1) + 1; //그룹화 아이디 = 글번호 최대값 + 1;
				} else {
					// 글이 없는 경우
					ref = 1;
				}
				re_step = 0;
				re_level = 0;
			} else {
				//답변글인 경우
				sql = "update p_board set re_step = re_step + 1 where ref=? and re_step>?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				
				re_step++;
				re_level++;
			}
			
			
			
			sql = "insert into p_board (num, id, email, subject, passwd, reg_date, "
					+ "ref, re_step, re_level, content, ip) values (p_board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt.close();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setTimestamp(5, dto.getReg_date());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, dto.getContent());
			pstmt.setString(10, dto.getIp());
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count; */
	}
	public int getMaxNum() {
		int maxNum = 0;
		BoardDao dao = this.sqlSession.getMapper(BoardDao.class);
		maxNum = dao.getMaxNum();
		return maxNum;
	}
	//글쓰기-답변글인 경우
	public void updateReply(BoardDto dto) {
		BoardDao dao = this.sqlSession.getMapper(BoardDao.class);
		dao.updateReply(dto);
	}

	@Override
	public BoardDto getArticle(int num) {
		BoardDto dto = null;
		BoardDao dao = this.sqlSession.getMapper(BoardDao.class);
		dto= dao.getArticle(num);
		return dto;
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto dto = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from p_board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setEmail(rs.getString("email"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setIp(rs.getString("ip"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return dto;*/
	}

	@Override
	public int addCount(int num) {
		int result=0;
		BoardDao dao =this.sqlSession.getMapper(BoardDao.class);
		result =dao.addCount(num);
		return result;
		
		/*
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "update p_board set readcount = readcount + 1 where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return result; */
	}
	public int check(Map<String, Object> map) {
		int resultPasswd = 0;
		BoardDao dao = this.sqlSession.getMapper(BoardDao.class);
		resultPasswd = dao.check(map);
		return resultPasswd;
		/*
		try {
			con = dataSource.getConnection();
			String sql ="select *from p_board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs= pstmt.executeQuery();
			
			if(rs.next()) { // 글번호가 일치를 하면, 
				if(passwd.equals(rs.getString("passwd"))) { // 비밀번호가 일치하면, 화면에서 입력받은 passwd와(passwd.equals) 
																	// db에서 읽어온 passwd가 일치한지 ... "passwd"가 db패스워드.
					count = 1;
				} else {
					count =0; //비밀번호가 일치하지 않으면,
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;*/
		
	}
	
	//글삭제-- 답글이 있는지 없는지 판단
	public int checkReply(BoardDto dto) {
		int result =0;
		BoardDao dao= this.sqlSession.getMapper(BoardDao.class);
		result=dao.checkReply(dto);
		
		//sql = "select * from mvc_board where ref=? and re_step=?+1 and re_level>?";
		 
		return result;
		}
	
	public int deleteArticle(int num) {
		
		int result=0;
		BoardDao dao= this.sqlSession.getMapper(BoardDao.class);
		
		BoardDto dto = getArticle(num);
		int count =checkReply(dto);
		if (count !=0) {
			// 답글이 있는 경우
			result = -1;
		} else {
			// 답글이 없는 경우
			result =dao.deleteArticle(num);
		}
		
		return result;
		/*
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql ="select *from p_board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_level = rs.getInt("re_level");
				
				sql = "select * from p_board where ref=? and re_step=?+1 and re_level>?";
				pstmt.close(); // 위에 썻으니깐
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.setInt(3, re_level);
				rs.close();
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					//답글이 있는 경우
					count = -1;
				} else {
					//답글이 없는 경우 
					
					sql = "delete from p_board where num=?";
					pstmt.close(); // 위에 썻으니깐
					pstmt= con.prepareStatement(sql);
					pstmt.setInt(1, num);
					count = pstmt.executeUpdate();
					
				}
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;*/
	}
	public int updateArticle(BoardDto dto){
		int count = 0;
		BoardDao dao= this.sqlSession.getMapper(BoardDao.class);
		count = dao.updateArticle(dto);
		return count;
		/*
			try {
				con = dataSource.getConnection();
				String sql = "update p_board set email=?, subject=?, content=?, passwd=? where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getEmail());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getPasswd());
				pstmt.setInt(5, dto.getNum());
				
				count = pstmt.executeUpdate();
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;*/
			
		}

	@Override
	public ArrayList<BoardDto> searchWriter(String id){
		ArrayList<BoardDto> dtos = null;
		BoardDao dao= this.sqlSession.getMapper(BoardDao.class);
		dtos=dao.searchWriter(id);
		return dtos;
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from p_board where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (dtos == null) {
					dtos = new ArrayList<BoardDto>();
				}
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setEmail(rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
				dtos.add(dto);
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return dtos; */
	}
		

	@Override
	public ArrayList<BoardDto> searchSubject(String subject) {
		ArrayList<BoardDto> dtos = null;
		BoardDao dao= this.sqlSession.getMapper(BoardDao.class);
		dtos=dao.searchSubject(subject);
		return dtos;
		
		
		/*Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from p_board where subject like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+ subject +"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (dtos == null) {
					dtos = new ArrayList<BoardDto>();
				}
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setEmail(rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
				dtos.add(dto);
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return dtos; */
	}
	
	public int getSeachWriterCount(String id) {
		
		int count = 0;
		BoardDao dao= this.sqlSession.getMapper(BoardDao.class);
		count = dao.getSeachWriterCount(id);
		
		return count;
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from p_board where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return count; */
	}
	@Override
	public int getSeachSubjectCount(String subject) {
		int count = 0;
		BoardDao dao= this.sqlSession.getMapper(BoardDao.class);
		count = dao.getSeachSubjectCount(subject);
		return count;
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from p_board where subject like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+subject+"%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return count; */
	}


	
}
