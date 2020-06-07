
package it.uniroma2.matteoesposito.d1.entities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Commit implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("committer")
    @Expose
    private Author committer;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("tree")
    @Expose
    private Tree tree;
    @SerializedName("comment_count")
    @Expose
    private int commentCount;
    @SerializedName("verification")
    @Expose
    private Verification verification;
    private static final  long serialVersionUID = 5831862254545793003L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Commit() {
    }

    /**
     * 
     * @param committer
     * @param author
     * @param tree
     * @param message
     * @param url
     * @param verification
     * @param commentCount
     */
    public Commit(String url, Author author, Author committer, String message, Tree tree, int commentCount, Verification verification) {
        super();
        this.url = url;
        this.author = author;
        this.committer = committer;
        this.message = message;
        this.tree = tree;
        this.commentCount = commentCount;
        this.verification = verification;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Commit withUrl(String url) {
        this.url = url;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Commit withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Author getCommitter() {
        return committer;
    }

    public void setCommitter(Author committer) {
        this.committer = committer;
    }

    public Commit withCommitter(Author committer) {
        this.committer = committer;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Commit withMessage(String message) {
        this.message = message;
        return this;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public Commit withTree(Tree tree) {
        this.tree = tree;
        return this;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Commit withCommentCount(int commentCount) {
        this.commentCount = commentCount;
        return this;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public Commit withVerification(Verification verification) {
        this.verification = verification;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).append("author", author).append("committer", committer).append("message", message).append("tree", tree).append("commentCount", commentCount).append("verification", verification).toString();
    }

}
