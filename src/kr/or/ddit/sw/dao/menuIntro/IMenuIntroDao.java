package kr.or.ddit.sw.dao.menuIntro;

import kr.or.ddit.sw.vo.prod.ProdVO;

import java.util.List;

public interface IMenuIntroDao {
    public List<ProdVO> selectAll();
    public List<ProdVO> selectKate(int kate);
}
