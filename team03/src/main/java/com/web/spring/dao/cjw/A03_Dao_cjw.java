package com.web.spring.dao.cjw;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.spring.vo.ApproveSch;
import com.web.spring.vo.Approve_f;
import com.web.spring.vo.Apvfile_f;
import com.web.spring.vo.MeetingSch_f;
import com.web.spring.vo.Meeting_f;
import com.web.spring.vo.Metfile_f;
import com.web.spring.vo.RiskSch;
import com.web.spring.vo.Risk_f;
import com.web.spring.vo.Rskfile_f;

@Mapper
public interface A03_Dao_cjw {
	// 결재
	List<Approve_f> myapv(ApproveSch sch);
	
	List<Approve_f> ckapv(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts=#{sts} and title like '%'||#{title}||'%'")
	int mycnt(ApproveSch sch);
	
	@Select("SELECT count(af.apvno) FROM APPROVE_F af, approveadmin_f aaf WHERE af.apvno = aaf.apvno AND aaf.mempno=#{mempno} and af.sts='대기' and af.title like '%'||#{title}||'%'")
	int tocnt(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts='대기'")
	int myapvcnt(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts='반려'")
	int badapvcnt(ApproveSch sch);
	
	@Select("SELECT count(*) FROM APPROVE_F WHERE wempno=#{wempno} and sts='완료'")
	int goodapvcnt(ApproveSch sch);
	
	@Select("SELECT count(af.apvno) FROM APPROVE_F af, approveadmin_f aaf WHERE af.apvno = aaf.apvno AND aaf.mempno=#{mempno} and af.sts='대기'")
	int toapvcnt(ApproveSch sch);
	
	@Insert("INSERT INTO approve_f values(apv_seq.nextval, #{title}, #{content}, #{wempno}, sysdate, '대기', #{writer})")
	int insertapv(Approve_f ins);
	
	@Insert("INSERT INTO approveadmin_f values(apv_seq.currval, #{mempno}, NULL, null)")
	int insertapv2(Approve_f ins);
	
	@Insert("INSERT INTO apvfile_f values(apv_seq.currval, #{fname}, #{path}, #{fno})")
	int insertapvfile(Apvfile_f ins);
	
	@Insert("Insert into file_f values(file_seq.nextval, '결재', apv_seq.currval, #{fname}, #{path}, sysdate, #{fno}, #{empno})")
	int insertfileapv(Apvfile_f ins);
	
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
	
	@Select("SELECT count(*) FROM RISK_F WHERE wempno = #{wempno} AND sts = '발생예정' and title like '%'||#{title}||'%'")
	int myrskcntp(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.manager = #{manager} AND rf.sts = '발생예정' and rf.title like '%'||#{title}||'%'")
	int ckrskcntp(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.cempno = #{cempno} AND rf.sts = '처리중' and rf.title like '%'||#{title}||'%'")
	int torskcntp(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND (rf.wempno = #{wempno} OR rf2.cempno = #{cempno}) AND rf.sts = '완료' and rf.title like '%'||#{title}||'%'")
	int finrskcntp(RiskSch sch);
	
	@Select("SELECT count(*) FROM RISK_F WHERE wempno = #{wempno} AND sts = '발생예정'")
	int myrskcnt(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.manager = #{manager} AND rf.sts = '발생예정'")
	int ckrskcnt(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND rf2.cempno = #{cempno} AND rf.sts = '처리중'")
	int torskcnt(RiskSch sch);
	
	@Select("SELECT count(rf.rskNO) FROM RISK_F rf, RISKADMIN_F rf2 WHERE rf.rskno = rf2.rskno AND (rf.wempno = #{wempno} OR rf2.cempno = #{cempno}) AND rf.sts = '완료'")
	int finrskcnt(RiskSch sch);
	
	@Insert("INSERT INTO RISK_F values(rsk_seq.nextval,#{title},sysdate,NULL,#{wempno},#{writer},#{content},'발생예정')")
	int insertrsk(Risk_f ins);
	
	@Insert("INSERT INTO RISKADMIN_F VALUES(rsk_seq.currval,NULL,NULL,NULL,NULL,#{manager},#{probability},#{danger})")
	int insertrsk2(Risk_f ins);
	
	@Insert("INSERT INTO rskfile_f values(rsk_seq.currval, #{fname}, #{path}, #{fno})")
	int insertrskfile(Rskfile_f ins);
	
	Risk_f detailrsk(int rskno);
	
	@Select("SELECT fname, fno FROM rskfile_f WHERE rskno = #{rskno}")
	List<Rskfile_f> getrskfile(int rskno);
	
	@Update("UPDATE RISK_F SET uptdte = sysdate, sts = '처리중' WHERE rskno = #{rskno}")
	int dorsk(Risk_f rsk);
	
	@Update("UPDATE RISKADMIN_F SET priority = #{priority}, cempno = #{cempno}, finaldte = to_date(#{finaldteStr},'YYYY-MM-DD'), probability = #{probability}, danger = #{danger}, feedback = #{feedback} WHERE rskno = #{rskno}")
	int dorsk2(Risk_f rsk);
	
	@Update("UPDATE RISK_F set sts = '완료' where rskno = #{rskno}")
	int donersk(int rskno);
	
	// 회의록
	List<Meeting_f> metlist(MeetingSch_f sch);
	
	@Select("SELECT count(mf.METNO) FROM MEETING_F mf, EMP_MASTER_F emf, DEPT_F df WHERE mf.wempno = emf.EMPNO AND emf.DEPTNO = df.DEPTNO AND df.DEPTNO = #{deptno} and mf.title like '%'||#{title}||'%'")
	int totmet(MeetingSch_f sch);
	
	int insertmet(Meeting_f ins);
	
	@Insert("INSERT INTO metfile_f values(met_seq.currval, #{fname}, #{path}, #{fno})")
	int insertmetfile(Metfile_f ins);
	
	@Select("SELECT fno_seq.nextval FROM dual")
	int getfno();
	
	Meeting_f detailmet(int metno);
	
	@Select("SELECT fname, fno FROM metfile_f WHERE metno = #{metno}")
	List<Metfile_f> getmetfile(int metno);
	
	@Select("SELECT fno FROM metfile_f WHERE metno = #{metno}")
	List<String> getfnobynamem (int metno);
	
	int updatemet(Meeting_f upt);
	
	@Delete("DELETE FROM meeting_f WHERE metno = #{metno}")
	int deletemet(int metno);
	
	@Delete("DELETE FROM METFILE_F WHERE metno = #{metno}")
	int deletemetfile(int metno);
}
