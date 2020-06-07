
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Element implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("sha")
    @Expose
    private String sha;
    @SerializedName("node_id")
    @Expose
    private String nodeId;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("commit")
    @Expose
    private Commit commit;
    @SerializedName("author")
    @Expose
    private Author_ author;
    @SerializedName("committer")
    @Expose
    private Committer_ committer;
    @SerializedName("parents")
    @Expose
    private List<Parent> parents = new ArrayList<Parent>();
    private final static long serialVersionUID = -3188403420123156961L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Element() {
    }

    /**
     * 
     * @param commentsUrl
     * @param committer
     * @param author
     * @param htmlUrl
     * @param commit
     * @param sha
     * @param nodeId
     * @param url
     * @param parents
     */
    public Element(String url, String sha, String nodeId, String htmlUrl, String commentsUrl, Commit commit, Author_ author, Committer_ committer, List<Parent> parents) {
        super();
        this.url = url;
        this.sha = sha;
        this.nodeId = nodeId;
        this.htmlUrl = htmlUrl;
        this.commentsUrl = commentsUrl;
        this.commit = commit;
        this.author = author;
        this.committer = committer;
        this.parents = parents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Element withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Element withSha(String sha) {
        this.sha = sha;
        return this;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Element withNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Element withHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
        return this;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public Element withCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
        return this;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public Element withCommit(Commit commit) {
        this.commit = commit;
        return this;
    }

    public Author_ getAuthor() {
        return author;
    }

    public void setAuthor(Author_ author) {
        this.author = author;
    }

    public Element withAuthor(Author_ author) {
        this.author = author;
        return this;
    }

    public Committer_ getCommitter() {
        return committer;
    }

    public void setCommitter(Committer_ committer) {
        this.committer = committer;
    }

    public Element withCommitter(Committer_ committer) {
        this.committer = committer;
        return this;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public Element withParents(List<Parent> parents) {
        this.parents = parents;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).append("sha", sha).append("nodeId", nodeId).append("htmlUrl", htmlUrl).append("commentsUrl", commentsUrl).append("commit", commit).append("author", author).append("committer", committer).append("parents", parents).toString();
    }

}
