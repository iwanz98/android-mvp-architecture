package com.wanztudio.mvp.data.db.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Entity(nameInDb = "stores")
public class StoreAddress {

    @SerializedName("id")
    @Id(autoincrement = true)
    private long id;

    @SerializedName("country")
    @Property(nameInDb = "country")
    private String country;

    @SerializedName("address")
    @Property(nameInDb = "address")
    private String address;

    @SerializedName("is_primary")
    @Property(nameInDb = "is_primary")
    private boolean isPrimary;

    @SerializedName("city")
    @Property(nameInDb = "city")
    private String city;

    @SerializedName("latitude")
    @Property(nameInDb = "latitude")
    private String latitude;

    @SerializedName("address_id")
    @Property(nameInDb = "address_id")
    private int addressId;

    @SerializedName("created_at")
    @Property(nameInDb = "created_at")
    private int createdAt;

    @SerializedName("state_province")
    @Property(nameInDb = "state_province")
    private String stateProvince;

    @SerializedName("store")
    @Property(nameInDb = "store")
    private String store;

    @SerializedName("url")
    @Property(nameInDb = "url")
    private String url;

    @SerializedName("updated_at")
    @Property(nameInDb = "updated_at")
    private long updatedAt;

    @SerializedName("discarded_at")
    @Property(nameInDb = "discarded_at")
    private long discardedAt;

    @SerializedName("name")
    private String name;

    @SerializedName("phone_number")
    @Property(nameInDb = "phone_number")
    private String phoneNumber;

    @SerializedName("customer_id")
    @Property(nameInDb = "customer_id")
    private int customerId;

    @SerializedName("postal_code")
    @Property(nameInDb = "postal_code")
    private String postalCode;

    @SerializedName("phone_code")
    @Property(nameInDb = "phone_code")
    private String phoneCode;

    @SerializedName("longitude")
    @Property(nameInDb = "longitude")
    private String longitude;

    @Generated(hash = 1680321477)
    public StoreAddress(long id, String country, String address, boolean isPrimary,
            String city, String latitude, int addressId, int createdAt, String stateProvince,
            String store, String url, long updatedAt, long discardedAt, String name,
            String phoneNumber, int customerId, String postalCode, String phoneCode,
            String longitude) {
        this.id = id;
        this.country = country;
        this.address = address;
        this.isPrimary = isPrimary;
        this.city = city;
        this.latitude = latitude;
        this.addressId = addressId;
        this.createdAt = createdAt;
        this.stateProvince = stateProvince;
        this.store = store;
        this.url = url;
        this.updatedAt = updatedAt;
        this.discardedAt = discardedAt;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.customerId = customerId;
        this.postalCode = postalCode;
        this.phoneCode = phoneCode;
        this.longitude = longitude;
    }

    @Generated(hash = 1403328690)
    public StoreAddress() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsPrimary() {
        return this.isPrimary;
    }

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getAddressId() {
        return this.addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public String getStateProvince() {
        return this.stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getStore() {
        return this.store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDiscardedAt() {
        return this.discardedAt;
    }

    public void setDiscardedAt(long discardedAt) {
        this.discardedAt = discardedAt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneCode() {
        return this.phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
