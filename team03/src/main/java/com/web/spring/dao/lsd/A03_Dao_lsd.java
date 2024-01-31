package com.web.spring.dao.lsd;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.spring.vo.NoticeFile_f;
import com.web.spring.vo.NoticeSch_f;
import com.web.spring.vo.Noticeboard_f;

/*
Noticeboard_f 
private int notice_num;
private String writer;
private String content;
private Date regDate;
private Date updateDate;
private String title;
*/
/*public class NoticeFile_f 
private int no;
private String fname;
private String path;
private Date regdte;
private Date uptdte;
private String etc;
*/
@Mapper
public interface A03_Dao_lsd {
	/*
	 * 공지 전체 List<Noticeboard_f> getNoticeboard(Noticeboard_f sch);
	 * 
	 * @Select("select * from Noticeboard_f") List<Noticeboard_f>
	 * noticePage(NoticeSch_f sch);
	 */

	// 검색
	@Select(" select * from Noticeboard_f where title like '%'||#{title}||'%' ")
	List<Noticeboard_f> noticeSch(Noticeboard_f sch);

	// 페이징 처리, 전체조회
	@Select("select * \r\n" + "		from(\r\n" + "		SELECT rownum cnt, nf.*\r\n"
			+ "		from Noticeboard_f nf\r\n" + "		where 1=1\r\n" + "		and title like '%'||#{title}||'%' \r\n"
			+ "		and writer like '%'||#{writer}||'%' \r\n)" + "		WHERE cnt BETWEEN #{start} AND #{end}")
	List<Noticeboard_f> noticePage(NoticeSch_f sch);

	// 총 데이터건수
	@Select("SELECT count(*) FROM Noticeboard_f WHERE 1=1 AND title LIKE '%'||#{title}||'%'AND writer LIKE '%'||#{writer}||'%'")
	int totNotice(NoticeSch_f sch);

	// 공지 세부
	@Select("select * from Noticeboard_f where notice_num=#{notice_num}")
	Noticeboard_f noticeboardDetail(@Param("notice_num") int notice_num);

	// 공지 등록
	@Insert("insert into Noticeboard_f values(board_seq.nextval,#{writer},#{content},sysdate,sysdate,#{title},0)")
	int insertNotice(Noticeboard_f ins);

	// 공지 수정
	@Update("update Noticeboard_f set content=#{content},updateDate=sysdate,"
			+ "title=#{title} where notice_num = #{notice_num}")
	int updateNotice(Noticeboard_f notice);

	// 공지 삭제
	@Delete("delete from Noticeboard_f where notice_num=#{notice_num}")
	int deleteNotice(@Param("notice_num") int notice_num);

	// 공지 파일 전체
	@Select("SELECT fname FROM NoticeFile_f WHERE NO = #{no}")
	List<String> getNoticeFile(int no);

	// 공지 파일 등록
	@Insert("INSERT INTO NoticeFile_f values(board_seq.currval,\r\n" + "#{fname},#{path},sysdate,sysdate,#{etc})")
	int insertNoticeFile(NoticeFile_f ins);

	// 공지 파일 삭제
	@Delete("delete from NoticeFile_f where no=#{no}")
	int deleteNoticeFile(int no);

	// 조회수
	@Update("update Noticeboard_f set readcnt = readcnt+1 where notice_num=#{notice_num}")
	int readCntUptNotice(@Param("notice_num") int notice_num);
}// A03_Dao_lsd{}
