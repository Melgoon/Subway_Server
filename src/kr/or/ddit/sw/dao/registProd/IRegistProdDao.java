package kr.or.ddit.sw.dao.registProd;

import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.prod.CombiVO;
import kr.or.ddit.sw.vo.prod.KategoriVO;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.util.List;

public interface IRegistProdDao {

    public List<ProdVO> selectProd();

    public List<KategoriVO> selectKategori();

    public List<FoodMtrVO> selectMtr(Integer mtr_div);

    public int insertProd(ProdVO vo);

    public int insertCombi(CombiVO vo);

    public int deleteProd(ProdVO vo);

    public int deleteCombi(Integer prod_no);

    public List<CombiVO> selectCombi();


}
