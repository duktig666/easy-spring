package cn.duktig.springframework.test.bean;

/**
 * description:测试的用户业务类
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:41
 **/
public class UserService {

    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        return name;
    }

}

