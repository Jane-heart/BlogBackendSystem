package online.tuanzi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName t_blog
 */
@TableName(value ="t_blog")
@Data
public class Blog implements Serializable {
    /**
     * 博客ID
     */
    @TableId(value = "blog_id", type = IdType.AUTO)
    private Integer blogId;

    /**
     * 作者ID
     */
    @TableField(value = "author_id")
    private Integer authorId;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 图片链接
     */
    @TableField(value = "image_link")
    private String imageLink;

    /**
     * 发表时间
     */
    @TableField(value = "publish_time")
    private Date publishTime;

    /**
     * 分类，博客分类
     */
    @TableField(value = "classification")
    private String classification;

    /**
     * 权限：0仅自己可见，1公开
     */
    @TableField(value = "permission")
    private Integer permission;

    /**
     * 博客状态码：0未发布，1未审核，2审核通过，3审核失败，4已删除
     */
    @TableField(value = "blog_status_code")
    private Integer blogStatusCode;

    /**
     * 原因：什么状态什么原因
     */
    @TableField(value = "reason")
    private String reason;

    /**
     * 内容
     */
    @TableField(value = "content")
    private byte[] content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Blog other = (Blog) that;
        return (this.getBlogId() == null ? other.getBlogId() == null : this.getBlogId().equals(other.getBlogId()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getImageLink() == null ? other.getImageLink() == null : this.getImageLink().equals(other.getImageLink()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getClassification() == null ? other.getClassification() == null : this.getClassification().equals(other.getClassification()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getBlogStatusCode() == null ? other.getBlogStatusCode() == null : this.getBlogStatusCode().equals(other.getBlogStatusCode()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (Arrays.equals(this.getContent(), other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlogId() == null) ? 0 : getBlogId().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getImageLink() == null) ? 0 : getImageLink().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getClassification() == null) ? 0 : getClassification().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getBlogStatusCode() == null) ? 0 : getBlogStatusCode().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + (Arrays.hashCode(getContent()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogId=").append(blogId);
        sb.append(", authorId=").append(authorId);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", imageLink=").append(imageLink);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", classification=").append(classification);
        sb.append(", permission=").append(permission);
        sb.append(", blogStatusCode=").append(blogStatusCode);
        sb.append(", reason=").append(reason);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
