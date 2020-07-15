package kr.or.ddit.sw.dao.managementOwner;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.owner.OwnerVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagementOwnerDaoImpl implements IManagementOwnerDao {

    //registFoodMtr.xml 연결
    private final SqlMapClient smc;
    private static IManagementOwnerDao managementOwnerDao;

    private ManagementOwnerDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    //객체 생성 및 제공
    public static IManagementOwnerDao getInstance(){
        if(managementOwnerDao == null){
            managementOwnerDao = new ManagementOwnerDaoImpl();
        }
        return managementOwnerDao;
    }


    @Override
    public List<OwnerVO> selectOwner() {
        List<OwnerVO> list = new ArrayList<>();
        try {
            list = smc.queryForList("owner.select");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateOwner(OwnerVO vo) {
        int cnt = 0;
        try {
            cnt = smc.update("owner.update",vo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }
}
