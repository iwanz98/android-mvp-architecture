package com.wanztudio.mvp.data.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class LoginResponse{

    @SerializedName("customer")
    private Customer customer;

    @SerializedName("token")
    private String token;

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    @Override
    public String toString(){
        return
                "RegisterLoginResponse{" +
                        "customer = '" + customer + '\'' +
                        ",token = '" + token + '\'' +
                        "}";
    }

    public static class Customer{

        @SerializedName("image")
        private Image image;

        @SerializedName("security_question_answer")
        private Object securityQuestionAnswer;

        @SerializedName("cus_type")
        private Object cusType;

        @SerializedName("gender")
        private Object gender;

        @SerializedName("authentication_token")
        private String authenticationToken;

        @SerializedName("identity_number_image")
        private Image.Thumb identityNumberImage;

        @SerializedName("created_at")
        private String createdAt;

        @SerializedName("security_question_id")
        private Object securityQuestionId;

        @SerializedName("identity_number")
        private String identityNumber;

        @SerializedName("uid")
        private String uid;

        @SerializedName("notification")
        private boolean notification;

        @SerializedName("discarded_at")
        private String discardedAt;

        @SerializedName("updated_at")
        private String updatedAt;

        @SerializedName("provider")
        private String provider;

        @SerializedName("dob")
        private Object dob;

        @SerializedName("name")
        private String name;

        @SerializedName("phone_number")
        private Object phoneNumber;

        @SerializedName("id")
        private int id;

        @SerializedName("email")
        private String email;

        @SerializedName("username")
        private Object username;

        @SerializedName("phone_code")
        private String phoneCode;

        public void setImage(Image image){
            this.image = image;
        }

        public Image getImage(){
            return image;
        }

        public void setSecurityQuestionAnswer(Object securityQuestionAnswer){
            this.securityQuestionAnswer = securityQuestionAnswer;
        }

        public Object getSecurityQuestionAnswer(){
            return securityQuestionAnswer;
        }

        public void setCusType(Object cusType){
            this.cusType = cusType;
        }

        public Object getCusType(){
            return cusType;
        }

        public void setGender(Object gender){
            this.gender = gender;
        }

        public Object getGender(){
            return gender;
        }

        public void setAuthenticationToken(String authenticationToken){
            this.authenticationToken = authenticationToken;
        }

        public String getAuthenticationToken(){
            return authenticationToken;
        }

        public void setIdentityNumberImage(Image.Thumb identityNumberImage){
            this.identityNumberImage = identityNumberImage;
        }

        public Image.Thumb getIdentityNumberImage(){
            return identityNumberImage;
        }

        public void setCreatedAt(String createdAt){
            this.createdAt = createdAt;
        }

        public String getCreatedAt(){
            return createdAt;
        }

        public void setSecurityQuestionId(Object securityQuestionId){
            this.securityQuestionId = securityQuestionId;
        }

        public Object getSecurityQuestionId(){
            return securityQuestionId;
        }

        public void setIdentityNumber(String identityNumber){
            this.identityNumber = identityNumber;
        }

        public String getIdentityNumber(){
            return identityNumber;
        }

        public void setUid(String uid){
            this.uid = uid;
        }

        public String getUid(){
            return uid;
        }

        public void setNotification(boolean notification){
            this.notification = notification;
        }

        public boolean isNotification(){
            return notification;
        }

        public void setDiscardedAt(String discardedAt){
            this.discardedAt = discardedAt;
        }

        public String getDiscardedAt(){
            return discardedAt;
        }

        public void setUpdatedAt(String updatedAt){
            this.updatedAt = updatedAt;
        }

        public String getUpdatedAt(){
            return updatedAt;
        }

        public void setProvider(String provider){
            this.provider = provider;
        }

        public String getProvider(){
            return provider;
        }

        public void setDob(Object dob){
            this.dob = dob;
        }

        public Object getDob(){
            return dob;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void setPhoneNumber(Object phoneNumber){
            this.phoneNumber = phoneNumber;
        }

        public Object getPhoneNumber(){
            return phoneNumber;
        }

        public void setId(int id){
            this.id = id;
        }

        public int getId(){
            return id;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public String getEmail(){
            return email;
        }

        public void setUsername(Object username){
            this.username = username;
        }

        public Object getUsername(){
            return username;
        }

        public void setPhoneCode(String phoneCode){
            this.phoneCode = phoneCode;
        }

        public String getPhoneCode(){
            return phoneCode;
        }

        @Override
        public String toString(){
            return
                    "Customer{" +
                            "image = '" + image + '\'' +
                            ",security_question_answer = '" + securityQuestionAnswer + '\'' +
                            ",cus_type = '" + cusType + '\'' +
                            ",gender = '" + gender + '\'' +
                            ",authentication_token = '" + authenticationToken + '\'' +
                            ",identity_number_image = '" + identityNumberImage + '\'' +
                            ",created_at = '" + createdAt + '\'' +
                            ",security_question_id = '" + securityQuestionId + '\'' +
                            ",identity_number = '" + identityNumber + '\'' +
                            ",uid = '" + uid + '\'' +
                            ",notification = '" + notification + '\'' +
                            ",discarded_at = '" + discardedAt + '\'' +
                            ",updated_at = '" + updatedAt + '\'' +
                            ",provider = '" + provider + '\'' +
                            ",dob = '" + dob + '\'' +
                            ",name = '" + name + '\'' +
                            ",phone_number = '" + phoneNumber + '\'' +
                            ",id = '" + id + '\'' +
                            ",email = '" + email + '\'' +
                            ",username = '" + username + '\'' +
                            ",phone_code = '" + phoneCode + '\'' +
                            "}";
        }
    }

    public static class Image {

        @SerializedName("small_thumb")
        private Thumb smallThumb;

        @SerializedName("thumb")
        private Thumb thumb;

        @SerializedName("url")
        private String url;

        public void setSmallThumb(Thumb smallThumb){
            this.smallThumb = smallThumb;
        }

        public Thumb getSmallThumb(){
            return smallThumb;
        }

        public void setThumb(Thumb thumb){
            this.thumb = thumb;
        }

        public Thumb getThumb(){
            return thumb;
        }

        public void setUrl(String url){
            this.url = url;
        }

        public String getUrl(){
            return url;
        }

        @Override
        public String toString(){
            return
                    "Image{" +
                            "small_thumb = '" + smallThumb + '\'' +
                            ",thumb = '" + thumb + '\'' +
                            ",url = '" + url + '\'' +
                            "}";
        }

        public static class Thumb {

            @SerializedName("url")
            private String url;

            public void setUrl(String url){
                this.url = url;
            }

            public String getUrl(){
                return url;
            }

            @Override
            public String toString(){
                return
                        "Thumb{" +
                                "url = '" + url + '\'' +
                                "}";
            }
        }
    }
}

