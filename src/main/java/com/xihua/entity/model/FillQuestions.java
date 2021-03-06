package com.xihua.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Author:   lxs
 * Date:     2021/12/6 14:55
 * Description: 填空题实体类
 */
@ApiModel("填空题实体类")
@Data
public class FillQuestions implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 试题内容
     */
    @ApiModelProperty("试题内容")
    private String question;

    /**
     * 试题类型
     */
    @ApiModelProperty("试题类型")
    private Integer questionType;

    /**
     * 正确答案
     */
    @ApiModelProperty("正确答案")
    private String rightAnswer;

    /**
     * 分值
     */
    @ApiModelProperty("分值")
    private Integer score;

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
        FillQuestions other = (FillQuestions) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
                && (this.getQuestionType() == null ? other.getQuestionType() == null : this.getQuestionType().equals(other.getQuestionType()))
                && (this.getRightAnswer() == null ? other.getRightAnswer() == null : this.getRightAnswer().equals(other.getRightAnswer()))
                && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getQuestionType() == null) ? 0 : getQuestionType().hashCode());
        result = prime * result + ((getRightAnswer() == null) ? 0 : getRightAnswer().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", question=").append(question);
        sb.append(", questionType=").append(questionType);
        sb.append(", rightAnswer=").append(rightAnswer);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}