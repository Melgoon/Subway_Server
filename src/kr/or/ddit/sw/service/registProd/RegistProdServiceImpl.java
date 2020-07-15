package kr.or.ddit.sw.service.registProd;

import kr.or.ddit.sw.dao.registProd.IRegistProdDao;
import kr.or.ddit.sw.dao.registProd.RegistProdDaoImpl;
import kr.or.ddit.sw.vo.foodmtr.FoodMtrVO;
import kr.or.ddit.sw.vo.prod.CombiVO;
import kr.or.ddit.sw.vo.prod.KategoriVO;
import kr.or.ddit.sw.vo.prod.ProdVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RegistProdServiceImpl extends UnicastRemoteObject implements IRegistProdService {

    private final IRegistProdDao registProdDao;
    private static IRegistProdService service;

    public RegistProdServiceImpl() throws RemoteException {
        super();
        registProdDao = RegistProdDaoImpl.getInstance();
    }

    public static IRegistProdService getInstance() throws RemoteException {
        if (service == null) {
            service = new RegistProdServiceImpl();
        }
        return service;
    }



    @Override
    public List<ProdVO> selectProd() throws RemoteException{
        return registProdDao.selectProd();
    }

    @Override
    public List<KategoriVO> selectKategori() throws RemoteException {
        return registProdDao.selectKategori();
    }

    @Override
    public List<FoodMtrVO> selectMtr(Integer mtr_div) throws RemoteException {
        return registProdDao.selectMtr(mtr_div);
    }

    @Override
    public int insertProd(ProdVO vo) throws RemoteException {
        return registProdDao.insertProd(vo);
    }

    @Override
    public int insertCombi(CombiVO vo) throws RemoteException {
        return registProdDao.insertCombi(vo);
    }

    @Override
    public int deleteProd(ProdVO vo) throws RemoteException {
        return registProdDao.deleteProd(vo);
    }

    @Override
    public int deleteCombi(Integer prod_no) throws RemoteException {
        return registProdDao.deleteCombi(prod_no);
    }

    @Override
    public List<CombiVO> selectCombi() throws RemoteException {
        return registProdDao.selectCombi();
    }


}
