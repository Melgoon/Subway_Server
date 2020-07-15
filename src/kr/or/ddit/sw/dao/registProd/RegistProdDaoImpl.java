package kr.or.ddit.sw.dao.registProd;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.prod.CombiVO;
import kr.or.ddit.sw.vo.prod.KategoriVO;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistProdDaoImpl implements IRegistProdDao{

    //registFoodMtr.xml 연결
    private final SqlMapClient smc;
    private static IRegistProdDao registProdDao;

    private RegistProdDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    //객체 생성 및 제공
    public static IRegistProdDao getInstance(){
        if(registProdDao == null){
            registProdDao = new RegistProdDaoImpl();
        }
        return registProdDao;
    }

    @Override
    public List<ProdVO> selectProd() {
        List<ProdVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("prod.select");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<KategoriVO> selectKategori() {
        List<KategoriVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("prod.selectKategori");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<FoodMtrVO> selectMtr(Integer mtr_div) {
        List<FoodMtrVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("prod.selectMtr",mtr_div);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertProd(ProdVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("prod.insertProd",vo);

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
    public int insertCombi(CombiVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("prod.insertCombi",vo);

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
    public int deleteProd(ProdVO vo) {
        int cnt = 0;

        try {
            cnt = smc.delete("prod.delete",vo);
        } catch (SQLException e) {
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int deleteCombi(Integer prod_no) {
        int cnt = 0;

        try {
            cnt = smc.delete("prod.deleteCombi",prod_no);
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<CombiVO> selectCombi() {
        List<CombiVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("prod.selectCombi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
