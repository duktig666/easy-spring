package cn.duktig.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/8/25 17:42
 **/
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("10001", "duktig1号");
        hashMap.put("10002", "duktig2号");
        hashMap.put("10003", "duktig3号");
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}

