package kr.co.bit.vo;

public class BlogVO {
    private String id;
    private String blogTitle;
    private String logoFile;

    public BlogVO(String id, String blogTitle, String logoFile) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.logoFile = logoFile;
    }

    public BlogVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
    }

    @Override
    public String toString() {
        return "BlogVO{" +
                "id='" + id + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", logoFile='" + logoFile + '\'' +
                '}';
    }
}
