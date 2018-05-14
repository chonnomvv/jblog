package kr.co.bit.vo;

public class UsersVO {

    private int userNo;
    private String id;
    private String userName;
    private String password;
    private String date;
    private String joindate;

    public UsersVO(int userNo, String id, String userName, String password, String date, String joindate) {
        this.userNo = userNo;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.date = date;
        this.joindate = joindate;
    }

    public String getJoindate() {

        return joindate;
    }

    @Override
    public String toString() {
        return "UsersVO{" +
                "userNo=" + userNo +
                ", id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", date='" + date + '\'' +
                ", joindate='" + joindate + '\'' +
                '}';
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UsersVO(int userNo, String id, String userName, String password, String date) {
        this.userNo = userNo;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.date = date;
    }

    public UsersVO(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UsersVO() {
    }

}
