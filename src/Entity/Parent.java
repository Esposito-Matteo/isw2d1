
package Entity;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Parent implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("sha")
    @Expose
    private String sha;
    private final static long serialVersionUID = -4417433544562598914L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Parent() {
    }

    /**
     * 
     * @param sha
     * @param url
     */
    public Parent(String url, String sha) {
        super();
        this.url = url;
        this.sha = sha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Parent withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Parent withSha(String sha) {
        this.sha = sha;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).append("sha", sha).toString();
    }

}
