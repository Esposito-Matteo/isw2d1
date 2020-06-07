package it.uniroma2.matteoesposito.d1.entities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Verification implements Serializable
{

    @SerializedName("verified")
    @Expose
    private boolean verified;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("signature")
    @Expose
    private static final  long serialVersionUID = 3992008113113718335L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Verification() {
    }

    /**
     * 
     * @param reason
     * @param signature
     * @param payload
     * @param verified
     */
    public Verification(boolean verified, String reason, Object signature, Object payload) {
        super();
        this.verified = verified;
        this.reason = reason;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Verification withVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Verification withReason(String reason) {
        this.reason = reason;
        return this;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this).append("verified", verified).append("reason", reason).toString();
    }

}
