package com.web.spring.dao.cjw;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.spring.vo.ApproveSch;
import com.web.spring.vo.Approve_f;
import com.web.spring.vo.Apvfile_f;
import com.web.spring.vo.Chatroom_f;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.FileSch;
import com.web.spring.vo.File_f;
import com.web.spring.vo.MeetingSch_f;
import com.web.spring.vo.Meeting_f;
import com.web.spring.vo.Metfile_f;
import com.web.spring.vo.RiskSch;
import com.web.spring.vo.Risk_f;
import com.web.spring.vo.Rskfile_f;
import com.web.spring.vo.Team;

@Mapper
public interface A03_Dao_cjw {
	// 결재
	List<Approve_f> myapv(ApproveSch sch);
	
	List<Approve_f> ckapv(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts=#{sts} and title like '%'||#{title}||'%' and pcode = #{pcode}")
	int mycnt(ApproveSch sch);
	
	@Select("SELECT count(af.apvno) FROM APPROVE_F af, approveadmin_f aaf WHERE af.apvno = aaf.apvno AND aaf.mempno=#{mempno} and af.sts='대기' and af.title like '%'||#{title}||'%' and af.pcode = #{pcode}")
	int tocnt(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts='대기' and pcode = #{pcode}")
	int myapvcnt(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts='반려' and pcode = #{pcode}")
	int badapvcnt(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts='완료' and pcode = #{pcode}")
	int goodapvcnt(ApproveSch sch);
	
	@Select("SELECT count(af.apvno) FROM APPROVE_F af, approveadmin_f aaf WHERE af.apvno = aaf.apvno AND aaf.mempno=#{mempno} and af.sts='대기' and af.pcode = #{pcode}")
	int toapvcnt(ApproveSch sch);
	
	@Insert("INSERT INTO approve_f values(apv_seq.nextval, #{title}, #{content}, #{wempno}, sysdate, '대기', #{writer}, #{pcode})")
	int insertapv(Approve_f ins);
	
	@Insert("INSERT INTO approveadmin_f values(apv_seq.currval, #{mempno}, NULL, null)")
	int insertapv2(Approve_f ins);
	
	@Insert("INSERT INTO apvfile_f values(apv_seq.currval, #{fname}, #{path}, #{fno})")
	int insertapvfile(Apvfile_f ins);
	
	@Insert("Insert into file_f values(file_seq.nextval, '결재', apv_seq.currval, #{fname}, #{path}, sysdate, #{fno}, #{empno}, #{pcode})")
	int insertfileapv(Apvfile_f ins);
	
	List<Team> getteammen(@Param("empno") int empno, @Param("pcode") int pcode);
	
	Approve_f detailapv(int apvno);
	
	@Select("SELECT fname, fno FROM apvfile_f WHERE apvno = #{apvno}")
	List<Apvfile_f> getapvfile(int apvno);
	
	@Update("UPDATE APPROVEADMIN_F SET ckdte = sysdate, feedback = #{feedback} where apvno = #{apvno}")
	int doapv(Approve_f apv);
	
	@Update("UPDATE APPROVE_F SET sts = #{sts} where apvno = #{apvno}")
	int doapv2(Approve_f apv);
	
	// 리스크 관리
	List<Risk_f> myrsk(RiskSch sch);
	
	List<Risk_f> ckrsk(RiskSch sch);
	
	List<Risk_f> torsk(RiskSch sch);
	
	List<Risk_f> finrsk(RiskSch sch);
	
	@Select("SELECT count(*) FROM RISK_F WHERE wempno = #{wempno} AND sts = '발생예정' and title like '%'||#{title}||'%' and pcode = #{pcode}")
	int myrskcntp(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.manager = #{manager} AND rf.sts = '발생예정' and rf.title like '%'||#{title}||'%' and rf.pcode = #{pcode}")
	int ckrskcntp(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.cempno = #{cempno} AND rf.sts = '처리중' and rf.title like '%'||#{title}||'%' and rf.pcode = #{pcode}")
	int torskcntp(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND (rf.wempno = #{wempno} OR rf2.cempno = #{cempno}) AND rf.sts = '완료' and rf.title like '%'||#{title}||'%' and rf.pcode = #{pcode}")
	int finrskcntp(RiskSch sch);
	
	@Select("SELECT count(*) FROM RISK_F WHERE wempno = #{wempno} AND sts = '발생예정' and pcode = #{pcode}")
	int myrskcnt(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.manager = #{manager} AND rf.sts = '발생예정' and rf.pcode = #{pcode}")
	int ckrskcnt(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.cempno = #{cempno} AND rf.sts = '처리중' and rf.pcode = #{pcode}")
	int torskcnt(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND (rf.wempno = #{wempno} OR rf2.cempno = #{cempno}) AND rf.sts = '완료' and rf.pcode = #{pcode}")
	int finrskcnt(RiskSch sch);
	
	@Insert("INSERT INTO RISK_F values(rsk_seq.nextval,#{title},sysdate,NULL,#{wempno},#{writer},#{content},'발생예정',#{pcode})")
	int insertrsk(Risk_f ins);
	
	@Insert("INSERT INTO RISKADMIN_F VALUES(rsk_seq.currval,NULL,NULL,NULL,NULL,#{manager},#{probability},#{danger})")
	int insertrsk2(Risk_f ins);
	
	@Select("SELECT empno FROM project_f WHERE pcode = #{pcode}")
	int getmymanager(int pcode);
	
	@Insert("INSERT INTO rskfile_f values(rsk_seq.currval, #{fname}, #{path}, #{fno})")
	int insertrskfile(Rskfile_f ins);
	
	@Insert("Insert into file_f values(file_seq.nextval, '리스크', rsk_seq.currval, #{fname}, #{path}, sysdate, #{fno}, #{empno}, #{pcode})")
	int insertfilersk(Rskfile_f ins);
	
	Risk_f detailrsk(int rskno);
	
	@Select("SELECT fname, fno FROM rskfile_f WHERE rskno = #{rskno}")
	List<Rskfile_f> getrskfile(int rskno);
	
	@Update("UPDATE RISK_F SET uptdte = sysdate, sts = '처리중' WHERE rskno = #{rskno}")
	int dorsk(Risk_f rsk);
	
	@Update("UPDATE RISKADMIN_F SET priority = #{priority}, cempno = #{cempno}, finaldte = to_date(#{finaldteStr},'YYYY-MM-DD'), probability = #{probability}, danger = #{danger}, feedback = #{feedback} WHERE rskno = #{rskno}")
	int dorsk2(Risk_f rsk);
	
	@Select("select fno from rskfile_f where rskno = #{rskno}")
	List<String> getrskfno(Risk_f rsk);
	
	@Select("select * from rskfile_f where fno = #{fno}")
	Rskfile_f getrskfileinfo(int fno);
	
	@Insert("Insert into file_f values(file_seq.nextval, '리스크', #{rskno}, #{fname}, #{path}, sysdate, #{fno}, #{empno}, #{pcode})")
	int insertfilersk2(Rskfile_f ins);
	
	@Update("UPDATE RISK_F set sts = '완료' where rskno = #{rskno}")
	int donersk(int rskno);
	
	// 회의록
	List<Meeting_f> metlist(MeetingSch_f sch);
	
	@Select("SELECT count(*) FROM MEETING_F WHERE pcode = #{pcode} AND title like '%'||#{title}||'%'")
	int totmet(MeetingSch_f sch);
	
	int insertmet(Meeting_f ins);
	
	@Insert("INSERT INTO metfile_f values(met_seq.currval, #{fname}, #{path}, #{fno})")
	int insertmetfile(Metfile_f ins);
	
	@Insert("Insert into file_f values(file_seq.nextval, '회의록', met_seq.currval, #{fname}, #{path}, sysdate, #{fno}, 0, #{pcode})")
	int insertfilemet(Metfile_f ins);
	
	@Select("SELECT fno_seq.nextval FROM dual")
	int getfno();
	
	Meeting_f detailmet(int metno);
	
	@Select("SELECT fname, fno FROM metfile_f WHERE metno = #{metno}")
	List<Metfile_f> getmetfile(int metno);
	
	@Select("SELECT fno FROM metfile_f WHERE metno = #{metno}")
	List<String> getfnobynamem (int metno);
	
	@Select("SELECT DISTINCT fname FROM file_f WHERE fno = #{fno}")
	String getfnamebyfno(String fno);
	
	int updatemet(Meeting_f upt);
	
	@Delete("DELETE FROM meeting_f WHERE metno = #{metno}")
	int deletemet(int metno);
	
	@Delete("DELETE FROM METFILE_F WHERE metno = #{metno}")
	int deletemetfile(int metno);
	
	@Delete("DELETE FROM file_f WHERE bno = #{metno}")
	int deletefilemet(int metno);
	
	// 문서관리
	List<File_f> boardfile(FileSch sch);
	
	@Select("SELECT count(*) FROM file_f WHERE  page NOT IN ('채팅','개인') AND fname like '%'||#{fname}||'%' AND page like '%'||#{page}||'%' AND (auth = #{empno} OR auth = 0) AND pcode = #{pcode}")
	int boardfilecnt(FileSch sch);
	
	@Insert("Insert into file_f values(file_seq.nextval, '개인', file_seq.currval, #{fname}, #{path}, sysdate, #{fno}, #{empno}, 0)")
	int insertfilemy(String fname, String path, String fno, int empno);
	
	@Insert("Insert into file_f values(file_seq.nextval, '팀', file_seq.currval, #{fname}, #{path}, sysdate, #{fno}, #{empno}, #{pcode})")
	int insertfileteam(String fname, String path, String fno, int empno, int pcode);
	
	List<File_f> teamfile(FileSch sch);
	
	@Select("SELECT pname FROM PROJECT_F WHERE pcode = #{pcode}")
	String getpname(int pcode);
	
	@Select("SELECT count(*) FROM file_f WHERE  page = '팀' AND fname like '%'||#{fname}||'%' AND page like '%'||#{page}||'%' AND pcode=#{pcode}")
	int teamfilecnt(FileSch sch);
	
	List<File_f> myfile(FileSch sch);
	
	@Select("SELECT count(*) FROM file_f WHERE  page = '개인' AND fname like '%'||#{fname}||'%' AND page like '%'||#{page}||'%' AND auth = #{empno}")
	int myfilecnt(FileSch sch);
	
	@Delete("DELETE FROM file_f WHERE fno = #{fno}")
	int deletefile(String fno);
	
	// 채팅
	@Select("SELECT empno, ename||' ('||dname||')' ename FROM EMP_PINFO_F ORDER BY ename")
	List<Emp_pinfo_f> empList();
	
	@Select("SELECT crno_seq.nextval FROM dual")
	int crno();
	
	@Insert("INSERT INTO chatroom_f values(#{crno}, #{crname}, #{userid}, #{username})")
	int makechatroom(Chatroom_f ins);
	
	@Select("SELECT ename||'('||dname||')' username FROM EMP_PINFO_F WHERE empno = #{userid}")
	String namebyempno(int userid);
	
	@Select("SELECT * FROM chatroom_f WHERE userid = #{empno} ORDER BY crno")
	List<Chatroom_f> chatroomlist(int empno);
	
	@Select("SELECT userid FROM chatroom_f WHERE crno = #{crno}")
	List<String> getuseridbycrno(int crno);
	
	
	@Insert("MERGE INTO chatroom_f target USING (SELECT #{crname} AS crname, #{username} AS username from dual) source ON (target.crname = source.crname AND target.username = source.username) WHEN NOT MATCHED THEN INSERT (crname, username) VALUES (source.crname, source.username)")
	int insChatRoom(Chatroom_f ins);
	
	@Delete("Delete from chatroom_f where  username=#{username}  and crname = #{crname}	")
	int delChatRoom(Chatroom_f del);

	@Delete("Delete from chatroom_f where  username=#{username}")
	int delChatId(@Param("username") String username);	
	
	@Select("SELECT DISTINCT crname FROM chatroom_f")
	List<String> getChRooms();
	
	@Select("SELECT username FROM chatroom_f WHERE crname = (SELECT crname FROM chatroom_f WHERE username=#{username})")
	List<String> getChRoomIds(@Param("username") String username);
	
	@Select("	SELECT username FROM chatroom_f WHERE  crname = #{crname}")
	List<String> getIdsByRoom(@Param("crname") String crname);
	
}
