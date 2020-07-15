package kr.or.ddit.sw.dao.sales;

public interface ISalesDao {
    public int deliveryNo(String jiJum);
    public int deliveryPr(String jiJum);
    public int deliveryChatNo(String jiJum, int chart_no);
    public String deliveryChatPr(String jiJum, int chart_no);


    public int reservationNo(String jiJum);
    public int reservationPr(String jiJum);
    public int reservationChatNo(String jiJum, int chart_no);
    public String reservationChatPr(String jiJum, int chart_no);

}
