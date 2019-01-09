package org.seckill.entity;

public class UserLoginEntity {
        private Integer id;
        private Integer status;
        private String user;
        private String password;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "UserLoginDao{" +
                    "id=" + id +
                    ", status=" + status +
                    ", user='" + user + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

}
