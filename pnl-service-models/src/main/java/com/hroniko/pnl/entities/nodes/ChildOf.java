package com.hroniko.pnl.entities.nodes;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

@Edge("childof")
public class ChildOf {

    @Id
    private String id;

    @From
    private CalcNode child;

    @To
    private CalcNode parent;

    public ChildOf(final CalcNode child, final CalcNode parent) {
        super();
        this.child = child;
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public ChildOf setId(String id) {
        this.id = id;
        return this;
    }

    public CalcNode getChild() {
        return child;
    }

    public ChildOf setChild(CalcNode child) {
        this.child = child;
        return this;
    }

    public CalcNode getParent() {
        return parent;
    }

    public ChildOf setParent(CalcNode parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("parent", parent)
                .append("child", child)
                .toString();
    }
}
