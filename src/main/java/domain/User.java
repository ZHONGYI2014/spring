package domain;

/**
 * domain 领域
 * 从现实中抽取出来的虚拟对象
 */
public class User {

    private String userName;
    private String userPhone;
    private String userEmail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public User(){}

    public User(String userName, String userPhone, String userEmail) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }
}
