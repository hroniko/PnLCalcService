//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hroniko.pnl.entity.other;

public abstract class AbstractCharacteristicValue<T> {
    private static final long serialVersionUID = -6524899961842198462L;
    private T value;
    private boolean modifiable = true;
    private boolean hidden;

    public AbstractCharacteristicValue() {
    }

    public T getValue() {
        return this.value;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    public boolean isModifiable() {
        return this.modifiable;
    }

    public void setModifiable(boolean isModifiable) {
        this.modifiable = isModifiable;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (this.getClass() != o.getClass()) {
            return false;
        } else {
            AbstractCharacteristicValue characteristicValue = (AbstractCharacteristicValue)o;
            if (this.getValue() == characteristicValue.getValue()) {
                return true;
            } else {
                return this.getValue() != null && characteristicValue.getValue() != null ? this.getValue().equals(characteristicValue.getValue()) : false;
            }
        }
    }

    public int hashCode() {
        return this.value == null ? 0 : this.value.hashCode();
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AbstractCharacteristicValue{");
        sb.append("class=").append(this.getClass().getSimpleName());
        sb.append(", value=").append(this.getValue());
        sb.append('}');
        return sb.toString();
    }
}
