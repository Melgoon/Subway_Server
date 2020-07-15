package kr.or.ddit.sw.dao.review;

import kr.or.ddit.sw.vo.review.ReviewVO;

import java.util.List;

public interface IReviewDao {

    public int insertReview(ReviewVO rv);

    public List<ReviewVO> selectReviewAll();

    public int deleteReview(ReviewVO rv);

    public int updateReview(ReviewVO rv);

}
