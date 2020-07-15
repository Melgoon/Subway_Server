package kr.or.ddit.sw.dao.cart;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.dao.registFoodMtr.IRegistFoodMtrDao;
import kr.or.ddit.sw.dao.registFoodMtr.RegistFoodMtrDaoImpl;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.cart.CartJoinProdPicVO;
import kr.or.ddit.sw.vo.cart.CartVO;
import kr.or.ddit.sw.vo.cart.CombiMtrJoinVO;
import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;
import kr.or.ddit.sw.vo.prod.CombiVO;
import kr.or.ddit.sw.vo.prod.ProdPicVO;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements ICartDao{

    //registFoodMtr.xml 연결
    private final SqlMapClient smc;
    private static ICartDao cartDao;

    private CartDaoImpl(){
        smc = SqlMapClientFactory.getInstance();
    }

    //객체 생성 및 제공
    public static ICartDao getInstance(){
        if(cartDao == null){
            cartDao = new CartDaoImpl();
        }
        return cartDao;
    }


    @Override
    public ProdPicVO selectProdPic(int prod_no) {
       ProdPicVO pv = new ProdPicVO();

        try {
            pv = (ProdPicVO) smc.queryForObject("cart.selectProdAdr",prod_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pv;
    }

    @Override
    public int insertCart(CartVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("cart.insert",vo);

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
    public List<CombiMtrJoinVO> selectCombiMtrJoin() {
        List<CombiMtrJoinVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("cart.selectCombiMtrJoin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CartVO> selectCart() {
        List<CartVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("cart.selectCart");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteCombi() {
        int cnt = 0;

        try {
            cnt = smc.delete("cart.deleteCombi");
        } catch (SQLException e) {
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<CartJoinProdPicVO> selectCartJoinProdPic(String mem_id) {
        List<CartJoinProdPicVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("cart.selectCartProdPicJoin", mem_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ProdVO selectProdName(int prod_no) {
        ProdVO pv = new ProdVO();

        try {
            pv = (ProdVO) smc.queryForObject("cart.selectProdName",prod_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pv;

    }

    @Override
    public int updateCartChk(int cart_no) {
        int cnt = 0;
        try {
            cnt = smc.update("cart.updateCartChk",cart_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public List<CartJoinProdPicVO> selectOrder(String mem_id) {
        List<CartJoinProdPicVO> list = new ArrayList<>();

        try {
            list = smc.queryForList("cart.selectOrder", mem_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertOrder(OrderVO vo) {
        int cnt = 0;

        try {
            Object obj = smc.insert("cart.insertOrder",vo);
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
    public int deleteCart(int cart_no) {
        int cnt = 0;

        try {
            cnt = smc.delete("cart.deleteCart",cart_no);
        } catch (SQLException e) {
            cnt = 0;
            e.printStackTrace();
        }
        return cnt;
    }

    @Override
    public int updateCartCHkBuy(int cart_no) {
        int cnt = 0;
        try {
            cnt = smc.update("cart.updateCartChkBuy",cart_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }


}
