package kr.or.ddit.sw.service.review;

import kr.or.ddit.sw.dao.review.IReviewDao;
import kr.or.ddit.sw.dao.review.ReviewDaoImpl;
import kr.or.ddit.sw.vo.review.ReviewVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ReviewServiceImpl extends UnicastRemoteObject implements IReviewService {

    private IReviewDao dao;
    private  static IReviewService service;

    private  ReviewServiceImpl() throws RemoteException {
        super();
        dao = ReviewDaoImpl.getInstance();;
    }

    public static IReviewService getInstance() throws RemoteException {
        if ( service == null ) {
                service = new ReviewServiceImpl();
        }
        return service;
    }




    @Override
    public int insertReview(ReviewVO rv) throws RemoteException {
        return dao.insertReview(rv);
    }

    @Override
    public List<ReviewVO> selectReviewAll() throws RemoteException {
        return dao.selectReviewAll();
    }

    @Override
    public int deleteReview(ReviewVO rv) throws RemoteException {
        return dao.deleteReview(rv);
    }

    @Override
    public int updateReview(ReviewVO rv) throws RemoteException {
        return dao.updateReview(rv);
    }
}
