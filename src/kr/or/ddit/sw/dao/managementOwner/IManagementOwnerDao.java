package kr.or.ddit.sw.dao.managementOwner;

import kr.or.ddit.sw.vo.owner.OwnerVO;

import java.util.List;

public interface IManagementOwnerDao {
    public List<OwnerVO> selectOwner();

    public int updateOwner(OwnerVO vo);
}
