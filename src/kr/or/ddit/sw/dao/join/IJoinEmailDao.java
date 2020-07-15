package kr.or.ddit.sw.dao.join;

import java.rmi.Remote;

public interface IJoinEmailDao {
    void emailCheck(String email, Integer num);
}
