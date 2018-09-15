package com.wanztudio.mvp.data.network.model;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("login")
    private String login;

    @SerializedName("password")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static class OAuth {

        @SerializedName("uid")
        private String uid;

        @SerializedName("provider")
        private String provider;

        @SerializedName("info")
        private Info info;

        public void setUid(String uid){
            this.uid = uid;
        }

        public String getUid(){
            return uid;
        }

        public void setProvider(String provider){
            this.provider = provider;
        }

        public String getProvider(){
            return provider;
        }

        public void setInfo(Info info){
            this.info = info;
        }

        public Info getInfo(){
            return info;
        }

        @Override
        public String toString(){
            return
                    "RegisterAuthPost{" +
                            "uid = '" + uid + '\'' +
                            ",provider = '" + provider + '\'' +
                            ",info = '" + info + '\'' +
                            "}";
        }

        public static class Info {

            @SerializedName("image")
            private String image;

            @SerializedName("name")
            private String name;

            @SerializedName("email")
            private String email;

            public void setImage(String image){
                this.image = image;
            }

            public String getImage(){
                return image;
            }

            public void setName(String name){
                this.name = name;
            }

            public String getName(){
                return name;
            }

            public void setEmail(String email){
                this.email = email;
            }

            public String getEmail(){
                return email;
            }

            @Override
            public String toString(){
                return
                        "Info{" +
                                "image = '" + image + '\'' +
                                ",name = '" + name + '\'' +
                                ",email = '" + email + '\'' +
                                "}";
            }
        }
    }

}

