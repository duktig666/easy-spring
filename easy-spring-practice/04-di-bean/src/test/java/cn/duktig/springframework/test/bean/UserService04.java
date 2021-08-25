package cn.duktig.springframework.test.bean;

/**
 * description:测试的用户业务类
 *
 * @author RenShiWei
 * Date: 2021/8/25 14:41
 **/
public class UserService04 {

    private String uId;

    private UserDao04 userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao04 getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao04 userDao) {
        this.userDao = userDao;
    }

}

