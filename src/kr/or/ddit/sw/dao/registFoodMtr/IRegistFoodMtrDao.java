package kr.or.ddit.sw.dao.registFoodMtr;

import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.foodmtr.MtrPicVO;

import java.util.List;

public interface IRegistFoodMtrDao {
    public int insertFoodMtr(FoodMtrVO vo);

    public int insertFoodMtrPic(MtrPicVO vo);

    public List<FoodMtrVO> selectFoodMtr();

    public int deleteFoodMtr(FoodMtrVO vo);
}
