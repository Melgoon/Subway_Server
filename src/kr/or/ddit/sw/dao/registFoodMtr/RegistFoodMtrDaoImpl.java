package kr.or.ddit.sw.dao.registFoodMtr;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.foodmtr.MtrPicVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistFoodMtrDaoImpl implements IRegistFoodMtrDao {

    //registFoodMtr.xml 연결
    private final SqlMapClient smc;
    private static IRegistFoodMtrDao registFoodMtrDao;

    private RegistFoodMtrDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    //객체 생성 및 제공
    public static IRegistFoodMtrDao getInstance(){
        if(registFoodMtrDao == null){
            registFoodMtrDao = new RegistFoodMtrDaoImpl();
        }
        return registFoodMtrDao;
    }

    @Override
    public int insertFoodMtr(FoodMtrVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("foodMtr.insert",vo);

            if(obj == null){
                cnt = 1;
            }else{
                System.out.println("생성실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;

    }

    @Override
    public int insertFoodMtrPic(MtrPicVO vo) {

        int cnt = 0;

        try {
            Object obj = smc.insert("foodMtr.insertPic",vo);

            if(obj == null){
                cnt = 1;
            }else{
                System.out.println("생성실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }


    @Override
    public List<FoodMtrVO> selectFoodMtr() {
        List<FoodMtrVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("foodMtr.select");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteFoodMtr(FoodMtrVO vo) {
        int cnt = 0;

        try {
            cnt = smc.delete("foodMtr.delete",vo);
        } catch (SQLException e) {
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }


}
