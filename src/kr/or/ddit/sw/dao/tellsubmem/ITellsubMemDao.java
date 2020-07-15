package kr.or.ddit.sw.dao.tellsubmem;

import kr.or.ddit.sw.vo.tellsub.TellSubMemVO;
import kr.or.ddit.sw.vo.tellsub.TellSubVO;

import java.rmi.RemoteException;
import java.util.List;

public interface ITellsubMemDao {
    public int insertTellsubMem(String user_id);
    public List<TellSubVO> selectUnionTell(String user_id);
    public int updateTellsubMem(TellSubMemVO vo);
    public TellSubVO selectDetail(int tellSub_no);
    public int selectTellSubNO(String user_id);


}
