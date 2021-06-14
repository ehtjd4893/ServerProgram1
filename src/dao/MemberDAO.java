package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DBConnector;
import dto.MemberDTO;

public class MemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static MemberDAO dao = new MemberDAO();
	
	private MemberDAO() {
		con = DBConnector.getInstance().getConnection();
	}
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public List<MemberDTO> getList(){
		List<MemberDTO> list = null;
		
		try {
			sql = "SELECT NO, ID, NAME, GRADE, POINT FROM MEMBER_TABLE";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			list = new ArrayList<MemberDTO>();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGrade(rs.getString(4));
				dto.setPoint(rs.getInt(5));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return list;
	}

	public MemberDTO login(String id, String name) {
		MemberDTO dto = null;
		
		try {
			sql = "SELECT NO, ID, NAME, GRADE, POINT FROM MEMBER_TABLE WHERE ID = ? AND NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setNo(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGrade(rs.getString(4));
				dto.setPoint(rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return dto;
	}

	public int join(String id, String name) {
		int result = 0;
		
		try {
			sql = "INSERT INTO MEMBER_TABLE VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, 'bronze', 1000)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return result;
	}

	public MemberDTO update(MemberDTO dto) {
		MemberDTO result = new MemberDTO();
		
		try {
			sql = "UPDATE MEMBER_TABLE SET NAME = ?, POINT = ?, GRADE = ? WHERE ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getPoint());
			ps.setString(3, dto.getGrade());
			ps.setString(4, dto.getId());
			ps.executeUpdate();
			result.setName(dto.getName());
			result.setPoint(dto.getPoint());
			result.setGrade(dto.getGrade());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return result;
	}
}
