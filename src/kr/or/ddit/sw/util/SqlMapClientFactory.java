package kr.or.ddit.sw.util;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlMapClientFactory {

    private static SqlMapClient smc;
    public static SqlMapClient getInstance(){

        if(smc == null){
            Reader rd;

            try{
                rd = Resources.getResourceAsReader("SqlMapConfig.xml");
                smc = SqlMapClientBuilder.buildSqlMapClient(rd);
                rd.close();
            }catch(IOException e){
                System.out.println("SqlMapClient 객체 생성 실패");
                e.printStackTrace();
            }
        }
        return smc;

    }

    public static void main(String[] args) {
        SqlMapClientFactory smc = new SqlMapClientFactory();
        System.out.println(smc);
    }
}
