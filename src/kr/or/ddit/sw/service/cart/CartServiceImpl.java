package kr.or.ddit.sw.service.cart;

import kr.or.ddit.sw.dao.cart.CartDaoImpl;
import kr.or.ddit.sw.dao.cart.ICartDao;
import kr.or.ddit.sw.dao.ordertable.IOrderTableDao;
import kr.or.ddit.sw.dao.ordertable.OrderTableDaoImpl;
import kr.or.ddit.sw.service.ordertable.IOrderTableService;
import kr.or.ddit.sw.service.ordertable.OrderTableServiceImpl;
import kr.or.ddit.sw.vo.cart.CartJoinProdPicVO;
import kr.or.ddit.sw.vo.cart.CartVO;
import kr.or.ddit.sw.vo.cart.CombiMtrJoinVO;
import kr.or.ddit.sw.vo.ordertable.OrderVO;
import kr.or.ddit.sw.vo.prod.CombiVO;
import kr.or.ddit.sw.vo.prod.ProdPicVO;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CartServiceImpl extends UnicastRemoteObject implements ICartService {

    private ICartDao dao;
    private static ICartService service;

    private CartServiceImpl() throws RemoteException {
        super();
        dao = CartDaoImpl.getInstance();
    }

    public static ICartService getInstance() throws RemoteException {
        if(service == null){
            service = new CartServiceImpl();
        }
        return service;
    }

    @Override
    public ProdPicVO selectProdPic(int prod_no) throws RemoteException {
        return dao.selectProdPic(prod_no);
    }

    @Override
    public int insertCart(CartVO vo) throws RemoteException {
        return dao.insertCart(vo);
    }

    @Override
    public List<CombiMtrJoinVO> selectCombiMtrJoin() throws RemoteException {
        return dao.selectCombiMtrJoin();
    }

    @Override
    public List<CartVO> selectCart() throws RemoteException {
        return dao.selectCart();
    }

    @Override
    public int deleteCombi() throws RemoteException {
        return dao.deleteCombi();
    }

    @Override
    public List<CartJoinProdPicVO> selectCartJoinProdPic(String mem_id) throws RemoteException {
        return dao.selectCartJoinProdPic(mem_id);
    }

    @Override
    public ProdVO selectProdName(int prod_no) throws RemoteException {
        return dao.selectProdName(prod_no);
    }

    @Override
    public int updateCartChk(int cart_no) throws RemoteException {
        return dao.updateCartChk(cart_no);
    }

    @Override
    public List<CartJoinProdPicVO> selectOrder(String mem_id) throws RemoteException {
        return dao.selectOrder(mem_id);
    }

    @Override
    public int insertOrder(OrderVO vo) throws RemoteException {
        return dao.insertOrder(vo);
    }

    @Override
    public int deleteCart(int cart_no) throws RemoteException {
        return dao.deleteCart(cart_no);
    }

    @Override
    public int updateCartCHkBuy(int cart_no) throws RemoteException {
        return dao.updateCartCHkBuy(cart_no);
    }

}
