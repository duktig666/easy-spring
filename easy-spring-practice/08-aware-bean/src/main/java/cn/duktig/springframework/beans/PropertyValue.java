package cn.duktig.springframework.beans;

/**
 * description: bean对象的属性值
 *
 * @author RenShiWei
 * Date: 2021/8/25 17:21
 **/
public class PropertyValue {

    /** 属性名 */
    private final String name;

    /** 属性值PropertyValues */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

