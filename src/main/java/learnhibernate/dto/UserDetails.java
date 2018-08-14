package learnhibernate.dto;

import javax.persistence.*;
import java.util.Date;

//@Entity(name = "USER_DETAILS")
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    //@Column(name = "USER_ID")
    private int userId;

    //@Column(name = "USER_NAME")
    //@Transient
    private String userName;

    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    private String address;

    @Lob
    private String desciption;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", joinedDate=" + joinedDate +
                ", address='" + address + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }
}
