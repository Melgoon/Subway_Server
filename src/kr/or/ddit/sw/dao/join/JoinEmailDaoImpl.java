package kr.or.ddit.sw.dao.join;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JoinEmailDaoImpl implements IJoinEmailDao {
    private static IJoinEmailDao dao;

    public static IJoinEmailDao getInstance() {
        if (dao == null) {
            dao = new JoinEmailDaoImpl();
        }
        return dao;
    }

    @Override
    public void emailCheck(String email, Integer num) {
        String user = "brinst83@gmail.com";
        String password = "dkfqkdu123";

        //SMTP 서버 정보를 설정한다.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            //수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            //Subject
            message.setSubject("[Subway] 인증번호입니다."); //메일 제목 입력하기

            //Text
            message.setText(num + "를 입력해주세요");

            //전송하는 부분
            Transport.send(message);
            System.out.println("전송이 완료되었습니다.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("메일 오류발생....");
        }

    }
}
