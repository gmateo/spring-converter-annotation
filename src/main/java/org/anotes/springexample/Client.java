package org.anotes.springexample;

import java.util.Date;

/**
 * User: gmc
 * Date: 14/03/13
 */
public class Client {
    private String name;
    private String gender;
    private String address;
    private Date subscriptionDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Client");
        sb.append("{name='").append(name).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", subscriptionDate=").append(subscriptionDate);
        sb.append('}');
        return sb.toString();
    }
}
