package kr.or.ddit.sw.dao.review;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.notice.NoticeVO;
import kr.or.ddit.sw.vo.review.ReviewVO;

import java.sql.SQLException;
import java.util.List;

public class ReviewDaoImpl implements IReviewDao {

    private SqlMapClient smc;
    private static ReviewDaoImpl dao;

    private ReviewDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static IReviewDao getInstance() {
        if (dao == null)
            dao = new ReviewDaoImpl();
        return dao;
    }

    @Override
    public int insertReview(ReviewVO rv) {
        int cnt = 0;
        try {
            Object obj = smc.insert("review.insertReview", rv);
            if (obj == null) {
                cnt = 1;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<ReviewVO> selectReviewAll() {
        List<ReviewVO> list = null;

        try {
            list = smc.queryForList("review.selectReviewAll");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteReview(ReviewVO rv) {
        int cnt = 0;

        try {
            cnt = smc.delete("review.deleteReview", rv);
        } catch (SQLException e) {
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int updateReview(ReviewVO rv) {
        int cnt = 0;
        try {
            cnt = smc.update("review.updateReview", rv);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cnt;
    }
}
