package kr.or.ddit.sw.server;

import kr.or.ddit.sw.service.cart.CartServiceImpl;
import kr.or.ddit.sw.service.cart.ICartService;
import kr.or.ddit.sw.service.alarm.AlarmServiceImpl;
import kr.or.ddit.sw.service.alarm.IAlarmService;
import kr.or.ddit.sw.service.chat.ChatServerImpl;
import kr.or.ddit.sw.service.chatpass.IOwnerChatPassService;
import kr.or.ddit.sw.service.chatpass.OwnerChatPassImService;
import kr.or.ddit.sw.service.coupon.CouponServiceImpl;
import kr.or.ddit.sw.service.coupon.ICouponService;
import kr.or.ddit.sw.service.delivery.DeliveryServiceImpl;
import kr.or.ddit.sw.service.delivery.IDeliveryService;
import kr.or.ddit.sw.service.honeycombi.HoneyCombiService;
import kr.or.ddit.sw.service.honeycombi.IHoneyCombiService;
import kr.or.ddit.sw.service.join.*;
import kr.or.ddit.sw.service.managementOwner.IManagementOwnerService;
import kr.or.ddit.sw.service.managementOwner.ManagementOwnerServiceImpl;
import kr.or.ddit.sw.service.menuintro.IMenuIntroService;
import kr.or.ddit.sw.service.menuintro.MenuIntroServiceImpl;
import kr.or.ddit.sw.service.orderhis.IOrderHisService;
import kr.or.ddit.sw.service.orderhis.OrderHisServiceImpl;
import kr.or.ddit.sw.service.ordertable.IOrderTableService;
import kr.or.ddit.sw.service.ordertable.OrderTableServiceImpl;
//import kr.or.ddit.sw.service.orderhis.IOrderHisService;
//import kr.or.ddit.sw.service.orderhis.OrderHisServiceImpl;
import kr.or.ddit.sw.service.owner.IOwnerService;
import kr.or.ddit.sw.service.owner.OwnerServiceImpl;
//import kr.or.ddit.sw.service.pay.IOrderHisReservationDeliService;
//import kr.or.ddit.sw.service.pay.IPayService;
//import kr.or.ddit.sw.service.pay.OrderHisReservationDeliServiceImpl;
//import kr.or.ddit.sw.service.pay.PayServiceImpl;
import kr.or.ddit.sw.service.pay.IPayService;
import kr.or.ddit.sw.service.pay.PayServiceImpl;
import kr.or.ddit.sw.service.regAdvertise.IRegAdvertiseService;
import kr.or.ddit.sw.service.regAdvertise.RegAdvertiseSeviceImpl;
import kr.or.ddit.sw.service.login.ILoginEmailService;
import kr.or.ddit.sw.service.login.ILoginService;
import kr.or.ddit.sw.service.login.LoginEmailServiceImpl;
import kr.or.ddit.sw.service.login.LoginServiceImpl;
import kr.or.ddit.sw.service.notice.INoticeService;
import kr.or.ddit.sw.service.notice.NoticeServiceImpl;
import kr.or.ddit.sw.service.registFoodMtr.IRegistFoodMtrService;
import kr.or.ddit.sw.service.registFoodMtr.RegistFoodMtrServiceImpl;
import kr.or.ddit.sw.service.registProd.IRegistProdService;
import kr.or.ddit.sw.service.registProd.RegistProdServiceImpl;
import kr.or.ddit.sw.service.reservation.IReservationService;
import kr.or.ddit.sw.service.reservation.ReservationServiceImpl;
import kr.or.ddit.sw.service.review.IReviewService;
import kr.or.ddit.sw.service.review.ReviewServiceImpl;
import kr.or.ddit.sw.service.sales.ISalesService;
import kr.or.ddit.sw.service.sales.SalesServiceImpl;
import kr.or.ddit.sw.service.stamp.IStampService;
import kr.or.ddit.sw.service.stamp.StampServiceImpl;
import kr.or.ddit.sw.service.tellsub.ITellSubService;
import kr.or.ddit.sw.service.tellsub.TellSubServiceImpl;
import kr.or.ddit.sw.service.tellsubmem.ITellsubMemService;
import kr.or.ddit.sw.service.tellsubmem.TellsubMemSerivceIm;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {
    public static void main(String[] args) {


        //인터페이스 객체 생성
        try {
            Registry reg = LocateRegistry.createRegistry(7774);


            IJoinService join = JoinServiceImpl.getInstance();
            reg.rebind("join", join);
            IIdCheckService idcheck = IdCheckServiceImpl.getInstance();
            reg.rebind("idcheck", idcheck);
            IJoinEmailService emailService = JoinEmailServiceImpl.getInstance();
            reg.rebind("emailService", emailService);
            IRegistFoodMtrService foodMtr = RegistFoodMtrServiceImpl.getInstance();
            reg.rebind("foodMtr", foodMtr);
            IRegistProdService prod = RegistProdServiceImpl.getInstance();
            reg.rebind("prod", prod);
            IRegAdvertiseService advertise = RegAdvertiseSeviceImpl.getInstance();
            reg.rebind("advertise", advertise);
            ILoginService login = LoginServiceImpl.getInstance();
            IAlarmService readAlarm = AlarmServiceImpl.getInstance();

            ITellsubMemService tellsubmem = TellsubMemSerivceIm.getInstance();
            reg.rebind("tellsubmem", tellsubmem);

            IManagementOwnerService owner = ManagementOwnerServiceImpl.getInstance();
            reg.rebind("owner", owner);
            IStampService stamp = StampServiceImpl.getInstance();
            reg.rebind("stamp", stamp);
            ICouponService coupon = CouponServiceImpl.getInstance();
            reg.rebind("coupon", coupon);

            IOwnerChatPassService ownerPass = OwnerChatPassImService.getInstance();
            reg.rebind("ownerPass", ownerPass);
            ChatServerImpl Server = new ChatServerImpl();
            reg.rebind("RMIChatServer", Server);

            reg.rebind("join", join);
            reg.rebind("idcheck", idcheck);
            reg.rebind("emailService", emailService);
            reg.rebind("foodMtr", foodMtr);
            reg.rebind("login", login);
            ITellSubService tell = TellSubServiceImpl.getInstance();
            reg.rebind("tell", tell);
            ILoginEmailService idpwfind = LoginEmailServiceImpl.getInstance();
            reg.rebind("idpwfind", idpwfind);
            IDeliveryService delivery = DeliveryServiceImpl.getInstance();
            reg.rebind("delivery", delivery);
            IReservationService reservation = ReservationServiceImpl.getInstance();
            reg.rebind("reservation", reservation);
            IPayService pay = PayServiceImpl.getInstance();
            reg.rebind("pay", pay);

            IOrderHisService orderhis = OrderHisServiceImpl.getInstance();
            reg.rebind("orderhis", orderhis);

            /*
            IOrderHisReservationDeliService ohrd = OrderHisReservationDeliServiceImpl.getInsetance();
            reg.rebind("ohrd",ohrd);*/

            IHoneyCombiService iHoneyCombiService = HoneyCombiService.getInstance();
            reg.rebind("honey", iHoneyCombiService);
            INoticeService notice = NoticeServiceImpl.getInstance();
            reg.rebind("notice", notice);
            IReviewService review = ReviewServiceImpl.getInstance();
            reg.rebind("review", review);
            IMenuIntroService service = MenuIntroServiceImpl.getInstance();
            reg.rebind("menuList", service);
            IOrderTableService orderTableService = OrderTableServiceImpl.getInstance();
            reg.rebind("orderTableService", orderTableService);
            ICartService cart = CartServiceImpl.getInstance();
            reg.rebind("cart", cart);
            reg.rebind("alarm", readAlarm);
            IOwnerService ownerService = OwnerServiceImpl.getInstance();
            reg.rebind("ownerService", ownerService);

            ISalesService iSalesService = SalesServiceImpl.getInstance();
            reg.rebind("sales",iSalesService);

        } catch (RemoteException e) {
            System.out.println("에러입니다....");
            e.printStackTrace();
        }

        System.out.println("행복한 샌드위치 서브웨이 서버입니다.");
    }
}
