/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Nur Fatihah
 */
public class CustomerBean {
    
    public String custName;
    public String custEmail;
    public String custPassword;
    public String custPhoneNum;

    public CustomerBean(){
        
    }
    
    public CustomerBean(String custName, String custEmail, String custPassword, String custPhoneNum) {
        this.custName = custName;
        this.custEmail = custEmail;
        this.custPassword = custPassword;
        this.custPhoneNum = custPhoneNum;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustEmail() {
        return custEmail;
    }
    
    public String getCustPassword() {
        return custPassword;
    }

    public String getCustPhoneNum() {
        return custPhoneNum;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustEmaill(String custEmail) {
        this.custEmail = custEmail;
    }
    
    public void setUserPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public void setCustPhoneNum(String custPhoneNum) {
        this.custPhoneNum = custPhoneNum;
    }    
}