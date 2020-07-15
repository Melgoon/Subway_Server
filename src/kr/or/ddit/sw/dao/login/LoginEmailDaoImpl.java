package kr.or.ddit.sw.dao.login;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.sw.util.SqlMapClientFactory;
import kr.or.ddit.sw.vo.member.MemberVO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.Properties;

public class LoginEmailDaoImpl implements ILoginEmailDao {
    private static ILoginEmailDao dao;
    private final SqlMapClient smc;

    private LoginEmailDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static ILoginEmailDao getInstance() {
        if (dao == null) {
            dao = new LoginEmailDaoImpl();

        }
        return dao;
    }

    @Override
    public void emailCheck(String email) {
        String user = "brinst83@gmail.com";
        String password = "dkfqkdu123";

        //SMTP 서버 정보를 설정한다.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        MemberVO vo = null;
        try {
            vo = (MemberVO) smc.queryForObject("member.idpwfind", email);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String mem_id = vo.getMEM_ID();
        String mem_pw = vo.getMEM_PW();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            //수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            //Subject
            message.setSubject("[Subway] 아이디 비밀번호 찾기."); //메일 제목 입력하기

            //Text
            message.setText("id : " + mem_id + "  pw : " + mem_pw);

            //전송하는 부분
            Transport.send(message);
            System.out.println("전송이 완료되었습니다.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("메일 오류발생....");
        }

    }
}
