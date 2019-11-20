package com.personal.pojo;

import java.util.Date;
import java.util.List;

/**
 * 工作经历
 */
public class JobExperience {
    private String CompanyName;//企业名称
    private String position;//职位名称
    private Date beginDate;//开始日期
    private int month;//工作了几个月

    private List<NUser> nUsers;

    public List<NUser> getnUsers() {
        return nUsers;
    }

    public void setnUsers(List<NUser> nUsers) {
        this.nUsers = nUsers;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "JobExperience{" +
                "CompanyName='" + CompanyName + '\'' +
                ", position='" + position + '\'' +
                ", beginDate=" + beginDate +
                ", month=" + month +
                '}';
    }
}
