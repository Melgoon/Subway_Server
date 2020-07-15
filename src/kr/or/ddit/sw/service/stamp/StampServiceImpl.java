package kr.or.ddit.sw.service.stamp;

import kr.or.ddit.sw.dao.registFoodMtr.IRegistFoodMtrDao;
import kr.or.ddit.sw.dao.registFoodMtr.RegistFoodMtrDaoImpl;
import kr.or.ddit.sw.dao.stamp.IStampDao;
import kr.or.ddit.sw.dao.stamp.StampDaoImpl;
import kr.or.ddit.sw.service.registFoodMtr.IRegistFoodMtrService;
import kr.or.ddit.sw.service.registFoodMtr.RegistFoodMtrServiceImpl;
import kr.or.ddit.sw.vo.coupon.CouponHisVO;
import kr.or.ddit.sw.vo.coupon.CouponPicVO;
import kr.or.ddit.sw.vo.coupon.CouponVO;
import kr.or.ddit.sw.vo.member.MemberVO;
import kr.or.ddit.sw.vo.stamp.StampHisVO;
import kr.or.ddit.sw.vo.stamp.StampVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StampServiceImpl extends UnicastRemoteObject implements IStampService {
    private final IStampDao iStampDao;
    private static IStampService service;

    public StampServiceImpl() throws RemoteException {
        super();
        iStampDao = StampDaoImpl.getInstance();
    }

    public static IStampService getInstance() throws RemoteException {
        if (service == null) {
            service = new StampServiceImpl();
        }
        return service;
    }

    @Override
    public StampHisVO findStampNumbers(String mem_id) throws RemoteException {
        StampHisVO vo = new StampHisVO();
        vo = iStampDao.findStampNumbers(mem_id);
        return vo;
    }

    @Override
    public List<CouponPicVO> selectCoupon(String mem_id) throws RemoteException {
        List<CouponPicVO> list = new ArrayList<>();
        list = iStampDao.selectCoupon(mem_id);
        return list;
    }

    @Override
    public int insertCoupon(CouponVO vo) throws RemoteException {
        return iStampDao.insertCoupon(vo);
    }

    @Override
    public int insertCouponHis(CouponHisVO vo) throws RemoteException {
        return iStampDao.insertCouponHis(vo);
    }

    @Override
    public int updateStamp(StampHisVO vo) throws RemoteException {
        return iStampDao.updateStamp(vo);
    }

    @Override
    public List<MemberVO> findMemberId() throws RemoteException {
        return iStampDao.findMemberId();
    }

    @Override
    public int insertCouponB(CouponVO vo) throws RemoteException {
        return iStampDao.insertCouponB(vo);
    }

    @Override
    public int insertStamp(StampHisVO vo) throws RemoteException {
        return iStampDao.insertStamp(vo);
    }
}
