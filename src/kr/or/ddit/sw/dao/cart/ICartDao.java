package kr.or.ddit.sw.dao.cart;

import kr.or.ddit.sw.vo.cart.CartJoinProdPicVO;
import kr.or.ddit.sw.vo.cart.CartVO;
import kr.or.ddit.sw.vo.cart.CombiMtrJoinVO;
import kr.or.ddit.sw.vo.coupon.CouponPicVO;
import kr.or.ddit.sw.vo.foodmtr.MtrPicVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;
import kr.or.ddit.sw.vo.prod.CombiVO;
import kr.or.ddit.sw.vo.prod.ProdPicVO;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.util.List;

public interface ICartDao {
    public ProdPicVO selectProdPic(int prod_no);
    public int insertCart(CartVO vo);
    public List<CombiMtrJoinVO> selectCombiMtrJoin();
    public List<CartVO> selectCart();
    public int deleteCombi();
    public List<CartJoinProdPicVO> selectCartJoinProdPic(String mem_id);
    public ProdVO selectProdName(int prod_no);
    public int updateCartChk(int cart_no);
    public List<CartJoinProdPicVO> selectOrder(String mem_id);
    public int insertOrder(OrderVO vo);
    public int deleteCart(int cart_no);
    public int updateCartCHkBuy(int cart_no);



}
