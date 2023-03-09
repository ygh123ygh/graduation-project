package com.example.login.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;



    public class UserBean implements Serializable {
        private String name;
        private String account;
        private String password;
        ///private String phone;
        private String role;
        private String status;
        private String time;




    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account= account;
        }

        public String getPassword() {
            return password;
        }


       public void setPassword(String password) {
            this.password = password;
        }
       /*  public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }*/

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        @Override
        public String toString() {
            return "UserBean{" +

                    ", name='" + name + '\'' +
                    ", account='" + account + '\'' +
                    ", password='" + password + '\'' +
                    ", role='" + role + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

