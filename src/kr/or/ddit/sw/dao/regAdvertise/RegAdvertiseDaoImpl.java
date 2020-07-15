package kr.or.ddit.sw.dao.regAdvertise;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.advertise.AdvertiseVO;

import java.sql.SQLException;

public class RegAdvertiseDaoImpl implements IRegAdvertiseDao {

    //registFoodMtr.xml 연결
    private final SqlMapClient smc;
    private static IRegAdvertiseDao regAdvertiseDao;

    private RegAdvertiseDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    //객체 생성 및 제공
    public static IRegAdvertiseDao getInstance(){
        if(regAdvertiseDao == null){
            regAdvertiseDao = new RegAdvertiseDaoImpl();
        }
        return regAdvertiseDao;
    }


    @Override
    public int insertAdvertise(AdvertiseVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("advertise.insertPic",vo);

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

}
