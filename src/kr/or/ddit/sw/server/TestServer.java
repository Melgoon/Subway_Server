package kr.or.ddit.sw.server;

import kr.or.ddit.sw.service.tellsub.ITellSubService;
import kr.or.ddit.sw.service.tellsub.TellSubServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestServer {
    public static void main(String[] args) {
      /*  try {
            Registry reg = LocateRegistry.createRegistry(7787);
            ITellSubService tell = TellSubServiceImpl.getInstance();
            reg.rebind("tell", tell);
        } catch (RemoteException e) {
            System.out.println("에러입니다....");
            e.printStackTrace();
        }
        System.out.println("행복한 샌드위치 서브웨이 서버입니다.");*/
    }
}
