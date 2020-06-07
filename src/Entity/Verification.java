package Entity;

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
    private Object signature;
    @SerializedName("payload")
    @Expose
    private Object payload;
    private final static long serialVersionUID = 3992008113113718335L;

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
        this.signature = signature;
        this.payload = payload;
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

    public Object getSignature() {
        return signature;
    }

    public void setSignature(Object signature) {
        this.signature = signature;
    }

    public Verification withSignature(Object signature) {
        this.signature = signature;
        return this;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public Verification withPayload(Object payload) {
        this.payload = payload;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("verified", verified).append("reason", reason).append("signature", signature).append("payload", payload).toString();
    }

}
