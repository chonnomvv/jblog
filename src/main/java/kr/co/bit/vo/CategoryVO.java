package kr.co.bit.vo;

public class CategoryVO {

    private int cateNo;
    private String id;
    private String cateName;
    private String description;
    private String regDate;
    private int cateCount;

    public int getCateCount() {
        return cateCount;
    }

    public void setCateCount(int cateCount) {
        this.cateCount = cateCount;
    }

    public int getCateNo() {
        return cateNo;
    }

    public void setCateNo(int cateNo) {
        this.cateNo = cateNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public CategoryVO(int cateNo, String id, String cateName, String description, String regDate) {
        this.cateNo = cateNo;
        this.id = id;
        this.cateName = cateName;
        this.description = description;
        this.regDate = regDate;
    }

    public CategoryVO() {
    }

    @Override
    public String toString() {
        return "CategoryVO{" +
                "cateNo=" + cateNo +
                ", id='" + id + '\'' +
                ", cateName='" + cateName + '\'' +
                ", description='" + description + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }

    public CategoryVO(int cateNo, String id, String cateName, String description, String regDate, int cateCount) {
        this.cateNo = cateNo;
        this.id = id;
        this.cateName = cateName;
        this.description = description;
        this.regDate = regDate;
        this.cateCount = cateCount;
    }
}
